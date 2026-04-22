package com.springbootdemo.SpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootdemo.SpringBootProject.entity.Student;
import com.springbootdemo.SpringBootProject.repository.StudentRepo;

@Controller
@RequestMapping("/studentportal")
public class MyController {
	
	@Autowired
	StudentRepo repo;
	
	@GetMapping("/Login")
	public String display() {
		return "Login";
	}
	
	@PostMapping("/Login")
	public String checkLogin(@RequestParam("username") String username,@RequestParam("password") String password, Model model) {
		if(username.equals("Admin") && password.equals("Admin123") ) {
		model.addAttribute("username", username);
		return "Dashboard";
		}else {
			model.addAttribute("error","Invalid Username and Password ");
			return "Login";
		}
		
	}
	
	@GetMapping("/addstudent")
	public String addStudent() {
		return "addStudent";
	}
	
	@GetMapping("/showstudent")
	public String showStudent(Model model) {
		List<Student> list=repo.findAll();
		model.addAttribute("list", list);
		return "showstudent";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student s) {
		repo.save(s);
		return "redirect:/studentportal/showstudent";
	}
	
	@GetMapping("/update/{id}")
	public String updateStudent(@PathVariable int id,Model model) {
		Student s=repo.findById(id).orElse(null);
		model.addAttribute("update", s);
		return "updatestudent";
	}
	
	@PostMapping("/updatestudent")
	public String  update(@ModelAttribute Student s) {
		Student existingUser=repo.findById(s.getId()).orElseThrow();
		existingUser.setName(s.getName());
		existingUser.setRollno(s.getRollno());
		existingUser.setCity(s.getCity());
		existingUser.setGender(s.getGender());
		repo.save(existingUser);
		return "redirect:/studentportal/showstudent";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id, Model model) {
		repo.deleteById(id);
		return "redirect:/studentportal/showstudent";
	}
	
	
}
