package com.example.eschool.mapper;


import com.example.eschool.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> listStudent(@Param("student")Student student);
    void addStudent(@Param("student") Student student);
    void updateStudent(@Param("student") Student student);
    void deleteStudent(@Param("id") Integer id);


}
