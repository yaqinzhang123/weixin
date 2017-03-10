<%@page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@page import="com.dongyuan.weixin.po.WeixinOauth2Token"%>
<%@page import="com.dongyuan.weixin.servlet.AllServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.dongyuan.weixin.util.AdvancedUtil"%>
<%@page import="com.dongyuan.weixin.util.CommonUtil"%>
<%@page import="com.dongyuan.weixin.po.SNSUserInfo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>秦皇岛信息港</title>
<meta name="viewport" content="width=device-width,user-scalable=0">
	<style type="text/css">
		*{margin:0; padding:0}
		table{border:1px dashed #B9B9DD;font-size:12pt}
		td{border:1px dashed #B9B9DD;word-break:break-all; word-wrap:break-word;}
		.divcss1 {margin:50px auto;height:2px;width:4px;}
		#divcss1 img{ border-radius:50%;height:70px;width:70px;} 
		#divcss2 img{ height:150px;width:150px;} 
	</style>
</head>
<body>
	<% 
		request.setCharacterEncoding("GB2312");
    	if(session.getAttribute("openid")!=null){

    		WeixinOauth2Token weixinOauth2Token = (WeixinOauth2Token)session.getAttribute("openid");
    		// 从数据库中取出内容
			String scene_id = weixinOauth2Token.getScene_id();
    	if(scene_id!=null){
    		String APPID = CommonUtil.APPID;
    		String APPSECRET = CommonUtil.APPSECRET;
    		String accessToken = CommonUtil.getToken("APPID", "APPSECRET").getAccessToken();
    		SNSUserInfo user = (SNSUserInfo)request.getAttribute("snsUserInfo"); 
    		String openid = request.getAttribute("openId").toString();
    		String state = request.getAttribute("state").toString();
			String ticket = AdvancedUtil.createPermanentQRCode(accessToken,1);
			String requestUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
			requestUrl = requestUrl.replace("TICKET", CommonUtil.urlEncodeUTF8(ticket));
			String HeadImgUrl = user.getHeadImgUrl();
			String Province = user.getProvince();
			String City = user.getCity();
			String Nickname = user.getNickname();
    		%>
    		
    		<%=scene_id %>
    		<%=Nickname %><br>
    		<%=Province %><%=City %><br>
    		<div id="divcss1"><img src="<%=HeadImgUrl %>"><br></div>
    		<div id="divcss2"><img src="<%=requestUrl %>"></div>
    		
    		<%}else{
    			response.sendRedirect("https://jinshuju.net/f/JN3P8g");
    		}
    	} %>
    	
		
				
</body>
</html>