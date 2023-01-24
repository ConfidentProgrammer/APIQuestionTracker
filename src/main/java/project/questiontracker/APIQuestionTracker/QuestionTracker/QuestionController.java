package project.questiontracker.APIQuestionTracker.QuestionTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="api/question")
public class QuestionController {

    private final QuestionService service;


    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Question> getQuestion() {
        return service.getQuestions();
    }

    @PostMapping
    public void postQuestions(@RequestBody Question[] question) {
        service.postQuestion(question);
    }
    @PostMapping(path="api/question/postsingle")
    public void postQuestionsJson(@RequestBody Question question) {
        service.postQuestionJson(question);
    }
    @DeleteMapping(path="{questionID}")
    public void deleteQuestion(@PathVariable("questionID")  long id) {
        service.deleteQuestion(id);
    }

    @PutMapping(path="{questionID}")
    public void EditQuestion(
            @PathVariable("questionID") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String link,
            @RequestParam(required = false) String solution
    ) {
        service.updateQuestion(id, title, link, solution);
    }
}
