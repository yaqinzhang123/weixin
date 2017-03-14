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
	<P>秦皇岛人才库不仅能满足您招聘、求职的需求，您还可以通过推广赚取收入。通过您的分享，您的朋友找到了他急需的优秀人才或渴求的工作，而您也会有一份收入。具体操作细则如下：</p><br>
	<P>	一、关注“秦皇岛人才库”公众号，点击屏幕下方“我要推广”按钮，进行注册。</P><br>
	<P>二、注册完成后即可进入推荐页面，点击右上角“...”转发该链接至朋友圈或发送给好友，好友注册完成后，您即推荐成功。</P><br>
	<P>三、每一个通过您推荐的好友在秦皇岛人才库产生消费，您都会有一份收入。您的一级好友、二级好友（A通过您分享的链接或二维码注册为会员，A为您的一级好友。B通过A分享的链接或二维码注册为会员，B为您的二级好友）推荐的好友在秦皇岛人才库产生的消费，您也会有一份收入。</P><br>
	<P>&nbsp;&nbsp;如：1、您推荐的好友A需要招聘，在秦皇岛人才库购买一份X元的简历，您将会有一份X*10%的收入。</P><br>
	<P>&nbsp;&nbsp;&nbsp;2、您推荐的好友B需要求职，在秦皇岛人才库注册简历。如B的简历被招聘单位以X元的价格购买，那么您会有一份X*10%的收入。</P><br>
	<P>&nbsp;&nbsp;&nbsp;3、通过您的一级好友分享的链接或二维码注册为会员，在秦皇岛人才库产生的消费X元，您将获得X*6%的收入。</P><br>
	<P>&nbsp;&nbsp;&nbsp;4、通过您的二级好友分享的链接或二维码注册为会员，在秦皇岛人才库产生的消费X元，您将获得X*4%的收入。</P><br>
	<P>四、本细则最终解释权归秦皇岛人才库所有。</P><br>
	<%-- <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx179e17d128a005d0&redirect_uri=<%=reurls %>&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirec">点击我进行推广</a> --%>
</body>
</html>