package project.questiontracker.APIQuestionTracker.QuestionTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class QuestionConfig {
    @Bean
    CommandLineRunner commandLineRunner(QuestionRepository repo) {
        return args -> {
            Question q1 = new Question("Find triplets with zero sum",
                    "https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1?page=1&category[]=two-pointer-algorithm&sortBy=difficulty",
                    "Use hashmap and fill all the elements and then, get all the duplets summations and check if -c is present in that hashmap, where equation is a+b-c ",
                    "Two Pointers", "Basic", LocalDate.of(2001, Month.NOVEMBER, 5));

            Question q2 = new Question("Reverse a string with spaces intact",
                    "https://practice.geeksforgeeks.org/problems/reverse-a-string-with-spaces-intact5213/1?page=1&category[]=two-pointer-algorithm&sortBy=difficulty",
                    "declare i and j at 0 and n-1 respectively, when there is space i++ or j--, if not space swap the elements, and increase and decrease i and j respectively",
                    "Two Pointers", "Basic", LocalDate.of(2004, Month.NOVEMBER, 5));

           // repo.saveAll(List.of(q1,q2));
        };
    }
}
