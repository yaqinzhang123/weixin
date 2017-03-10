package com.dongyuan.weixin.menu;


/**
 * 复合类型的按钮
 * 
 * @author qikuo
 * @date 2017-2-28
 */
public class ComplexButton extends Button {
	private Button[] sub_button;
	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
