package tingeso2.marcasrelojservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MarcasRelojServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarcasRelojServiceApplication.class, args);
	}

}
