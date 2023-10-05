package org.example.service;

import org.example.criteria.StudentSearchCriteria;
import org.example.dto.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service

public class StudentService {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private final AtomicLong studentIdSequence = new AtomicLong();

    public Student save(Student student) {
        Long id = studentIdSequence.incrementAndGet();
        student.setId(id);
        studentMap.put(id, student);
        return studentMap.get(id);
    }


    public Student getById(Long id) {
        return studentMap.get(id);
    }

    public Student updateById(Long id, Student student) {
        studentMap.put(id,student);
        return studentMap.get(id);

    }

    public Student deleteById(Long id) {
        return studentMap.remove(id);
    }

    public List<Student> search(StudentSearchCriteria criteria) {
        String name = criteria.getName();
        return studentMap.values().stream().filter(student -> name == null || student.getName().startsWith(name))
                .collect(Collectors.toList());

    }
}
