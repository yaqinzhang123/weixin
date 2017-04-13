package com.dongyuan.weixin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dongyuan.weixin.po.WeixinOauth2Token;
import com.dongyuan.weixin.user.dao.DaoFactory;

/**
 * Servlet implementation class AllServlrt
 */
@WebServlet("/AllServlrt")
public class qgslAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qgslAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String openid_qgsl = (String) request.getAttribute("openId_qgsl");
		System.out.println(openid_qgsl);
		WeixinOauth2Token weixinOauth2Token_qgsl = new WeixinOauth2Token();
		
		String scene_id = request.getParameter("scene_id");
		HttpSession session = request.getSession();
		weixinOauth2Token_qgsl.setScene_id(scene_id);
		try {
			WeixinOauth2Token weixinOauth2Token2_qgsl = DaoFactory.getPersonDaoInstance().queryByScene_ID(openid_qgsl);
			session.setAttribute("openid_qgsl", weixinOauth2Token2_qgsl);	
		} catch (Exception e) {
			// TOD.O: handle exception
		}
		if (session.getAttribute("openid_qgsl")!=null) {
			weixinOauth2Token_qgsl = (WeixinOauth2Token) session.getAttribute("openid_qgsl");
			String scene_id1 = weixinOauth2Token_qgsl.getScene_id();
			if (scene_id1 != null) {
				response.sendRedirect("http://mianshijilu.com");
			}else {
				response.sendRedirect("https://jinshuju.net/f/JN3P8g");	
			}
		}
	}

}
