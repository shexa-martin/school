package com.example.school.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    @PostMapping
    public Teacher registerTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
