package project.questiontracker.APIQuestionTracker.QuestionTracker;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Question {
    @Id
    @SequenceGenerator(
            name="question_sequence",
            sequenceName = "questions_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_sequence"
    )
    private long id;
    private String title;
    @Column(length = 1000)
    private String link;
    @Column(length = 1000)
    private String solution;

    private String type;
    private String toughness;

    private LocalDate dateSolved;

    public Question() {

    }


    public Question(String title, String link, String solution, String type, String toughness, LocalDate dateSolved) {
        this.title = title;
        this.link = link;
        this.solution = solution;
        this.type = type;
        this.toughness = toughness;
        this.dateSolved = dateSolved;
    }

    public Question(long id, String title, String link, String solution, String type, String toughness, LocalDate dateSolved) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.solution = solution;
        this.type = type;
        this.toughness = toughness;
        this.dateSolved = dateSolved;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public LocalDate getDateSolved() {
        return dateSolved;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", solution='" + solution + '\'' +
                ", type='" + type + '\'' +
                ", toughness='" + toughness + '\'' +
                ", dateSolved=" + dateSolved +
                '}';
    }

    public void setDateSolved(LocalDate dateSolved) {
        this.dateSolved = dateSolved;
    }
}
