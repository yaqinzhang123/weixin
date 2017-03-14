package com.dongyuan.weixin.util.set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dongyuan.weixin.menu.Button;
import com.dongyuan.weixin.menu.ClickButton;
import com.dongyuan.weixin.menu.ComplexButton;
import com.dongyuan.weixin.menu.Menu;
import com.dongyuan.weixin.menu.ViewButton;
import com.dongyuan.weixin.po.Token;
import com.dongyuan.weixin.util.CommonUtil;
import com.dongyuan.weixin.util.MenuUtil;

/**
 * 菜单管理器类
 * 
 * @author qikuo
 * @date 2017-2-28
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	/**
	 * 定义菜单结构
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		//按钮1
		ViewButton btn11 = new ViewButton();
		btn11.setName("招聘登记");
		btn11.setType("view");
		btn11.setUrl("https://jinshuju.net/f/tl21JZ");
	
		ViewButton btn12 = new ViewButton();
		btn12.setName("代猎人才");
		btn12.setType("view");
		btn12.setUrl("https://jinshuju.net/f/OAOrtf");
		
		ViewButton btn13 = new ViewButton();
		btn13.setName("简历超市");
		btn13.setType("view");
		btn13.setUrl("http://shop13308654.ddkwxd.com/tag/231285");
		
		//按钮2
		ViewButton btn21 = new ViewButton();
		btn21.setName("求职登记");
		btn21.setType("view");
		btn21.setUrl("https://jinshuju.net/f/j3iabB");
		
		ViewButton btn22 = new ViewButton();
		btn22.setName("代查岗位");
		btn22.setType("view");
		btn22.setUrl("https://jinshuju.net/f/d4unTY");
		
		ViewButton btn23 = new ViewButton();
		btn23.setName("招聘信息");
		btn23.setType("view");
		btn23.setUrl("http://shop13308654.ddkwxd.com/tag/231300");
		
		//按钮3
		//String reurl= "http://zplsyx.iok.la/weixin3/oa.do";
		//String reurls = CommonUtil.urlEncodeUTF8(reurl);
		ViewButton btn3 = new ViewButton();
		btn3.setName("推广加盟");
		btn3.setType("view");
		btn3.setUrl("http://zplsyx.iok.la/weixin3/JSP/tuiguang.jsp");
		//btn11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx179e17d128a005d0&redirect_uri="+reurls+"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redire");
		///weixin3/WebContent/JSP/tuiguang.jsp
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("招聘入口");
		mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("求职入口");
		mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, btn3 });
		
		return menu;
	}

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = CommonUtil.APPID;
		// 第三方用户唯一凭证密钥
		String appSecret = CommonUtil.APPSECRET;

		// 调用接口获取凭证
		Token token = CommonUtil.getToken(appId, appSecret);

		if (null != token) {
			// 创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());

			// 判断菜单创建结果
			if (result)
				//log.info("菜单创建成功！");
				System.out.println("菜单创建成功");
			else
				//log.info("菜单创建失败！");
				System.out.println("创建失败");
			
		}
	}
}
