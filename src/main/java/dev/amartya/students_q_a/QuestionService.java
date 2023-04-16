package dev.amartya.students_q_a;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void addFromCSV(){
        //Need to read question from csv
        String path ="C:\\Users\\amart\\OneDrive\\Desktop\\Question.csv";
        FileReader fileReader ;
        try {
            fileReader = new FileReader(path);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();

            String[] line;
            while( (line=csvReader.readNext())!=null){
                Question question = new Question(line[0],line[1]);
                questionRepository.insert(question);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Question> allQuestion(){
        return questionRepository.findAll();
    }

    public void addQuestion(Question question){
        questionRepository.insert(question);
    }
}
