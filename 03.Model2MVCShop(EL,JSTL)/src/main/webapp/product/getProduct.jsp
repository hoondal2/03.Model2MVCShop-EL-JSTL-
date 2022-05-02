<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="com.model2.mvc.service.domain.*"%>

<%-- /////////////////////// EL / JSTL 적용으로 주석 처리 ////////////////////////
<%@ page import="com.model2.mvc.service.domain.*"%>
<%
	session = request.getSession();
	User user = (User)session.getAttribute("user");
	
	Product vo = (Product)request.getAttribute("vo"); %>
/////////////////////// EL / JSTL 적용으로 주석 처리 //////////////////////// --%>
	
	<c:set var="user" value="${user}" scope="session"/>
	
<%--Cookie[] cookies = request.getCookies();
	
	if(menu.equals("search")){
		Cookie cookie = new Cookie("history",URLEncoder.encode(Integer.toString(vo.getProdNo())));
		cookie.setMaxAge(60*60);
		response.addCookie(cookie); // 보낼때 주는 쿠키 
		//Cookie[] cookies = request.getCookies(); // 쿠키 배열 받아오기	
		//List<Cookie> cookies2 = new ArrayList<Cookie>(); // 리스트 만들기
		//리스트에 쿠키 추가
		//cookies2.add(cookie);
		System.out.println("쿠키 저장완료"); // 하나의 쿠키는 하나의 값만 저장한다...
		//}
	}
--%>
<%
	Product vo = (Product)request.getAttribute("vo"); 
	// 고친 부분
	String prvHistory = "";
	   
	   for (Cookie c:request.getCookies()){
	      if (c.getName().equals("history")){
	         prvHistory=URLDecoder.decode(c.getValue(), "utf-8");
	         System.out.println("getProduct: " + prvHistory);         
	      }
	   }
	   // Cookie는 Request, Response를 가지고 불러오기 또는 전달이 이루어진다.
	   // 현재 Project에서 사용되는 Cookie의 구조는 Key "history", value: prodNo이면서 각 ProdNo은 , 로 구분 되어있음.
	   int prodNo= vo.getProdNo();
	   System.out.println("getProduct: "+ prvHistory);
	   System.out.println("getProduct: "+ prodNo+","+prvHistory);
	   Cookie cookie = new Cookie("history", URLEncoder.encode(prodNo+","+prvHistory, "utf-8"));   // 쿠키 생성
	   cookie.setMaxAge(60*60);   // 현재 Cookie의 유지기간
	   response.addCookie(cookie);
%>

<%-- /////////////////////// EL / JSTL 적용으로 주석 처리 ////////////////////////
<% String menu = request.getParameter("menu");
	System.out.println(menu);
%>
/////////////////////// EL / JSTL 적용으로 주석 처리 //////////////////////// --%>

<c:set var="menu" value="${param.menu}"/>
<%System.out.println(request.getParameter("menu")); %>

<html>
<head>
<title>상품상세조회 / 상품수정</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

</head>

<body bgcolor="#ffffff" text="#000000">

	<table width="100%" height="37" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"
				width="15" height="37"></td>
			<td background="/images/ct_ttl_img02.gif" width="100%"
				style="padding-left: 10px;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="93%" class="ct_ttl01">상품상세조회</td>
						<td width="20%" align="right">&nbsp;</td>
					</tr>
				</table>
			</td>
			<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"
				width="12" height="37"></td>
		</tr>
	</table>

	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		style="margin-top: 13px;">
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">상품번호 <img
				src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle" />
			</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="105">${vo.prodNo}</td>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>

		<tr>
			<td width="104" class="ct_write">상품명 <img
				src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle" />
			</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">${vo.prodName}</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">상품이미지</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">${vo.fileName}</td>

		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">상품상세정보</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">${vo.prodDetail}</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">제조일자</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="26">${vo.manuDate}</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>

		<tr>
			<td width="104" class="ct_write">가격</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">${vo.price}</td>

		</tr>

		</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>

		<tr>
			<td width="104" class="ct_write">등록일자</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">${vo.regDate}</td>

		</tr>

		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
	</table>

	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
		<tr>
			<td width="53%"></td>
			<td align="right">
				
					
					<!-- /////////////////// 로그인 / 미로그인 구분 ///////////////////-->
					<c:if test = "${!empty user}">
					<!--///////////// menu==manage일때 수정과 이전버튼 생성 //////////////-->
							<%--if(menu.equals("manage")){ --%>
							<c:if test = "${param.menu eq 'manage'}">
						<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="17" height="23">
								<img src="/images/ct_btnbg01.gif" width="17" height="23" /></td>
							<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
								<a href="/updateProductView.do?prodNo=${vo.prodNo}">수정</a>
							</td>
							<td width="14" height="23">
								<img src="/images/ct_btnbg03.gif" width="14" height="23"></td>
							</td>
							<td width="30"></td>
							
							<td width="17" height="23"><img src="/images/ct_btnbg01.gif"
								width="17" height="23"></td>
							<td background="/images/ct_btnbg02.gif" class="ct_btn01"
								style="padding-top: 3px;">
								<a href="javascript:history.go(-1);">이전</a> 
							</td>
							<td width="14" height="23">
								<img src="/images/ct_btnbg03.gif" width="14" height="23">
							</td>
						</tr>
						</table>
							</c:if>
							<!--///////////// menu==search 일때 구매와 이전버튼 생성 ////////////////-->
							<c:if test = "${param.menu eq 'search'}">
							<table border="0" cellspacing="0" cellpadding="0">
							<tr>
									<td width="17" height="23">
										<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
									</td>
									<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
										<a href="/addPurchaseView.do?prodNo=${vo.prodNo}">구매</a>
									</td>
									<td width="14" height="23">
										<img src="/images/ct_btnbg03.gif" width="14" height="23">
									</td>
									<td width="30"></td>
									<td width="17" height="23">
										<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
									</td>
									<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
										<a href="javascript:history.go(-1)">이전</a>
									</td>
									<td width="14" height="23">
										<img src="/images/ct_btnbg03.gif" width="14" height="23">
									</td>
							</tr>
							</table>
							</c:if>
						</c:if>
			<!-- //////////////////////// 미로그인시 이전버튼만 생성 /////////////////////////// -->
						<c:if test = "${empty user}">
							<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="17" height="23">
								<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
								</td>
								<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
								<a href="javascript:history.go(-1)">이전</a>
								</td>
								<td width="14" height="23">
								<img src="/images/ct_btnbg03.gif" width="14" height="23">
								</td>
							</tr>
							</table>
						</c:if>
</body>
</html>