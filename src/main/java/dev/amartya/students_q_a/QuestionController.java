package dev.amartya.students_q_a;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/allFromCSV")
    public ResponseEntity<List<Question>> addQuestionFromCSV(){
        questionService.addFromCSV();
        return new ResponseEntity<>(questionService.allQuestion(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestion(){
        return new ResponseEntity<>(questionService.allQuestion(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Question> insertQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return new ResponseEntity<>(question,HttpStatus.OK);
    }
}
