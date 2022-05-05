package com.example.eschool.dao;

import com.example.eschool.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> listStudent(Student student);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Integer id);
}
