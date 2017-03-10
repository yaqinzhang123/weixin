package com.dongyuan.weixin.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dongyuan.weixin.message.event.QRCodeEvent;
import com.dongyuan.weixin.po.WeixinOauth2Token;

public class PersonDaoImpl implements PersonDao{

	@Override
	public WeixinOauth2Token queryByScene_ID(String openID) throws Exception {
		WeixinOauth2Token weixinOauth2Token = new WeixinOauth2Token();
		String sql = "select scene_id from user where openID=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		dbc = new DataBaseConnection();
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setString(1,openID) ;
			ResultSet rs = pstmt.executeQuery() ;
			while(rs.next()){
				String scene_id = rs.getString("scene_id");
				weixinOauth2Token.setScene_id(scene_id);
			}
			rs.close() ;
			pstmt.close() ;
		}catch (Exception e)
		{
			System.out.println(e) ;
			throw new Exception("操作中出现错误！！！") ;
		}
		finally
		{
			dbc.close() ;
		}
		return weixinOauth2Token;
	}

	@Override
	public QRCodeEvent insertByopenid(QRCodeEvent qrCodeEvent) throws Exception {
		String sql = "INSERT INTO user(openID,graid) VALUES(?,?)" ;
		PreparedStatement pstmt = null ;
		DataBaseConnection dbc = null ;
		dbc = new DataBaseConnection() ;
		try
		{
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			pstmt.setString(1,qrCodeEvent.getFromUserName()) ;
			pstmt.setString(2,qrCodeEvent.getEventKey().substring(qrCodeEvent.getEventKey().length()-1)) ;
			pstmt.executeUpdate() ;
			pstmt.close() ;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("操作出现异常！！！") ;
		}
		finally
		{
			dbc.close() ;
		}
		return qrCodeEvent;
	}

}
