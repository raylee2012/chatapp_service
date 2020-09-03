package com.example.chatapp_main;

import com.example.chatapp_main.config.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileProperties.class
})
public class ChatappMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatappMainApplication.class, args);
	}

}
