package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;


public class GetProductAction extends Action {
	public String execute(	HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// prodName�� ���̸� getParameter("prodName")�ؾ���
		String prodName=request.getParameter("prodName");
		ProductService service=new ProductServiceImpl();

		if("".equals(prodName) || prodName==null) { // null�� equals�޼��� ȣ�� �Ұ� !!!
			int prodNo=Integer.parseInt(request.getParameter("prodNo"));
			Product vo=service.getProduct(prodNo);
			request.setAttribute("vo", vo);
		}else{
			Product vo=service.getProduct(prodName);
			request.setAttribute("vo", vo);
		}
		
		return "forward:/product/getProduct.jsp";
}
}
