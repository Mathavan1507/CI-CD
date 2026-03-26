package com.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.model.Course;
import com.app.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;

	protected double getRate(String plan) {
		switch (plan) {
		case "Basic":
			return 5;
		case "Standard":
			return 7;
		case "Premium":
			return 10;
		default:
			return 0;
		}
	}

	public Course addUnit(Course Course) {
		double rate = getRate(Course.getPlan());
		Course.setTotalCost(rate * Course.getUnit());
		return repository.save(Course);
	}

	public List<Course> getAllUnits() {
		return repository.findAll();
	}

	public void deleteUnit(int id) {
		repository.deleteById(id);
	}

	public Course updateUnit(Course Course) {
		Optional<Course> existing = repository.findById(Course.getId());
		if (existing.isPresent()) {
			Course updated = existing.get();
			updated.setName(Course.getName());
			updated.setPlan(Course.getPlan());
			updated.setUnit(Course.getUnit());
			double rate = getRate(Course.getPlan());
			updated.setTotalCost(rate * Course.getUnit());
			return repository.save(updated);
		} else {
			throw new RuntimeException("Course record not found with id: " + Course.getId());
		}
	}
}
