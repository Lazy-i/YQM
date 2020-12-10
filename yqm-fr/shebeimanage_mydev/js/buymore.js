function finish(resquest_url) {
	mui.init();
	
	var dev_fieldName = document.getElementById("dev_fieldName").value;
	var dev_playerNum = document.getElementById("dev_playerNum").value;
	var dev_isNeedReferee = document.getElementById("dev_isNeedReferee").value;
	var dev_time = document.getElementById("dev_time").value;
	// var charge_account = document.getElementById("charge_account").value;
	// var manager_account = document.getElementById("manager_account").value;
	//var dev_auth = document.getElementById("dev_auth").value;
	
//	var cha_teamName = is_special(dev_teamName);
	var cha_fieldName = is_special(dev_fieldName);
	var cha_playerNum = is_num(dev_playerNum);
	var cha_isNeedReferee = is_special(dev_isNeedReferee);
	var cha_time = is_special(dev_time);
	
	// if(dev_teamName.length==0){
	// 	mui.toast("球队名称不能为空！");
	// 	return ;
	// }
	if(dev_fieldName.length==0){
		mui.toast("场地名称不能为空！");
		return ;
	}
	if(dev_playerNum.length==0){
		mui.toast("比赛人数不能为空！");
		return ;
	}
	if(dev_isNeedReferee.length==0){
		mui.toast("请选择是否需要裁判员");
		return ;
	}
	if(dev_time.length==0){
		mui.toast("预定时间不能为空");
		return ;
	}
	// if((cha_teamName==1)||(cha_fieldName==1)||(cha_playerNum==1)||(cha_prise==1)||(cha_time==1)){
	// 	mui.toast("您输入的格式不正确！提示：字母或数字");
	// 	return ;
	// }
		
	
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;
		var team = self.team;
		var charge_account = user.userAccount;
		 var s ="";

		
		 for (var p in team[0]) {
			 s= s+"/n "+p+": "+team[0][p];
		 }
		 // alert(s);
		var add_buy_url = request_url + 'addEnrol?teamId=' + team[0].teamId + '&teamName=' + team[0].teamName + '&fieldName=' + dev_fieldName +
			'&teamNum=' + dev_playerNum + '&isNeedReferee=' + dev_isNeedReferee + '&time=' + dev_time;
			alert(add_buy_url);
		mui.ajax({
			type: 'GET',
			url: add_buy_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if (data.message == "success") {
					mui.toast("添加成功！");
					mui.back();
				} else {
					mui.toast(data.message);
				}

			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！777");
			}
		});
	});
	// var s ="";

	// for (var p in buymore_new) {
	// 	s= s+"n "+p+": "+buymore_new[p];
	// }
	// alert(s);
}


function quit() {
	mui.init();
	mui.plusReady(function() {
		mui.back();
	});
}
