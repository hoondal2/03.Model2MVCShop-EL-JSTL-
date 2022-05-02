package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class UpdatePurchaseAction extends Action {
	public String execute(	HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			// 1. 구매한 물건 가져오기
			// 2. 업데이트 하기
			// 3. 업데이트한 물건 보내기
			int tranNo = Integer.parseInt(request.getParameter("tranNo"));
			PurchaseService service=new PurchaseServiceImpl();
			Purchase vo=service.getPurchase(tranNo); 
					
			vo.setPaymentOption(request.getParameter("paymentOption"));
			vo.setReceiverName(request.getParameter("receiverName"));
			vo.setReceiverPhone(request.getParameter("receiverPhone"));
			vo.setDivyAddr(request.getParameter("receiverAddr"));
			vo.setDivyRequest(request.getParameter("receiverRequest"));
			vo.setDivyDate(request.getParameter("divyDate"));
			vo.setTranNo(tranNo);
			
			vo = service.updatePurchase(vo);			
			request.setAttribute("vo", vo);
		
		return "forward:/purchase/getPurchase.jsp";
	}
}
