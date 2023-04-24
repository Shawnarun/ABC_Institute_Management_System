package com.abc.management.controller;
import com.abc.management.exception.ResourceNotFoundException;
import com.abc.management.model.student;
import com.abc.management.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;


    //Get All student Details
    @GetMapping
    public List<student> getAllStudents(){
        return studentRepo.findAll();
    }


    // Add new Student record
   @PostMapping
    public student addStduent(@RequestBody student Student){
        return studentRepo.save(Student);
    }


    // Get student record By Id
    @GetMapping("{id}")
    public ResponseEntity<student> getStudentById(@PathVariable long id)
    {
        student Student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not Exist" + id));
        return ResponseEntity.ok(Student);
    }


    //Update Record
    @PutMapping("{id}")
    public ResponseEntity<student> updateStudents(@PathVariable long id,@RequestBody student StudentDetails){
        student UpdateStudent= studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not Exist" + id));

        UpdateStudent.setName(StudentDetails.getName());
        UpdateStudent.setContact(StudentDetails.getContact());
        UpdateStudent.setAddress(StudentDetails.getAddress());
        studentRepo.save(UpdateStudent);
        return ResponseEntity.ok(UpdateStudent);

    }


    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){
        student Student =  studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not Exist" + id));

     studentRepo.delete(Student);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
