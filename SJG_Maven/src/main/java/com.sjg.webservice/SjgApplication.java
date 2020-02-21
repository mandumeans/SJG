package com.sjg.webservice;

import com.sjg.webservice.util.MultipartFileToFileDtoConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing
@SpringBootApplication
public class SjgApplication {

	public static void main(String[] args) {
		SpringApplication.run(SjgApplication.class, args);
	}
	
	@Configuration
	static class MyConfig implements WebMvcConfigurer {
		@Override
		public void addFormatters(FormatterRegistry formatterRegistry) {
			formatterRegistry.addConverter((Converter<?, ?>) new MultipartFileToFileDtoConverter());
		}
	}
}

