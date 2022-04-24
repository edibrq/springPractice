package com.edibrq.demoapplication.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record StudentService(StudentRepository studentRepository) {
    @Autowired
    public StudentService {
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentToFind  = studentRepository.findStudentByEmail(student.getEmail());
        if (studentToFind.isPresent()) {
            throw new IllegalStateException("There's student with the same email");
        }
        studentRepository.save(student);
    }

    public void removeStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
