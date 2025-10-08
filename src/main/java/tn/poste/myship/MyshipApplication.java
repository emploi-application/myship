package tn.poste.myship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"tn.poste.myship","com.example.colispro"})
public class MyshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyshipApplication.class, args);
	}

}
