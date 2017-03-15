// JavaScript Document
		var sear=document.getElementsByClassName('search')[0];
		var txt=sear.getElementsByTagName('input')[0];
		var cancel=sear.getElementsByTagName('span')[0];
		var content=document.getElementsByClassName('content')[0];
		var pull=content.getElementsByTagName('h3')[0];
		var list=content.getElementsByTagName('ul')[0];
		var flag=false;
		//给搜索框添加点击事件，点击显示“取消”按钮
		txt.onclick=function(){
			txt.className='active';
			cancel.style.display='block';
			};
		//给取消按钮添加点击事件，点击后搜索框恢复默认样式，并且value为"搜索姓名","取消"按钮消失
		cancel.onclick=function(){
			txt.className='';
			txt.value='搜索姓名';
			cancel.style.display='none';
			};
		//下拉显示列表
		pull.onclick=function(){
			/*
			用一个全局变量flag表示下拉显示列表的状态,false时点击收起，true时点击下拉显示
			*/
			if(!flag)
			{pull.style.backgroundImage='url(../img/right.png)';
			list.style.display='none';
			flag=true;
			}else{
				pull.style.backgroundImage='url(../img/down.png)';
				list.style.display='block';
				flag=false;
				}
			};
