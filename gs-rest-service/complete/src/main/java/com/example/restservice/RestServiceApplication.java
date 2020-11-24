package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
        System.out.println("would you like to terminate? Press 9");
        Scanner scanner = new Scanner(System.in);
        boolean isrunning = true;
        while (isrunning == true) {
            int choice = scanner.nextInt();
            if (choice == 9) {
                System.exit(0);
            }
        }
    }


}
