package com.model2.mvc.service.product.impl;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.domain.Product;


public class ProductServiceImpl implements ProductService{
	
	private ProductDAO productDAO;
	
	public ProductServiceImpl() {
		productDAO=new ProductDAO();
	}

	public Product addProduct(Product product) throws Exception {
		productDAO.insertProduct(product);
		return product;
	}

	public Product getProduct(int prodNo) throws Exception{ 
		return productDAO.findProduct(prodNo);
	}

	public Product getProduct(String prodName) throws Exception{ 
		return productDAO.findProduct(prodName);
	}
	
	public Map<String, Object> getProductList(Search search) throws Exception{ 
		return productDAO.getProductList(search);
	}

	public Product updateProduct(Product product) throws Exception{ // 상품 정보 수정
		productDAO.updateProduct(product);
		return product;
	}

}