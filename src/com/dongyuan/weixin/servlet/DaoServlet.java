package com.dongyuan.weixin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dongyuan.weixin.message.event.BaseEvent;
import com.dongyuan.weixin.po.WeixinUserInfo;
/**
 * Servlet implementation class DaoServlet
 */
@WebServlet("/DaoServlet")
public class DaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			WeixinUserInfo weixinUserInfo = new WeixinUserInfo();
			BaseEvent baseEvent  = new BaseEvent();
			weixinUserInfo.setOpenId(baseEvent.getFromUserName());
			HttpSession session = request.getSession();
			System.out.println(session.getAttribute("openID"));
			String openid = weixinUserInfo.getOpenId();
			System.out.println("openid:"+openid);
			if ("1".equals(openid)) {
				response.sendRedirect("https://jinshuju.net/f/hlYHud");
			}
			else {
				response.sendRedirect("http://www.baidu.com");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
