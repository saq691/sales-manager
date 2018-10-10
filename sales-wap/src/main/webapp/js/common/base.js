"use strict";
$(document).ready(function(){
	FastClick.attach(document.body);
	// 返回上一页
	$('#wyBack').on('click',function(){
		this.href='javascript:history.go(-1)';
		if (typeof document.referrer === '') {
			this.href='index.html';
		}
	});
	// 头部导航
	$(document).on('click', function(event) {
		var evt = event.srcElement ? event.srcElement : event.target;
		if (evt.id == 'headerBarMenu') {
			$('#headerBarMenu').next().show();
			return false;
		} else {
			$('#headerBarMenu').next().hide();
		}
	});
});