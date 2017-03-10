<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dongyuan.weixin.service.CoreService"%>
<%@page import="com.dongyuan.weixin.message.event.QRCodeEvent"%>
<%@page import="com.dongyuan.weixin.message.event.BaseEvent"%>
<%@page import="org.apache.catalina.User"%>
<%@ page import="com.dongyuan.weixin.util.CommonUtil" %>
<%@ page import="com.dongyuan.weixin.util.MessageUtil" %>
<%@ page import="com.dongyuan.weixin.po.WeixinUserList" %>
<%@ page import="com.dongyuan.weixin.po.WeixinUserInfo" %>
<%@ page import="com.dongyuan.weixin.util.AdvancedUtil" %>
<%@ page import="com.dongyuan.weixin.po.Token"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/*
			从数据库中查询数据，如果用户openid存在，跳转到信息页面，不存在跳转到注册页面
		*/
		BaseEvent baseEvent = new BaseEvent();
		WeixinUserInfo weixinUserInfo = new WeixinUserInfo();
		
		if("1".equals(1)){
			//跳转到显示个人信息页面
			response.sendRedirect("https://zqlsyx.iok.la/weixin3/user.jsp");
		}
		else{
			//跳转到注册页面
			response.sendRedirect("https://jinshuju.net/f/hlYHud");
		}
	%>
</body>
</html>