package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class UpdateTranCodeAction extends Action {
	
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
	// 트랜코드 업데이트 하는곳
	// 배송하기 / 물건도착 등 누르면 tranCode 변화, dao메서드 통해 proTranCode 변경
	// tranCode가 null이라면? -> aaa로 세팅 후 dao통해 vo에 세팅
	// tranCode가 null이 아니고 aaa라면? -> bbb로 세팅후 dao통해 vo에 세팅
		// dao 세팅 안해쥼 ...........
		PurchaseService pcService=new PurchaseServiceImpl();
		Purchase purchaseVO =  pcService.getPurchase(Integer.parseInt(request.getParameter("tranNo")));
		System.out.println("purchaseVO 정보 : " +purchaseVO);
		
		if(purchaseVO.getTranCode()!=null) { // 널 에러
			if("aaa".equals( (purchaseVO.getTranCode()) )){
				purchaseVO.setTranCode("bbb"); // 배송중
			}else if("bbb".equals( (purchaseVO.getTranCode()) )) {
				purchaseVO.setTranCode("ccc"); // 배송완료
			}
		}else {	purchaseVO.setTranCode("aaa"); } // 구매완료
		
		System.out.println(" 바뀐 tranCode는????????????????? "+purchaseVO.getTranCode());
		
		//DAO에 tranCode업데이트
		pcService.updateTranCode(purchaseVO);
		
		// 선택한 상품의 proTranCode가 변경되어야 한다. -> dao에서 변경
		//ProductVO productVO = (ProductVO)request.getAttribute("productVO");
		//productVO.setProTranCode("판매중");
		
		request.setAttribute("purchase", purchaseVO);
		if("manage".equals(request.getParameter("menu"))) {
			return "forward:/listProduct.do?menu=manage";
		}
		return "forward:/listPurchase.do";
	}
}
