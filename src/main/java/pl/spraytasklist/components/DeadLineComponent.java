package pl.spraytasklist.components;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DeadLineComponent {
	
	@Bean
	public String convertToString() {
		String test = "test";
		return test;
	}
}
