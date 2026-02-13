package io.github.cbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Core {
    /**
     * The entry point of the Spring Boot application.
     * <p>
     * This method starts the Spring application context by invoking
     * {@link SpringApplication#run(Class, String[])} and prints a
     * startup message to the console indicating that the application has started.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(Core.class, args);
        System.out.println("""
                
                cbs started ------------------------------------------------------------------------------------
                """);

    }
}