package com.abc.bootthymeleaf.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.abc.bootthymeleaf.model.Student;
import com.abc.bootthymeleaf.service.StudentService;

@Controller
public class StudentController{
	@Autowired
	StudentService studentService;
	@GetMapping("/ih")
public String viewInsertHTML()
{
	return "insert.html";
}
	@PostMapping("/insert")
	@ResponseBody
	public String add(@ModelAttribute Student student)
	{
//		System.out.println(student);
		 studentService.add(student);
		 return "data inserted";
	}
	@GetMapping("/fall")
	public String fetchAll(ModelMap map) 
	{  
		List<Student>list=studentService.fetchAll();
//		return list;
		map.addAttribute("data", list);
		return "view.html";
		
	}
	
	@GetMapping("/id/{sid}")
	@ResponseBody
	public Student fetchById(@PathVariable Long sid) {
	    return studentService.fetchById(sid);
	}

	}

//https://localghost:1012/insert.html
