package tingeso2.marcasrelojservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tingeso2.marcasrelojservice.services.FileStorageProperties;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class MarcasRelojServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarcasRelojServiceApplication.class, args);
	}

}
