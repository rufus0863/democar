package com.demo.democar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@OpenAPIDefinition(
		info = @Info(
				title = "Demo Car Application",
				version = "3.0",
				description = "Swagger",
				license = @License(name = "License of API", url = "API license URL"),
				contact = @Contact(url = "http://www.demo.com", name = "Demo Car SpA")
		)
)
@SpringBootApplication
public class DemoCarApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)  {
		return application.sources(DemoCarApplication.class);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(DemoCarApplication.class, args);
    }
}
