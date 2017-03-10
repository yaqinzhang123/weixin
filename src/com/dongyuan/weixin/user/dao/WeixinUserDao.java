package com.dongyuan.weixin.user.dao;

import com.dongyuan.weixin.po.WeixinUserInfo;

public interface WeixinUserDao {
	public boolean login(WeixinUserInfo weixinUserInfo);
}
