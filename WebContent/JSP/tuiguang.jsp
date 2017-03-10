<%@page import="com.dongyuan.weixin.util.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>我是推广页</title>
<%
	String reurl= "http://zplsyx.iok.la/weixin3/oa.do";
	String reurls = CommonUtil.urlEncodeUTF8(reurl);
	%>
</head>
<body>
	我是推广介绍页<br>
	<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx179e17d128a005d0&redirect_uri=<%=reurls %>&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirec">点击我进行推广</a>
</body>
</html>