package org.example.proiect_disertatie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProiectDisertatieApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProiectDisertatieApplication.class, args);
  }

}
