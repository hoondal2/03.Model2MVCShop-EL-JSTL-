package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;

public class AddProductAction extends Action {
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		Product productVO=new Product();
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		productVO.setFileName(request.getParameter("fileName"));
		
		System.out.println(productVO);
		
		//prodNo값이 필요 -> sql접근해서 가져와야 한다...
		String prodName=request.getParameter("prodName"); //prodNo의 값이 널??
//		System.out.println(prodName);
		ProductService service=new ProductServiceImpl();
//		ProductVO vo=service.getProduct(prodName);
//		
//		request.setAttribute("vo", vo);
		
		service.addProduct(productVO);
		service.getProduct(prodName);
		prodName = productVO.getProdName();
		
		return "forward:/getProduct.do?prodName="+prodName;
	}	
}
