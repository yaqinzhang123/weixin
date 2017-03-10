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
public class AllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String sql = "select openID from user";
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/weixin","root","root");
//			ResultSet rs = stmt.executeQuery(sql);
//			stmt = connection.createStatement();
//			List<String> list = new ArrayList<String>();
//			String APPID = CommonUtil.APPID;
//			String APPSECRET = CommonUtil.APPSECRET;
//			String accessToken = CommonUtil.getToken("APPID", "APPSECRET").getAccessToken();
////			SNSUserInfo user = (SNSUserInfo)request.getAttribute("snsUserInfo"); 
//			String openid = request.getAttribute("openId").toString();
////			String state = request.getAttribute("state").toString();
//			String ticket = AdvancedUtil.createPermanentQRCode(accessToken,1);
//			String requestUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
//			requestUrl = requestUrl.replace("TICKET", CommonUtil.urlEncodeUTF8(ticket));
//			while(rs.next()){
//				String openID= rs.getString("openID");
//				
//			}
//			request.setAttribute(openID, "openID");
//			if(request.getAttribute(openID).equals(openid)){}
//			else {
//				
//			}
//			rs.close() ;
//			stmt.close() ;
//			connection.close() ;
//		} 
//		//String sql = "select max(scene_id) from user";
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "JSP/index.jsp";
		String openid = (String) request.getAttribute("openId");
		WeixinOauth2Token weixinOauth2Token = new WeixinOauth2Token();
		//用户授权之后可以拿到用户的openid
		System.out.println("openid:"+openid); 
		String scene_id = request.getParameter("scene_id");
		HttpSession session = request.getSession();
		weixinOauth2Token.setScene_id(scene_id);
		try {
			WeixinOauth2Token weixinOauth2Token2 = DaoFactory.getPersonDaoInstance().queryByScene_ID(openid);
			session.setAttribute("openid", weixinOauth2Token2);	
			System.out.println("session:"+session.getAttribute("openid"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
