package br.com.taha.greetingservice.configuration;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("greeting-service")
@RefreshScope
@Getter
@Setter
public class GreetingConfiguration {

	private String greeting;
	private String defaultValue;
}
