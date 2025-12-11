package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CatalogsInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogsInfoServiceApplication.class, args);
	}

	/** @LoadBalanced: Annotation to mark a RestTemplate or WebClient bean to be configured to use a LoadBalancerClient. 
	 	* It does service discovery in a load balanced way. 
	 	* Now, we can use Eureka Registered services URLs not actual URLs. 
	*/
	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
