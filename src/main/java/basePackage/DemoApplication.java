package basePackage;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
	@RequestMapping("s")
	public String method(){
		return "hello";
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}
}
