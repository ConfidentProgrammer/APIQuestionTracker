package project.questiontracker.APIQuestionTracker.QuestionTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Query("SELECT q FROM Question q WHERE q.link = ?1")
    Optional<Question> findQuestionByLink(String url);
}
