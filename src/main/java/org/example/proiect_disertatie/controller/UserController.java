package org.example.proiect_disertatie.controller;

import lombok.RequiredArgsConstructor;
import org.example.proiect_disertatie.domain.dto.request.UserActivateOrDeactivateDto;
import org.example.proiect_disertatie.domain.dto.request.UserLoginDto;
import org.example.proiect_disertatie.domain.dto.request.UserRegisterDto;
import org.example.proiect_disertatie.domain.dto.response.BaseResponse;
import org.example.proiect_disertatie.domain.dto.response.UserGetAllResponseDto;
import org.example.proiect_disertatie.domain.dto.response.UserResponseDto;
import org.example.proiect_disertatie.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  private final UserService userService;


  @PostMapping("/register")
  public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserRegisterDto userRegisterDto) {
    return ResponseEntity.ok(userService.registerUser(userRegisterDto));
  }

  @PostMapping("/login")
  public ResponseEntity<UserResponseDto> loginUser(@RequestBody UserLoginDto userLoginDto) {
    return ResponseEntity.ok(userService.getUserByUsernameAndPassword(userLoginDto));
  }

  @PutMapping("/activate-or-deactivate")
  public ResponseEntity<BaseResponse> activateOrDeactivateUser(
      @RequestBody UserActivateOrDeactivateDto userActivateOrDeactivateDto) {
    return ResponseEntity.ok(userService.updateUserActivationStatus(userActivateOrDeactivateDto));
  }

  @GetMapping("/get-all")
  public ResponseEntity<UserGetAllResponseDto> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

}
