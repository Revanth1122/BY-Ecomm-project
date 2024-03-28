package com.blueyonder.shopservice.service;

import java.util.List;

import com.blueyonder.shopservice.dto.ProductDto;
import com.blueyonder.shopservice.entity.Product;
import com.blueyonder.shopservice.exceptions.ProductNotFoundException;

public interface ProductService {
	
	public Product addProduct(Product Product);
	public String deleteProductById(Integer ProductId) throws ProductNotFoundException;
	public Product updateProductById(Product Product);
	public Product updateProductByName(Product Product);
	public List<ProductDto> ListAllProduct();
	public Product getProductById(Integer ProductId)throws ProductNotFoundException;
	public Product getProductByName(String cname)throws ProductNotFoundException;
}
