package br.com.taha.greetingservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.taha.greetingservice.configuration.GreetingConfiguration;
import br.com.taha.greetingservice.model.Greeting;

@RestController
@AllArgsConstructor
public class GreetingController {

	private static final String TEMPLATE = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();

	private final GreetingConfiguration configuration;

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name",
					defaultValue = "") String name) {
		return new Greeting(
				counter.incrementAndGet(),
				String.format(TEMPLATE, this.configuration.getGreeting(), !name.isEmpty() ? name : this.configuration.getDefaultValue())
		);
	}
}
