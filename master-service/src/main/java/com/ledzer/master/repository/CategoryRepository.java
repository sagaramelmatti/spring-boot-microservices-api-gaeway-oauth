package com.ledzer.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ledzer.master.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
