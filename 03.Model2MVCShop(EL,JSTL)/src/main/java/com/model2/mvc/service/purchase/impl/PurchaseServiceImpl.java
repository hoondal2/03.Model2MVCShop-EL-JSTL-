package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;

public class PurchaseServiceImpl implements PurchaseService{
	
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		purchaseDAO = new PurchaseDAO();
	}
	
	public void addPurchase(Purchase purchaseVO) throws Exception{
		purchaseDAO.insertPurchase(purchaseVO);
	}
	
	public Purchase getPurchase(int tranNo) throws Exception{
		return purchaseDAO.findPurchase(tranNo);
	}
	
	public HashMap<String, Object> getPurchaseList(Search searchVO, String tranCode) throws Exception{
		return purchaseDAO.getPurchaseList(searchVO, tranCode);
	}
	
	
	public Purchase updatePurchase(Purchase purchaseVO) throws Exception{
		purchaseDAO.updatePurchase(purchaseVO);
		return purchaseVO;
	}
	
	public void updateTranCode(Purchase purchaseVO) throws Exception{
		purchaseDAO.updateTranCode(purchaseVO);
	}
	
}
