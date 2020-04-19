package lk.geeks;

import lk.geeks.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("lk.geeks.config")
public class StartUp {


    public static void main(String[] args) {
        SpringApplication.run(StartUp.class,args);
    }
}
