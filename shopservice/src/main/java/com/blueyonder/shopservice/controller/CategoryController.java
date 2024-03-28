package com.blueyonder.shopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.shopservice.entity.Category;
import com.blueyonder.shopservice.exceptions.CategoryNotFoundException;
import com.blueyonder.shopservice.service.CategoryService;


@RestController
//@CrossOrigin("*")
@RequestMapping("/ecommerce/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	@PostMapping("/add-category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category c = categoryservice.addCategory(category);
		return new ResponseEntity<Category>(c,HttpStatus.OK);
		
	}
	@GetMapping("/delete-category")
	public String deleteCategoryById(@RequestParam(name="id") Integer categoryId ) throws CategoryNotFoundException{
		 
		return categoryservice.deleteCategoryById(categoryId);
	}
	
	@GetMapping("/all-category")
	public Iterable<Category> ListAllCategory(){
		Iterable<Category> listcategory = categoryservice.ListAllCategory();
		return listcategory;
	}
	@GetMapping("/get-category")
	public ResponseEntity<Category> getCategoryById(@RequestParam(name="id") Integer categoryId) throws CategoryNotFoundException{
		Category c = categoryservice.getCategoryById(categoryId);
		return new ResponseEntity<Category>(c,HttpStatus.OK);
	}
	@GetMapping("/get-category-name")
	public ResponseEntity<Category> getCategoryByName(@RequestParam(name="name")  String cname)throws CategoryNotFoundException{
		Category c = categoryservice.getCategoryByName(cname);
		return new ResponseEntity<Category>(c,HttpStatus.OK);
	}
	@PostMapping("/update-category-by-id")
	public ResponseEntity<Category> updateCategorybyid(@RequestBody Category category) {
		Category c = categoryservice.updateCategoryById(category);
		return new ResponseEntity<Category>(c,HttpStatus.OK);
		
	}
	@PostMapping("/update-category-by-name")
	public ResponseEntity<Category> updateCategorybyname(@RequestBody Category category) {
		Category c = categoryservice.updateCategoryByName(category);
		return new ResponseEntity<Category>(c,HttpStatus.OK);
		
	}
	
}
