package com.example.eschool.controller;

import com.example.eschool.model.Student;
import com.example.eschool.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/")
    public String index(Model model){
        Student student = new Student();
        List<Student> studentList = studentService.listStudent(student);
        model.addAttribute("studentList",studentList);

        model.addAttribute("student",student);
        return "index";
    }


    @PostMapping(value = "/add")
    public String addStudent(
            @Param("student") Student student){
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView getStudent(
            @ModelAttribute("id") Integer id){

        ModelAndView mav = new ModelAndView("edit");

        Student student = new Student();
        student.setId(id);
        student = studentService.listStudent(student).get(0);
        mav.addObject("student",student);
        return mav;
    }

    @PostMapping(value = "update")
    public String update(
            @Param ("student")Student student){
        studentService.updateStudent(student);
        return "redirect:/";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(
            @ModelAttribute("id") Integer id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
