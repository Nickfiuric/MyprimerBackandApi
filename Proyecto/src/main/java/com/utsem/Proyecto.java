package com.utsem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Proyecto {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto.class, args);
	}
	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://127.0.0.1:5500") // URL de dinde se mostrara nuestra web.
						.allowedMethods("*")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};
	}

}
