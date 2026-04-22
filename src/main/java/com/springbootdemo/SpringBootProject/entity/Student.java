package com.springbootdemo.SpringBootProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="stud_seq")
	@SequenceGenerator(initialValue = 1,allocationSize = 1,name="stud_seq")
	int id;
	int rollno;
	String name,gender,city;

}
