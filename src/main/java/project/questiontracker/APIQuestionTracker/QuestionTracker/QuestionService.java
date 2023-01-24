package project.questiontracker.APIQuestionTracker.QuestionTracker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class QuestionService {

   private final QuestionRepository repository;

   @Autowired
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<Question> getQuestions() {
       return repository.findAll();
    }


    public void postQuestion(Question[] question) {

       for(Question q : question) {
           Optional<Question> questionByLink = repository.findQuestionByLink(q.getLink());
        if(questionByLink.isPresent()) {
            throw new IllegalStateException("Question is already present");
        }
       }


        repository.saveAll(List.of(question));

        System.out.print(question);
    }

    public void postQuestionJson(Question question) {
        Optional<Question> questionByLink = repository.findQuestionByLink(question.getLink());
        if(questionByLink.isPresent()) {
            throw new IllegalStateException("Question is already present");
        }
        repository.save(question);

    }

    public void deleteQuestion(long id) {
       boolean isPresent = repository.existsById(id);

       if(!isPresent) {
           throw new IllegalStateException("cannot Delete, doesnot exists");
       }
       repository.deleteById(id);
    }

    @Transactional
    public void updateQuestion(Long id, String title, String link, String solution) {

       // if question doesnot exists
        Question question = repository.findById(id).orElseThrow(() -> new IllegalStateException("Question Doesnot exists"));

        if(title != null && title.length()>0){
            question.setTitle(title);
        }
        if(link != null && link.length()>0){
            question.setLink(link);
        }
        if(solution != null && solution.length()>0){
            question.setSolution(solution);
        }

    }


}
