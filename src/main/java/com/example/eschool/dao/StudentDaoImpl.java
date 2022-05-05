package com.example.eschool.dao;

import com.example.eschool.mapper.StudentMapper;
import com.example.eschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> listStudent(Student student) {
        return studentMapper.listStudent(student);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
    }
}
