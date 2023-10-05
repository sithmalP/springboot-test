package org.example.controller;

import org.example.criteria.StudentSearchCriteria;
import org.example.dto.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable("id") Long id){
        return studentService.getById(id);
    }

    @PutMapping("{id}")
    public Student updateById(@PathVariable("id") Long id, @RequestBody Student student){
        return studentService.updateById(id, student);
    }

    @DeleteMapping("{id}")
    public Student deleteById(@PathVariable("id") Long id){
        return studentService.deleteById(id);
    }

    @GetMapping
    public List<Student> search(@RequestParam(required = false) String name){
        StudentSearchCriteria criteria = new StudentSearchCriteria();
        criteria.setName(name);
        return studentService.search(criteria) ;
    }
}
