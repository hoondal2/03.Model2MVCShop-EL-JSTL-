package com.model2.mvc.service.product;

import java.util.HashMap;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


public interface ProductService {
	
	public Product addProduct(Product product) throws Exception; // 상품 등록
		
	public Product getProduct(int prodNo) throws Exception; // 상품정보 번호로 조회
	
	public Product getProduct(String ProdName) throws Exception; // 상품정보 이름으로 조회
	
	public Map<String, Object> getProductList(Search searchVO) throws Exception; //상품목록 조회
	
	public Product updateProduct(Product product) throws Exception; // 상품 정보 수정
		
}