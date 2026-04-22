package com.springbootdemo.SpringBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.SpringBootProject.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
