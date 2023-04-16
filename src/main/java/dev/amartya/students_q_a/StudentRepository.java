package dev.amartya.students_q_a;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, ObjectId> {

    public Student findByrollnumber(Integer rollnumber);
}
