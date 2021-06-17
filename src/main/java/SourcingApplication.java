import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.perfaware.sourcing"})
public class SourcingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourcingApplication.class, args);
	}

}
