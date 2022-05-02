package com.model2.mvc.view.purchase;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class ListPurchaseAction extends Action {

	public String execute(	HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Search searchVO=new Search();
		
		int page=1; // ����Ʈ �������� = 1
		if(request.getParameter("page") != null)
			page=Integer.parseInt(request.getParameter("page"));
		
		searchVO.setCurrentPage(page);
		searchVO.setSearchCondition(request.getParameter("searchCondition")); // ��ǰ��ȣ/��ǰ�̸� = 0/1
		searchVO.setSearchKeyword(request.getParameter("searchKeyword")); // �˻���
		
		String pageUnit=getServletContext().getInitParameter("pageSize"); // 3 (web.xml���� Ȯ�ΰ���)
		searchVO.setPageSize(Integer.parseInt(pageUnit));
		
		
		PurchaseService service=new PurchaseServiceImpl();
		
		// ���ǿ� ����Ǿ� �ִ� userId�� �����´� 
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String buyerId = user.getUserId();
		
		HashMap<String,Object> map=service.getPurchaseList(searchVO, buyerId); // �ش� ������ ���Ÿ�ϸ� �����ش�.

		request.setAttribute("map", map);
		request.setAttribute("searchVO", searchVO);
		
		return "forward:/purchase/listPurchase.jsp";
	}
}
