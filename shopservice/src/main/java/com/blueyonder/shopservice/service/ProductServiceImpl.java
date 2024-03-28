package com.blueyonder.shopservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.shopservice.dto.ProductDto;
import com.blueyonder.shopservice.entity.Category;
import com.blueyonder.shopservice.entity.Product;

import com.blueyonder.shopservice.exceptions.ProductNotFoundException;
import com.blueyonder.shopservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository prodrepo;
	
	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	public Product addProduct(Product Product) {
		logger.info("Product created successfully...");
		return prodrepo.save(Product);
	}

	@Override
	public String deleteProductById(Integer ProductId) throws ProductNotFoundException {
		
		Product c = getProductById(ProductId);
		if(c!=null) {
			prodrepo.deleteById(ProductId);
			logger.info("product deleted successfully...(deleteProductById)");
			return "Product deleted successfully...";
		}else {
			logger.error("Product not present...(deleteProductById)");
			throw new ProductNotFoundException();
		}
	}

	@Override
	public List<ProductDto> ListAllProduct() {
		List<Product> products= (List<Product>) prodrepo.findAll();
		
		return products.stream()
                .map(product -> new ProductDto(
                        product.getProdId(),
                        product.getProdName(),
                        product.getPrice(),
                        product.getDescription(),
                        product.getCategory() != null ? product.getCategory().getCategoryName() : null))
                .toList();
	}

	@Override
	public Product getProductById(Integer ProductId) throws ProductNotFoundException {
		Optional<Product> prod = prodrepo.findById(ProductId);
		if(prod.isPresent()) {
			logger.info("product present ...(getProductById)");
			return prod.get();
		}
		logger.error("Product not present...(getProductById)");
		throw new ProductNotFoundException();
	}

	@Override
	public Product getProductByName(String cname) throws ProductNotFoundException {
		Product p = prodrepo.findProductByName(cname);
		 if(p!=null) {
			 logger.info("product present ...(getProductByName)");
			return p;
		}else {
			logger.error("Product not present...(deleteProductById)");
			throw new ProductNotFoundException();
		}
	}

	@Override
	public Product updateProductById(Product Product) {
		Product prod;
		try {
			prod = getProductById(Product.getProdId());
			if(prod!=null) {
				logger.info("product updated successfully...");
				return prodrepo.save(Product);
			}else {
				logger.error("Product not present...(getProductById)");
				throw new ProductNotFoundException();
			}
			
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
		
	}

	@Override
	public Product updateProductByName(Product Product) {
		Product prod;
		try {
			prod = getProductByName(Product.getProdName());
			if(prod!=null) {
				logger.info("product updated successfully...");
				return prodrepo.save(Product);
			}else {
				logger.error("Product not present...(getProductByName)");
				throw new ProductNotFoundException();
			}
			
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}

}
