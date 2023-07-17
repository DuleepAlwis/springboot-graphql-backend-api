package com.onlinelearningplatform.onlineLearningPlatform;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan(basePackages = {"com.onlinelearningplatform.controller","com.onlinelearningplatform.service"})
@EntityScan(basePackages = {"com.onlinelearningplatform.entity"})
@EnableJpaRepositories(basePackages = {"com.onlinelearningplatform.repository"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class OnlineLearningPlatformApplication {

	public static boolean validateQuery(String query) {
		try {
			Statement statement = CCJSqlParserUtil.parse(query);
			// The query is valid
			return true;
		} catch (Throwable e) {
			// The query is invalid
			return false;
		}
	}

	public static void main(String[] args) {

		SpringApplication.run(OnlineLearningPlatformApplication.class, args);
		/*String query = "SELECT *1 FROM users WHERE age = 18";
		if (validateQuery(query)) {
			System.out.println("Query is valid");
		} else {
			System.out.println("Query is invalid");
		}*/

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/graphql").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
