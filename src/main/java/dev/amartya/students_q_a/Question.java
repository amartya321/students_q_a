package dev.amartya.students_q_a;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {


    @Id
    private ObjectId id;
    private String question;
    private String subject;

    public Question(String question, String subject) {
        this.question = question;
        this.subject = subject;
    }
}
