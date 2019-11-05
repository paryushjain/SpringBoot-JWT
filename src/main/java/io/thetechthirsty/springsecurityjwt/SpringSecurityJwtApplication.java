package io.thetechthirsty.springsecurityjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.thetechthirsty.springsecurityjwt")
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
