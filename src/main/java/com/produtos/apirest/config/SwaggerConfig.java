package com.produtos.apirest.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
		        .apis(RequestHandlerSelectors.any())
		        .paths(PathSelectors.any())
		        .build()
		        .apiInfo(metaInfo())
		        .useDefaultResponseMessages(false)
		        .globalResponseMessage(RequestMethod.GET, responseMessageForGET());
				
	}
	
	private ApiInfo metaInfo() {
		return new ApiInfoBuilder() 
				.title("Produtos API REST")
				.description("API REST de cadastro de produtos.")
				.version("1.0")
				.contact(new Contact("Mauro Lúcio", "https://www.linkedin.com/in/mauro-l%C3%BAcio-pereira", "mauroslucios@gmail.com"))
				.license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
	}
	
	private List<ResponseMessage> responseMessageForGET()
	{
	    return new ArrayList<ResponseMessage>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
	        add(new ResponseMessageBuilder()
	            .code(500)
	            .message("500 message")
	            .responseModel(new ModelRef("Error"))
	            .build());
	        add(new ResponseMessageBuilder()
	            .code(403)
	            .message("Forbidden!")
	            .build());
	    }};
	}

	
}
	