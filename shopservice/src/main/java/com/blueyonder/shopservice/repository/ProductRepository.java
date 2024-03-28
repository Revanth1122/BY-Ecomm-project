package com.blueyonder.shopservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.shopservice.entity.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
	@Query(value="select * from product_info c where c.prod_name=?",nativeQuery=true)
	 Product findProductByName(String pname);
	
	
}
