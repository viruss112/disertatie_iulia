package org.example.proiect_disertatie.mapper;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.dto.request.UserRegisterDto;
import org.example.proiect_disertatie.domain.dto.response.UserResponseDto;
import org.example.proiect_disertatie.domain.entities.User;
import org.example.proiect_disertatie.domain.enums.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

  private final PasswordEncoder passwordEncoder;

  public User toEntity(UserRegisterDto userRegisterDto) {
    return new User()
        .setUsername(userRegisterDto.getUsername())
        .setPassword(passwordEncoder.encode(userRegisterDto.getPassword()))
        .setEmail(userRegisterDto.getEmail())
        .setFirstName(userRegisterDto.getFirstName())
        .setLastName(userRegisterDto.getLastName())
        .setIsActive(true)
        .setLastLogin(Instant.now())
        .setUserRole(UserRole.USER);
  }

  public UserResponseDto toResponseDto(User user) {
    return (UserResponseDto) new UserResponseDto()
        .setId(user.getId())
        .setUsername(user.getUsername())
        .setEmail(user.getEmail())
        .setFirstName(user.getFirstName())
        .setLastName(user.getLastName())
        .setLastLogin(user.getLastLogin())
        .setUserRole(String.valueOf(user.getUserRole()))
        .setSuccessful(true);
  }

}
