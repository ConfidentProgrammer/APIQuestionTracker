package project.questiontracker.APIQuestionTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiQuestionTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiQuestionTrackerApplication.class, args);
	}



}
