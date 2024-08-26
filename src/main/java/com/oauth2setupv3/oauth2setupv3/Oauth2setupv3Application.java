package com.oauth2setupv3.oauth2setupv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.oauthsetup.reposervice.repo")
@EntityScan("com.oauthsetup.reposervice.entities")
@SpringBootApplication(scanBasePackages = {"com.oauthsetup.authservice", "com.oauthsetup.resourceservice", "com.oauth2setupv3","com.oauthsetup.reposervice"})
public class Oauth2setupv3Application {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2setupv3Application.class, args);
	}
}
