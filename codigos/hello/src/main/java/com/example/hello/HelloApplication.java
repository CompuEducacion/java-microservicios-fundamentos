package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloApplication.class, args);
	}

	@Bean
	public LocaleResolver localResolver(){
		SessionLocaleResolver sessionLocalResolver =
				new SessionLocaleResolver();
		sessionLocalResolver.setDefaultLocale(Locale.US);
		return sessionLocalResolver;
	}

	@Bean
	public ResourceBundleMessageSource bundleMessageSource(){
		ResourceBundleMessageSource messageSource =
				new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
