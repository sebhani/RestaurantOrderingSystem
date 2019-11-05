package api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Must include annotation to identify the spring boot app
@SpringBootApplication
public class RestaurantOrderingSystemApi {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantOrderingSystemApi.class, args);

	}

}
