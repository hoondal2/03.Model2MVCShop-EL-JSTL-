package com.model2.mvc.service.purchase;

import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseService {
	
	public void addPurchase(Purchase purchaseVO) throws Exception; // ���� ���
	
	public Purchase getPurchase(int tranNo) throws Exception; // �������� ����ȸ
	
	public HashMap<String, Object> getPurchaseList(Search searchVO, String tranCode) throws Exception; // ���� ��� ����
		
	public Purchase updatePurchase(Purchase purchaseVO) throws Exception; // ���� ���� ����
	
	public void updateTranCode(Purchase purchaseVO) throws Exception; // ���� ���� ����

}
