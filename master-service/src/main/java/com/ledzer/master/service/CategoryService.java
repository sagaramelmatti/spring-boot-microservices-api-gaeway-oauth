package com.ledzer.master.service;

import java.util.List;

import com.ledzer.master.entity.Category;

public interface CategoryService {

	public List<Category> categoryList();

	public void saveCategory(Category category);

	public Category getCategoryDetails(Long id);

	public Category updateCategory(Long categoryId, Category category);

	public void deleteCategory(Long categoryId);

}
