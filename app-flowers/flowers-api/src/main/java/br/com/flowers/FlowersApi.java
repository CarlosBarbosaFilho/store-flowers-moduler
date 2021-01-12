/**
 * 
 */
package br.com.flowers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author cbgomes
 *
 */
@SpringBootApplication(scanBasePackages = { "br.com.flowers.controller", "br.com.flowers.service" })
//@EnableJpaRepositories("br.com.acme.repository")
@EntityScan("br.com.flowers.*")
public class FlowersApi {

	public static void main(String[] args) {
		SpringApplication.run(FlowersApi.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
