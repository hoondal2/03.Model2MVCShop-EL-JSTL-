package com.model2.mvc.service.purchase;

import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseService {
	
	public void addPurchase(Purchase purchaseVO) throws Exception; // 구매 등록
	
	public Purchase getPurchase(int tranNo) throws Exception; // 구매정보 상세조회
	
	public HashMap<String, Object> getPurchaseList(Search searchVO, String tranCode) throws Exception; // 구매 목록 보기
		
	public Purchase updatePurchase(Purchase purchaseVO) throws Exception; // 구매 정보 수정
	
	public void updateTranCode(Purchase purchaseVO) throws Exception; // 구매 정보 수정

}
