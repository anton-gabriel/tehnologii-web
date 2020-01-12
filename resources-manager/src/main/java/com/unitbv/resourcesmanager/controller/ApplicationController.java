package com.unitbv.resourcesmanager.controller;

import com.unitbv.resourcesmanager.model.*;
import com.unitbv.resourcesmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {

//    @Autowired
//    private StudentService studentService;
//
//    @ResponseBody
//    @RequestMapping("/home")
//    public String Hello(){
//        return "Hello From Spring";
//    }
//
//    @RequestMapping("/save-student")
//    public String SaveStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String faculty, @RequestParam Integer year){
//
//        Student student = new Student(firstName, lastName, email, faculty, year);
//        studentService.SaveStudent(student);
//        return "login";
//    }
}
