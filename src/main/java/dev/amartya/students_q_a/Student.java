package dev.amartya.students_q_a;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private ObjectId id;
    private String name;
    private Integer rollnumber;

    public Student(String name, Integer rollnumber) {
        this.name = name;
        this.rollnumber = rollnumber;
    }
}
