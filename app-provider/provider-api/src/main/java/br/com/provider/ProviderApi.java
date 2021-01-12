/**
 * 
 */
package br.com.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author cbgomes
 *
 */
@SpringBootApplication(scanBasePackages = { "br.com.provider.controller", "br.com.provider.service" })
@EnableJpaRepositories("br.com.provider.repository.*")
@EntityScan("br.com.provider.*")
public class ProviderApi {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderApi.class, args);
		
	}
}
