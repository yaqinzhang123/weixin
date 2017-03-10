package com.dongyuan.weixin.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * 链接数据库
 * */
public class DataBaseConnection {
	private Connection conn = null ;
	
	public DataBaseConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/weixin?characterEncoding=utf8&useSSL=true","root","root");
			System.out.println("数据库链接成功");
			
		}
		catch (Exception e)
		{
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return this.conn ;
	}
	
	public void close()
	{
		try
		{
			this.conn.close() ;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
}
