package tingeso2.sueldosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SueldosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SueldosServiceApplication.class, args);
	}

}
