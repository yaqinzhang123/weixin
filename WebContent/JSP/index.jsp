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
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>秦皇岛信息港</title>
<meta name="viewport" content="width=device-width,user-scalable=0">
	<style type="text/css">
		/* *{margin:0; padding:0}
		table{border:1px dashed #B9B9DD;font-size:12pt}
		td{border:1px dashed #B9B9DD;word-break:break-all; word-wrap:break-word;}
		.divcss1 {margin:50px auto;height:2px;width:4px;}
		#divcss1 img{ border-radius:50%;height:70px;width:70px;} 
		#divcss2 img{ height:150px;width:150px;}  */
		body, h4, h5, ul {
	margin: 0px;
	padding: 0px;
	}
li {list-style: none;}
a {text-decoration: none;}
/* end reset*/
#container {
	/*瀹藉害鑷�傚簲锛屽湪涓嶅悓灞忓箷涓嬭兘澶熼摵婊�*/
	width: 100%;
	background: #fff;
	}
#header {
	/*瀹藉害鑷�傚簲锛岄珮搴︾敱鍐呭鎾戝紑锛屽唴瀹瑰眳涓�*/
	width: 100%;
	background: #71c5e4;
	text-align: center;
	}
#header h4 {
	/*
	涓轰簡璁╂爣棰樺拰鍥剧墖鍚岃鏄剧ず锛岃缃覆鏌撴柟寮忎负inline
	璁剧疆鍨傜洿瀵归綈鏂瑰紡vertical-align涓簃iddle
	琛岄珮涓�80px
	*/
	display: inline;
	font-size: 30px;
	line-height: 80px;
	color: #fff;
	vertical-align:middle;
	}
#header img {
	/*鍥剧墖鍜屾爣棰樺瀭鐩村眳涓榻�*/
	vertical-align:middle;
	}
/*content*/
#content {
	/*div#person鍐呭灞呬腑鏄剧ず */
	position: relative;
	text-align: center;
	}
#content a.job {
	/*缁濆瀹氫綅锛岀浉瀵逛簬div#content杩涜鍋忕Щ
	  灏嗗浘鏍囪缃负鑳屾櫙锛岃皟鏁磒adding-left	鍒板悎閫傜殑鏁板��
	*/
	position: absolute;
	/*top: 29px;
	right: 26px;*/
	top:5%;
	right:5%;
	background: url(../img/job.png) no-repeat;
	padding-left: 26px;
	font-size: 30px;
	color: #ff8444;
	}
/* content person*/
#person img {
	/*璁剧疆澶村儚鐨勪笂澶栬竟璺濅负30px*/
	margin-top: 30px;
	}
span.name {
	font-size: 31px;
	line-height: 80px;
	}
span.address {
	/*灏嗗湴鍧�鍥炬爣璁剧疆涓鸿儗鏅紝骞跺皢padding-left璋冩暣鍒板悎閫傜殑鏁板��*/
	padding-left: 28px;
	background: url(../img/markIcon.png) no-repeat;
	font-family: Arial;
	font-size: 24px;
	line-height: 33px;
	}
/* end content person*/

/* content share*/
div.boxer {
	/*浣縟iv.boxer鍗冲垎浜拰瀹㈡湇鐢佃瘽鎵�鍦ㄧ殑div灞呬腑鏄剧ず
		骞惰缃渾瑙掑崐寰勪负5px锛宒iv涓殑鍐呭灞呬腑鏄剧ず
	*/
	position: relative;
	left: 50%;
	border: 2px dashed #8dc63f;
	border-radius: 5px;
	text-align: center;
	
	}
div#share {
	/*margin-left涓哄搴︾殑涓�鍗婄殑璐熸暟浣縟iv#share姘村钩灞呬腑鏄剧ず*/
	margin-left: -145px;
	margin-top: 28px;
	margin-bottom: 45px;
	width: 290px;
	}
 a.share {
	/*灏嗗垎浜浘鏍囪缃负鑳屾櫙锛屽苟灏唒adding-left璋冩暣鍒板悎閫傜殑鏁板��*/
	padding-left:35px;
	background: url(../img/shareIcon.png) no-repeat;
	font-size: 30px;
	font-weight:bold;
	line-height:56px;
	color: #ff8444;
	}
/*end content share*/

/* content mine*/
ul#mine {
	/*浣縰l#mine灞呬腑鏄剧ず*/
	position: relative;
	left:50%;
	margin-left:-329px;
	width: 658px;
	height: 86px;
	border-bottom: 1px solid #e0e0e0;
	}
#mine li {
	/*li娣诲姞娴姩锛屼娇li鑳藉鍚岃鏄剧ず*/
	float: left;
	margin: 0 54px;
	}
#mine span {
	font-size: 40px;
	color: #999999;
	}
#mine a {
	font-size: 24px;
	color: #999999;
	}
/* end content mine*/
span.line {
	/*椤甸潰涓棿鐨勫垎鍓茬嚎*/
	display: block;
	margin-top: 32px;
	height: 18px;
	background: #f8f8f8;
	}
/*end content*/	

/*footer*/	
#footer {
	/*div#footer涓殑鍐呭灞呬腑鏄剧ず*/
	text-align: center;
	}
#footer h5 {
	font-size: 30px;
	color: #ff4222;
	margin: 26px 0 35px 0;
	}
#footer a {
	font-size: 31px;
	line-height:47px;
	color: #97cb51;
	}
#footer div.boxer {
	/*涓鸿div.boxer姘村钩灞呬腑鏄剧ず锛宮argin-left涓哄搴︿竴鍗婄殑璐熸暟*/
	margin-left: -90px;
	margin-top: 21px;
	width: 176px;
	}
/* end footer*/

/*contact閬僵灞�*/
div.contact, ul.contact {
	/*display:none;姝ｅ父鎯呭喌涓嬶紝閬僵灞備笉鏄剧ず*/
	display: none;
	}
div.contact {
	/*div.contact缁濆瀹氫綅锛屽苟鐩稿浜巋tml鏂囨。鍋忕Щ锛屽楂橀摵婊℃暣涓睆骞�
	閫忔槑搴︿负0.6,杈惧埌閬僵鐨勬晥鏋�
	*/
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: 0.6;
	
	}	
ul.contact {
	/*
	ul.contact缁濆瀹氫綅锛屽苟鐩稿浜巋tml鏂囨。鍋忕Щ
	涓轰娇鍏跺瀭鐩村眳涓樉绀猴紝top涓�50%锛宮argin-top涓洪珮搴︿竴鍗婄殑璐熸暟
	楂樺害鍥哄畾锛屽搴﹁嚜閫傚簲
	*/
	position: absolute;
	top: 50%;
	margin-top: -110px;
	margin-left: 10%;
	margin-right: 10%;
	width: 80%;
	height: 220px;
	background: #fff;
	}
.contact li {
	height: 28px;
	font-size: 28px;
	color: #4a4a4a;
	padding: 42px 0 40px 36px;
	border-bottom: 1px solid #ccc;
	}
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
    		
    		<%-- <%=scene_id %>
    		<%=Nickname %><br>
    		<%=Province %><%=City %><br>
    		<div id="divcss1"><img src="<%=HeadImgUrl %>"><br></div>
    		<div id="divcss2"><img src="<%=requestUrl %>"></div> --%>
    		<div id="container">
        <div id="header">
        	<img src="../img/head.png"/>
            <h4>秦皇岛人才库</h4>
        </div>
       <div id="content">
            <a class="job" href="#">招聘岗位</a>
            <div id="person">
                <img  src="<%=HeadImgUrl %>" /><br/>
                <span class="name"><%=Nickname %></span><br/>
                <span class="address"><%=Province %><%=City %></span>
            </div>
            <div id='share' class="boxer">
                <a href="#" class="share">分享获取佣金</a>
            </div>
            <ul id="mine">
                <li>
                    <span>0</span><br/>
                    <a href="recommend.html">我的推荐</a>
                </li>
                <li>
                    <span>0</span><br/>
                    <a href="total.html">总推荐数</a>
                </li>
                <li>
                    <span>0</span><br/>
                    <a href="#">我的奖金</a>
                </li>
            </ul>
        </div>
       <span class="line"></span>
        <div id="footer">
            <h5>我的推荐码</h5>
            <div>
                <img src="<%=requestUrl %>"/>
            </div>
            <div class="boxer">
            	<a href="#">客服电话</a>
            </div>
        </div>
    </div>
   <div class="contact">
    </div>
    <ul class="contact">
         <li>呼叫</li>
         <li>添加到手机通讯录</li>
     </ul>
    		<%}else{
    			response.sendRedirect("https://jinshuju.net/f/JN3P8g");
    		}
    	} %>
    	
		
				
</body>
</html>