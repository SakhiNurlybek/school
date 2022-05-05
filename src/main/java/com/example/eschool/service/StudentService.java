package com.example.eschool.service;

import com.example.eschool.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> listStudent(Student student);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Integer id);
}
