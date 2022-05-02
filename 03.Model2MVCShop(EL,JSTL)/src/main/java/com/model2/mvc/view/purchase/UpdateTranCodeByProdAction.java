package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class UpdateTranCodeByProdAction extends Action {
	
	public String execute(	HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// tranCode가 세팅된 purchase객체를 받아와서 proTranCode 세팅
		// getProduct로 product객체 가져오기 이때 인자값으로 purchaseVO의 prodNo과 같을때의 prodNo을 준다
//		PurchaseVO purchaseVO = (PurchaseVO)request.getAttribute("purchase");
//		System.out.println(purchaseVO);
//		ProductService pdService=new ProductServiceImpl();
//		//int prodNo = (purchaseVO.getPurchaseProd().getProdNo());
//		
//		ProductVO productVO = pdService.getProduct(prodNo);
//		
//		if("aaa".equals(purchaseVO.getTranCode())) {
//			productVO.setProTranCode("구매완료");
//		}else if("bbb".equals(purchaseVO.getTranCode())) {
//			productVO.setProTranCode("배송중");
//		}else if("ccc".equals(purchaseVO.getTranCode())) {
//			productVO.setProTranCode("배송완료");
//		}
		
		return "forward:/listProduct.do?menu=manage";
	}
}
