package com.ledzer.master.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ledzer.master.entity.Category;
import com.ledzer.master.repository.CategoryRepository;
import com.ledzer.master.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	public List<Category> categoryList() {
		return categoryRepository.findAll();
	}
	
	public void saveCategory(Category category) {
		 categoryRepository.save(category);
		
	}
	
    public Category getCategoryDetails(Long id) {
    	return categoryRepository.findById(id).get();
	}
     
	public Category updateCategory(Long categoryId, Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategory(Long categoryId) {
		
	}
}
