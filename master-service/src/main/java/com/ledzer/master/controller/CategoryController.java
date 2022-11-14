package com.ledzer.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ledzer.master.entity.Category;
import com.ledzer.master.service.CategoryService;


@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/")
    public List<Category> categoryList() {
        return categoryService.categoryList();
    }
	
	@GetMapping("/{id}")
    public Category getCategoryDetails(@PathVariable Long id){
        Category category = categoryService.getCategoryDetails(id);
        return category;
    }
	
	@PostMapping
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }
	
	@PutMapping("/{categoryId}")
    public Category updateCategory(@PathVariable Long categoryId, @RequestBody Category category){
        return categoryService.updateCategory(categoryId,category);
    }
	
	
	@DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
	
}
