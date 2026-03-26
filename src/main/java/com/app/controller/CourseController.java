package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.app.model.Course;
import com.app.service.CourseService;

@RestController
@CrossOrigin
@RequestMapping("/Course")
public class CourseController {

	@Autowired
	private CourseService service;

	@PostMapping
	public Course addUnit(@RequestBody Course Course) {
		return service.addUnit(Course);
	}

	@GetMapping
	public List<Course> getAllUnits() {
		return service.getAllUnits();
	}

	@PutMapping("/{id}")
	public Course updateUnit(@PathVariable int id, @RequestBody Course Course) {
		Course.setId(id);
		return service.updateUnit(Course);
	}

	@DeleteMapping("/{id}")
	public String deleteUnit(@PathVariable int id) {
		service.deleteUnit(id);
		return "Course record deleted";
	}
}
