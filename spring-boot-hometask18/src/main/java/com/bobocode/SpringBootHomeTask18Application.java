package com.bobocode;

import com.bobocode.annotation.EnableStringTrimming;
import com.bobocode.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableStringTrimming
public class SpringBootHomeTask18Application {

  public static void main(String[] args) {
    var context = SpringApplication.run(SpringBootHomeTask18Application.class, args);
    final HelloService helloService = context.getBean(HelloService.class);
    helloService.greeting("     Hello everybody!    ", "    new String    ", 123);
  }
}
