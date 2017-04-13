package com.dongyuan.weixin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongyuan.weixin.po.SNSUserInfo;
import com.dongyuan.weixin.po.WeixinOauth2Token;
import com.dongyuan.weixin.util.AdvancedUtil;

/**
 * ��Ȩ��Ļص�������
 * 
 * @author qikuo
 * @date 2017-03-08 
 */
public class qgslOfOAuthServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");

		// �û�ͬ����Ȩ���ܻ�ȡ��code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        
        // �û�ͬ����Ȩ
        if (!"authdeny".equals(code)) {
        	 WeixinOauth2Token weixinOauth2Token_qgsl = AdvancedUtil.getOauth2AccessToken("wxd72af67620853d7f", "ef8337372b363be11276ff0a9a107390", code);
             // ��ҳ��Ȩ�ӿڷ���ƾ֤
             String accessToken_qgsl = weixinOauth2Token_qgsl.getAccessToken();
             // �û���ʶ
             String openId_qgsl = weixinOauth2Token_qgsl.getOpenId();
             System.out.println(openId_qgsl);
             // ��ȡ�û���Ϣ
             SNSUserInfo snsUserInfo_qgsl = AdvancedUtil.getSNSUserInfo(accessToken_qgsl, openId_qgsl);
             
           
            request.setAttribute("openId_qgsl", openId_qgsl);
            request.setAttribute("snsUserInfo_qgsl", snsUserInfo_qgsl);
            request.setAttribute("state", state);
        }
        request.getRequestDispatcher("qgslallServlet").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}
}
