package com.blueyonder.shopservice.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.shopservice.entity.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {
	
	@Query(value="select * from category_info c where c.category_name=?",nativeQuery=true)
	public Category findcategoryByName(String cname);
}
