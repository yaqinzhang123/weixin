package com.dongyuan.weixin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dongyuan.weixin.message.event.QRCodeEvent;
import com.dongyuan.weixin.message.req.ReqTextMessage;
import com.dongyuan.weixin.message.resp.Article;
import com.dongyuan.weixin.message.resp.NewsMessage;
import com.dongyuan.weixin.message.resp.RespTextMessage;
import com.dongyuan.weixin.po.WeixinUserInfo;
import com.dongyuan.weixin.user.dao.DaoFactory;
import com.dongyuan.weixin.util.AdvancedUtil;
import com.dongyuan.weixin.util.CommonUtil;
import com.dongyuan.weixin.util.MessageUtil;
import com.mysql.fabric.Response;
/**
 * 核心服务类
 * 
 * @author qikuo
 * @date 2017-2-28
 */
public class CoreService {
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return xml
	 * 
	 * 从数据库中查询是否有获取到关注用户openid，没有的话放入数据库中，有则不进行任何操作
	 */
	public static String processRequest(HttpServletRequest request) {
		// xml格式的消息数据
		String respXml = null;
		try {
			// 调用parseXml方法解析请求消息
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号
			String fromUserName = requestMap.get("FromUserName");
			// 开发者微信号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			//接收消息内容
			String content = requestMap.get("Content");
			//接收key值
			String eventKey = requestMap.get("EventKey");
			//事件类型
			String event = requestMap.get("Event");
			//扫描事件
			String scan = requestMap.get("scan");
			QRCodeEvent baseEvent = new QRCodeEvent();
			RespTextMessage textMessage = new RespTextMessage();
			ReqTextMessage textMessage2 = new ReqTextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setMsgType(msgType);
			baseEvent.setFromUserName(fromUserName);
			baseEvent.setEvent(event);
			baseEvent.setEventKey(eventKey);
			baseEvent.setMsgType(msgType);
			baseEvent.setToUserName(toUserName);
			textMessage2.setContent(content);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
			// 事件推送
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					
					textMessage.setContent("感谢您关注秦皇岛信息港人才频道的微信服务窗口\n招聘方请点击 ->> '招聘入口'\n求职方请点击 ->> '求职入口'\n信息港会员请点击 ->>'人工服务' ->>'会员登记'\n查询服务进展请点击 ->> '人工服务' ->>'状态查询'");
					// 将消息对象转换成xml
					respXml = MessageUtil.messageToXml(textMessage);
					Article article = new Article();
					article.setTitle("推广加盟介绍");
					article.setDescription("这是介绍1");
					article.setPicUrl("http://zplsyx.iok.la/weixin3/img/home.jpeg");
					article.setUrl("http://www.baidu.com");
					Article article1 = new Article();
					article1.setTitle("我要推广");
					article1.setPicUrl("weixin3/img/home.png");
					String reurl= "http://zplsyx.iok.la/weixin3/oa.do";
					String reurls = CommonUtil.urlEncodeUTF8(reurl);
					article1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx179e17d128a005d0&redirect_uri="+reurls+"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirec");
					List<Article> articleList = new ArrayList<Article>();
					articleList.add(article);
					articleList.add(article1);
//					// 创建图文消息
					NewsMessage newsMessage = new NewsMessage();
					newsMessage.setToUserName(fromUserName);
					newsMessage.setFromUserName(toUserName);
					newsMessage.setCreateTime(new Date().getTime());
					newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respXml = MessageUtil.messageToXml(newsMessage);
					
					String openid = baseEvent.getFromUserName();
					HttpSession session = request.getSession();
					session.setAttribute("openID", openid);
					//request.getRequestDispatcher("/insertServlet").forward(request, null);
					//System.out.println(session.getAttribute("openID"));
					System.out.println(openid);
					//System.out.println("eventKey"+eventKey);
					System.out.println(eventKey.substring(eventKey.length()-1));
					//获取用户openid等相关信息写入数据库
					QRCodeEvent qrCodeEvent = DaoFactory.getPersonDaoInstance().insertByopenid(baseEvent);
					
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 暂不做处理
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建菜单时的key值对应
					//String eventKey = requestMap.get("EventKey");
					// 根据key值判断用户点击的按钮
					if(eventKey.equals("btn3")){
						
					}
				}
			}
			else if(eventKey.equals(MessageUtil.EVENT_TYPE_SCAN)){
				MessageUtil.EVENT_TYPE_SCAN.equals(scan);
				System.out.println("key"+eventKey);
			}
			// 当用户发消息时
			else{
				System.out.println("获得的信息:"+textMessage2.getContent());
				if ("你好".equals(textMessage2.getContent())||"您好".equals(textMessage2.getContent())||"在么".equals(textMessage2.getContent())) {
					textMessage.setContent("请稍等，正在为您分配客服人员。。。");
					respXml = MessageUtil.messageToXml(textMessage);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
