package br.com.erudio.StartupTests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StartupTest {

    public static void main(String[] args) {
        SpringApplication.run(br.com.erudio.Application.Startup.class, args);
    }

}
