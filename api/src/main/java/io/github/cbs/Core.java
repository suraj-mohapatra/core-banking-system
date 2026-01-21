package io.github.cbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Core {
    public static void main(String[] args) {
        SpringApplication.run(Core.class, args);
        System.out.println(
                """
                
                cbs started ------------------------------------------------------------------------------------
                """
        );

    }
}