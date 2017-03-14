package com.dongyuan.weixin.menu;

/**
 * click类型的按钮
 * 
 * @author qikuo
 * @date 2017-2-28
 */
public class ClickButton extends Button {
	private String type;
	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}