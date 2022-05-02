package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class AddPurchaseViewAction extends Action {
	
	public String execute(	HttpServletRequest request,
							HttpServletResponse response) throws Exception {
	
	//prodNo값이 필요 -> sql접근해서 가져와야 한다
	System.out.println("addPurchaseViewAction에서 받은 prodNo의 값 : " +Integer.parseInt(request.getParameter("prodNo")));
	int prodNo=Integer.parseInt(request.getParameter("prodNo")); //prodNo의 값이 널?? 확인
	
	ProductService service=new ProductServiceImpl();
	
	Product vo = service.getProduct(prodNo);
	request.setAttribute("vo", vo);
	prodNo = vo.getProdNo();
	System.out.println("addPurchaseViewAction에서 바뀐 prodNo의 값 : " +Integer.parseInt(request.getParameter("prodNo")));

	return "forward:/purchase/addPurchaseView.jsp";
	
	}	
}
