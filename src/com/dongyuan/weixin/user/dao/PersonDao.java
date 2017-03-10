package com.dongyuan.weixin.user.dao;

import com.dongyuan.weixin.message.event.QRCodeEvent;
import com.dongyuan.weixin.po.WeixinOauth2Token;

public interface PersonDao {
	public QRCodeEvent insertByopenid(QRCodeEvent qrCodeEvent)throws Exception;
	// 按scene_id查询，主要为更新使用
	public WeixinOauth2Token queryByScene_ID(String openID) throws Exception ;
}
