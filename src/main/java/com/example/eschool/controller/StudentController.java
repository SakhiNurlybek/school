package com.example.eschool.controller;


import com.example.eschool.exception.ResourseNotFoundException;
import com.example.eschool.exception.ServiceResponse;
import com.example.eschool.model.Student;
import com.example.eschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @GetMapping("list")
    public List<Student> getAllStudents(){
        Student student = new Student();
        return this.studentService.listStudent(student);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Student> getStudent(
            @PathVariable(value = "id")Integer id) throws ResourseNotFoundException {
        Student student = new Student();
        student.setId(id);
        student = studentService.listStudent(student).get(0);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping("save")
    public ResponseEntity<Object> addStudent(
            @RequestBody Student student){
        studentService.addStudent(student);
        ServiceResponse<Student> response = new ServiceResponse<Student>("success", student);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PutMapping("update")
    public Student updateStudent(
            @RequestBody Student student){
        studentService.updateStudent(student);
        return student;
    }

    @DeleteMapping("delete/{id}")
    private void delete(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
}
