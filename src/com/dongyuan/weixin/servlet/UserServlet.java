package com.dongyuan.weixin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongyuan.weixin.util.CommonUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=redirect_uri&response_type=code&scope=snsapi_userinfo&state=2#wechat_redirect";
	    try {
	    String appid= "wx179e17d128a005d0";
	    String REDIRECT_URI = "http://zplsyx.iok.la/weixin3/oa.do";
	    url  = url.replace("APPID", appid); 
	    url  = url.replace("REDIRECT_URI",CommonUtil.urlEncodeUTF8(REDIRECT_URI));
	    System.out.println(CommonUtil.urlEncodeUTF8(REDIRECT_URI));
	    response.sendRedirect(url);
	} catch (Exception e) {
		e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
