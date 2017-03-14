package com.dongyuan.weixin.user.dao;

import com.dongyuan.weixin.message.event.QRCodeEvent;
import com.dongyuan.weixin.po.WeixinOauth2Token;

public interface PersonDao {
	public QRCodeEvent insertByopenid(QRCodeEvent qrCodeEvent)throws Exception;
	// 按scene_id查询，主要为更新使用
	public WeixinOauth2Token queryByScene_ID(String openID) throws Exception ;
	//按照openid查询，如果不存在则插入，如果存在不执行操作
	public QRCodeEvent selectByopenid(String fromUserName) throws Exception;
}
