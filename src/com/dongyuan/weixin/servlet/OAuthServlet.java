package com.dongyuan.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.dongyuan.weixin.po.SNSUserInfo;
import com.dongyuan.weixin.po.WeixinOauth2Token;
import com.dongyuan.weixin.util.AdvancedUtil;

/**
 * 授权后的回调请求处理
 * 
 * @author qikuo
 * @date 2017-03-08 
 */
public class OAuthServlet extends HttpServlet{
	private static final long serialVersionUID = -1847238807216447030L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");

		// 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        
        // 用户同意授权
        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken("wx179e17d128a005d0", "64001733208cf2e39a1a1c9d6c14d52a", code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
            
            
            // 设置要传递的参数
            request.setAttribute("openId", openId);
            request.setAttribute("snsUserInfo", snsUserInfo);
            request.setAttribute("state", state);
        }
        // 跳转到index.jsp
//        request.getRequestDispatcher("/JSP/index.jsp").forward(request, response);
		request.getRequestDispatcher("allServlet").forward(request, response);
//		response.sendRedirect("allServlet");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}
}
