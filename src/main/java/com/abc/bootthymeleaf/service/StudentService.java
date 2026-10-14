package com.abc.bootthymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bootthymeleaf.Repository.StudentRepository;
import com.abc.bootthymeleaf.model.Student;



@Service
public class StudentService {
	
	@Autowired
StudentRepository studentRepository;
	
	public String add(Student student) {
		studentRepository.save(student);
		return "data inserted";
	}
	public List<Student>fetchAll()
	{
		List<Student>list=studentRepository.findAll();
		if(list.isEmpty()) 
			return null;
			else 
		return list;
	}
	public Student fetchById(Long sid) {
	    Optional<Student> o = studentRepository.findById(sid);
	    if(o.isPresent())
	        return o.get();
	    else
	        return null;
	}

	}


