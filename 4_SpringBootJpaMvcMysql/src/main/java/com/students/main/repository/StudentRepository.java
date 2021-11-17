package com.students.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.main.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
