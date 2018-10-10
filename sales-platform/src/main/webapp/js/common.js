$(document).ready(function(){
	$('#navMenu').on('click','ul>li',function(){
		var that=$(this);
		var $ul=that.find('ul');
		if($ul.is(':hidden')){
			that.find('label').addClass('icon-unfold');
			$ul.show();
			$ul.parent().siblings().find('ul').hide();
			$ul.parent().siblings().find('label').removeClass('icon-unfold');
		}else{
			that.find('label').removeClass('icon-unfold');
			$ul.hide();
		}
	});
});
//验证提示
var validateMsg={
	CHECK_TITLE:'提示',
	CHECK_MIN_VALUE:'您还没有选择呢，请勾选！',
	CHECK_MAX_UPDATE_VALUE:'别闹，修改数据时只能选择一条哦！'
}
function isEmptyObj(obj){
	for(var name in obj){
		return true;
	}
	return false;
}