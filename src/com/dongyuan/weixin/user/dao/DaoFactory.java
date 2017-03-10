package com.dongyuan.weixin.user.dao;

public class DaoFactory {
	public static PersonDao getPersonDaoInstance(){
		return new PersonDaoImpl();
	}
}
