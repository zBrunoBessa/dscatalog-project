package com.brunobessa.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunobessa.dscatalog.entities.Category;
import com.brunobessa.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		List<Category> list = repository.findAll();
		return list;
	}
}
