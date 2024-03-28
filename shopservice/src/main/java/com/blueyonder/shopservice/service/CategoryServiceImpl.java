package com.blueyonder.shopservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.shopservice.entity.Category;
import com.blueyonder.shopservice.entity.Product;
import com.blueyonder.shopservice.exceptions.CategoryNotFoundException;
import com.blueyonder.shopservice.exceptions.ProductNotFoundException;
import com.blueyonder.shopservice.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryrepo;
	
	private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Override
	public Category addCategory(Category category) {
		
		logger.info("category created successfully...");
		return categoryrepo.save(category);
	}

	@Override
	public String deleteCategoryById(Integer categoryId) throws CategoryNotFoundException{
		Category c = getCategoryById(categoryId);
		if(c!=null) {
			categoryrepo.deleteById(categoryId);
			logger.info("category deleted successfully...");
			return "Category deleted successfully...";
		}else {
			logger.error("category not present..(deletecategoryById)");
			throw new CategoryNotFoundException();
		}
		
	}

	@Override
	public Iterable<Category> ListAllCategory() {
		Iterable<Category> cate= categoryrepo.findAll();
		logger.info("listing all category..");
		return cate;
	}

	@Override
	public Category getCategoryById(Integer categoryId)throws CategoryNotFoundException {
		Optional<Category> cat = categoryrepo.findById(categoryId);
		if(cat.isPresent()) {
			logger.info("category present..(getcategoryById)");
			return cat.get();
		}
		logger.error("category not present..(getcategoryById)");
		throw new CategoryNotFoundException();
	}

	@Override
	public Category getCategoryByName(String cname)throws CategoryNotFoundException {
		Category c = categoryrepo.findcategoryByName(cname);
		 if(c!=null) {
			 logger.info("category present...(getcategoryByname)");
			return c;
		}else {
			logger.error("category not present..(getcategoryById)");
			throw new CategoryNotFoundException();
		}
		
	}

	@Override
	public Category updateCategoryById(Category category){
		Category c=null;
		try {
			c = getCategoryById(category.getCategoryId());
			 if(c!=null) {
				 logger.info("Category present ...(getCategoryById)");
				return categoryrepo.save(category);
			}else {
				logger.error("Category not present...(getCategoryById)");
				throw new CategoryNotFoundException();
			}
			 
		} catch (CategoryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Category updateCategoryByName(Category category) {
		Category c=null;
		try {
			c = categoryrepo.findcategoryByName(category.getCategoryName());
			 if(c!=null) {
				 logger.info("Category present ...(findcategoryByName)");
				return categoryrepo.save(category);
			}else {
				logger.error("Category not present...(findcategoryByName)");
				throw new CategoryNotFoundException();
			}
			 
		} catch (CategoryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
