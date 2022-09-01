package com.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CategoryBean;
import com.repository.CategoryRepository;

@RestController
@RequestMapping("/admin")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepo;

	@GetMapping("/category")
	public ResponseEntity<?> getAllCategories() {

		List<CategoryBean> categories = categoryRepo.findAll();
		return ResponseEntity.ok(categories);
	}

	@PostMapping("/category")
	public ResponseEntity<?> addCategory(@RequestBody CategoryBean category) {
		categoryRepo.save(category);
		return ResponseEntity.ok(category);

	}

	// ? @RequestParam

	// category?categoryId=1

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<?> getCategoryDetail(@PathVariable("categoryId") Integer categoryId) {
		Optional<CategoryBean> categoryOptional = categoryRepo.findById(categoryId);
		if (categoryOptional.isPresent()) {
			CategoryBean category = categoryOptional.get();
			return ResponseEntity.ok(category);
		} else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
		Optional<CategoryBean> categoryOptional = categoryRepo.findById(categoryId);
		if (categoryOptional.isPresent()) {
			CategoryBean category = categoryOptional.get();
			categoryRepo.delete(category);
			return ResponseEntity.ok(category);
		} else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@PutMapping("/category")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryBean category) {
		categoryRepo.save(category);
		return ResponseEntity.ok(category);

	}
}