package com.model2.mvc.service.product;

import java.util.HashMap;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


public interface ProductService {
	
	public Product addProduct(Product product) throws Exception; // ��ǰ ���
		
	public Product getProduct(int prodNo) throws Exception; // ��ǰ���� ��ȣ�� ��ȸ
	
	public Product getProduct(String ProdName) throws Exception; // ��ǰ���� �̸����� ��ȸ
	
	public Map<String, Object> getProductList(Search searchVO) throws Exception; //��ǰ��� ��ȸ
	
	public Product updateProduct(Product product) throws Exception; // ��ǰ ���� ����
		
}