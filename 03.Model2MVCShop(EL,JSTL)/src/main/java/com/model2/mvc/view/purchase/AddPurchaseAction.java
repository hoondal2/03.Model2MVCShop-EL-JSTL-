package com.model2.mvc.view.purchase;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class AddPurchaseAction extends Action {
	
	public String execute(	HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		
	// 다른 방법 -> getParameter로 prodNo가져와서 getProduct 하기, 여기서 vo저장
	
	// 세션에서 user 객체 가져오기
	HttpSession session = request.getSession();
	User user = (User)session.getAttribute("user");
	
	// param으로 product객체 가져오기
	ProductService pdService=new ProductServiceImpl();
	Product productVO =pdService.getProduct(Integer.parseInt(request.getParameter("prodNo")));
	
	// PurchaseVO에 세팅하기
	Purchase purchaseVO = new Purchase();
	purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
	purchaseVO.setReceiverName(request.getParameter("receiverName"));
	purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
	purchaseVO.setDivyAddr(request.getParameter("receiverAddr"));
	purchaseVO.setDivyRequest(request.getParameter("receiverRequest"));
	purchaseVO.setDivyDate(request.getParameter("receiverDate"));
	purchaseVO.setPurchaseProd(productVO);
	purchaseVO.setBuyer(user);
	purchaseVO.setTranCode("aaa");
	
	// tranCode 세팅 => UpdateTranCodeAction에서 구현
	//purchaseVO.setTranCode(request.getParameter("tranCode")); // 초기값 = "aaa" -> 판매중
	//System.out.println(request.getParameter("tranCode"));
	// "aaa" -> proTranCode에 "재고없음" 반영 
	
	PurchaseService pcService=new PurchaseServiceImpl();
	pcService.addPurchase(purchaseVO); // void
	
	//purchaseVO = pcService.getPurchase(tranNo);
	//request.setAttribute("purchaseVO", purchaseVO);
	request.setAttribute("purchase", purchaseVO);
	
	// UpdateTranCodeAction로 이동, proTranCode 변경
		return "forward:/purchase/addPurchase.jsp";
	}	
}

