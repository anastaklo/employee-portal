package org.anastaklo.portal.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.anastaklo.portal")
@EnableJpaRepositories(basePackages = "org.anastaklo.portal.adapter.persistence")
@EntityScan(basePackages = "org.anastaklo.portal.adapter.persistence")
public class PortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

}
