package br.com.erudio.StartupTests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StartupTest {

    public static void main(String[] args) {
        SpringApplication.run(br.com.erudio.Startup.Startup.class, args);
    }

}
