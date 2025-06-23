package org.example.proiect_disertatie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.proiect_disertatie.domain.dto.request.UserActivateOrDeactivateDto;
import org.example.proiect_disertatie.domain.dto.request.UserLoginDto;
import org.example.proiect_disertatie.domain.dto.request.UserRegisterDto;
import org.example.proiect_disertatie.domain.dto.response.BaseResponse;
import org.example.proiect_disertatie.domain.dto.response.UserGetAllResponseDto;
import org.example.proiect_disertatie.domain.dto.response.UserResponseDto;
import org.example.proiect_disertatie.domain.entities.User;
import org.example.proiect_disertatie.exception.UserGeneralException;
import org.example.proiect_disertatie.mapper.UserMapper;
import org.example.proiect_disertatie.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserMapper userMapper;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;


  @Transactional(rollbackFor = UserGeneralException.class)
  public UserResponseDto registerUser(UserRegisterDto userRegisterDto) {
    try {
      var user = userMapper.toEntity(userRegisterDto);
     userRepository.save(user);
      return userMapper.toResponseDto(user);
    } catch (Exception e) {
      log.error("Error saving user:{} {}", userRegisterDto.getUsername(), e.getMessage());
      throw new UserGeneralException("Error saving user");
    }
  }

  @Transactional(rollbackFor = UserGeneralException.class)
  public UserResponseDto getUserByUsernameAndPassword(UserLoginDto userLoginDto) {
    var user = userRepository.findByUsernameAndIsActive(userLoginDto.getUsername(), true)
        .orElseThrow(() -> new UserGeneralException("User not found or inactive"));

    if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
      log.error("Invalid password for user: {}", userLoginDto.getUsername());
      throw new UserGeneralException("Invalid password for user");
    }

    return userMapper.toResponseDto(user);
  }

  @Transactional(rollbackFor = UserGeneralException.class)
  public BaseResponse updateUserActivationStatus(UserActivateOrDeactivateDto dto) {
    var user = findUserById(dto.getId());
    validateUserActivationStatus(user, dto.getIsActive());

    user.setIsActive(dto.getIsActive());
    userRepository.save(user);

    log.info("User with ID {} has been {} successfully", dto.getId(), dto.getIsActive() ? "activated" : "deactivated");
    return new BaseResponse().setSuccessful(true);
  }

  @Transactional(readOnly = true)
  public UserGetAllResponseDto getAllUsers() {
    try {
      var users = userRepository.findAll();
      var userDtos = users.stream()
          .map(userMapper::toResponseDto)
          .toList();

      return (UserGetAllResponseDto) new UserGetAllResponseDto()
          .setUsers(userDtos)
          .setSuccessful(true);
    }catch (Exception e) {
      log.error("Error retrieving all users: {}", e.getMessage());
      throw new UserGeneralException("Error retrieving all users");
    }
  }

  private User findUserById(Integer id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new UserGeneralException("User not found"));
  }

  private void validateUserActivationStatus(User user, Boolean isActive) {
    if (user.getIsActive().equals(isActive)) {
      throw new UserGeneralException(String.format("User is already %s", isActive ? "active" : "inactive"));
    }
  }


}
