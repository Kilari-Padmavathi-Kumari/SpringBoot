package com.sbrestcontroller.hello.restcontroller;

import com.sbrestcontroller.hello.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> obj;

    @PostConstruct
    public void loadData() {
        obj = new ArrayList<>();
        obj.add(new Student(1, "padma"));
        obj.add(new Student(2, "kavya"));
        obj.add(new Student(3, "josh"));
        obj.add(new Student(4, "vedha"));

    }

    @GetMapping("/student")
    public List<Student> getStudent() {

        return obj;
    }

    //retrieve
    @GetMapping("/student/{studentId}")
    public Student getstu(@PathVariable int studentId) {
        //check the stuId again list size

        if ((studentId >= obj.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("student id not found - " + studentId);
        }
        return obj.get(studentId);
    }
    // add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // create a Student ErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    // add another exception handle ..to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc)
    {
        // create a Student ErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }


}
