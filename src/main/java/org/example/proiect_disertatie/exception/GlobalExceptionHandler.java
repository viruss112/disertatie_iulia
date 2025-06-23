package org.example.proiect_disertatie.exception;


import org.example.proiect_disertatie.domain.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<ExceptionResponse> handleUserException(UserGeneralException ex) {
    return buildResponse(ex);
  }

  @ExceptionHandler
  public ResponseEntity<ExceptionResponse> handleProximityException(ProximityGeneralException ex) {
    return buildResponse(ex);
  }

  @ExceptionHandler
  public ResponseEntity<ExceptionResponse> handleTemperatureException(TemperatureGeneralException ex) {
    return buildResponse(ex);
  }

  @ExceptionHandler
  public ResponseEntity<ExceptionResponse> handleHumidityException(HumidityGeneralException ex) {
    return buildResponse(ex);
  }

  @ExceptionHandler
  public ResponseEntity<ExceptionResponse> handleLightException(LightGeneralException ex) {
    return buildResponse(ex);
  }

  private ResponseEntity<ExceptionResponse> buildResponse(Exception ex) {
    var response = new ExceptionResponse()
        .setErrorDevMessage(ex.getMessage())
        .setPublicMessage("The application is unavailable at the moment. Please try again later.")
        .setSuccessful(false);

    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body((ExceptionResponse) response);
  }
}
