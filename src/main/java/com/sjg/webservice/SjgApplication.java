package com.sjg.webservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sjg.webservice.domain.sso.OauthClients;
import com.sjg.webservice.domain.sso.OauthClientsRepository;
import com.sjg.webservice.domain.sso.Users;
import com.sjg.webservice.domain.sso.UsersRepository;
import com.sjg.webservice.util.MultipartFileToFileDtoConverter;

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
	

    @Bean
    public CommandLineRunner insertInitialData(OauthClientsRepository oauthClientsRepository, UsersRepository usersRepository) {
        return args -> { 
        	oauthClientsRepository.save(OauthClients.builder()
        								.clientId("client1")
        								.resourceIds("client1pwd")
        								.clientSecret(null)
        								.scope("read,write")
        								.authorizedGrantTypes("authorization_code,password, implicit, refresh_token")
        								.web_serverRedirectUri(null)
        								.authorities("ROLE_YOUR_CLIENT")
        								.accessTokenValidity(36000L)
        								.refreshTokenValidity(2592000L)
        								.additionalInformation(null)
        								.autoapprove(null)
        								.build());
        	usersRepository.save(Users.builder()
        						.userName("user1")
        						.password("$2a$10$6q7Ep3WbSkc4iOLVl1ZEFO1fLga0xR.Z82uVGInJKHZClsJvUZOkq")
        						.userType("2")
        						.build());
        };
    }
}

