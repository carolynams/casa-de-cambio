package com.example.casadecambio.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CasaDeCambioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasaDeCambioApplication.class, args);
    }

}
