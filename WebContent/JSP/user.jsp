
<%@page import="com.dongyuan.weixin.util.AdvancedUtil"%>
<%@page import="com.dongyuan.weixin.po.WeixinUserInfo"%>
<%@page import="com.dongyuan.weixin.message.event.BaseEvent"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>用户信息</title>
</head>
<body>
	<%
		BaseEvent baseEvent = new BaseEvent();
		WeixinUserInfo weixinUserInfo = new WeixinUserInfo();
		String HeadImgUrl = null;
		String Ticket = null;
		String accessToken = null;
		if("1".equals(baseEvent.getFromUserName())){
			HeadImgUrl = weixinUserInfo.getHeadImgUrl();
			//Ticket = 从数据库中查询到ticket
		}
	%>
	姓名：<br><!-- 获取从金数据post过来的数据中的姓名 -->
	头像：<br><%=HeadImgUrl %>
	我的二维码：<br>
</body>
</html>