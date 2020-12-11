var w_bao_data = new Array();
var w_buy_data = new Array();
var w_man_data = new Array();
var w_xiu_data = new Array();

function sleep(interval) {
	return new Promise(resolve => {
		setTimeout(resolve, interval);
	})
}

async function yibu() {
	await sleep(500);
	var temp_arrange = document.getElementById('temp_arrange').innerHTML;
	document.getElementById('bao_arrange').innerHTML = template(temp_arrange, {
		bao_list: w_bao_data,
		// buy_list: w_buy_data,
		// manager_list: w_man_data,
		// xiu_list: w_xiu_data
	});
}

function load_dai(request_url) {
	mui.init();
	var self;
	var user;
	// var arrange_baoload_url;
	// var arrange_buyload_url;
	// var arrange_manager_url;
	mui.plusReady(function() {
		self = plus.webview.currentWebview();
		user = self.user;
		team = self.team;
		// alert(user);
		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		// var arrange_baoload_url = request_url + 'devFindScrapRecord?userAccount=' + user.userAccount;
		// var arrange_buyload_url = request_url + 'logFindBuyTempRecord?userAccount=' + user.userAccount;
		// var arrange_manager_url = request_url + 'userAuth?userAuth=2';
		// var arrange_xiuload_url = request_url + 'logFindRepairLog?userAccount=' + user.userAccount;
		var get_Enrol_url = request_url + 'queryEnrolByPlayerId?playerId=' +user.isPlayer;
		// var w_bao_data= new Array();
		// var w_buy_data= new Array();
		// var w_man_data= new Array();
		// alert(arrange_buyload_url);
		////////////////////////////报废申请////////////////////////////////////////////
		mui.ajax({
			type: 'GET',
			url: get_Enrol_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if (data.data != null) {
					var Enrol_data = new Array();
					Enrol_data = data.data;
					
					w_bao_data = Enrol_data;
					// var temp_arrange = document.getElementById('temp_arrange').innerHTML;
					// document.getElementById('bao_arrange').innerHTML = template(temp_arrange, {
					// 	list: w_bao_data
					// });
				}
				// alert(w_bao_data[0]);
				// 	var s ="";

				// 	for (var p in dev_chadata) {
				// 		s= s+"\n"+p+": "+dev_chadata[p];
				// 	}
				// 	alert(s);
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
		
	});
	yibu();
}

function yes_arrange(enId, request_url) { ///////////type=0 报废 type==1 报修
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;
		var team = self.team;

		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var arrange_yes_url;
		var arrange_yes_url_0 = request_url + 'attendEnrol?enId=' + enId + '&playerId=' +user.isPlayer;
		
		 //alert(arrange_yes_url_0);
		mui.ajax({
			type: 'GET',
			url: arrange_yes_url_0,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if ((data.code == 0)) {
					mui.toast("报名成功！")
					load_dai(request_url);
				}else if(data.message == "YOU HAVE ALREADY ENROL !"){
					mui.toast("您已报名，请勿重复报名");
				}
				// 	var s ="";

				// 	for (var p in dev_chadata) {
				// 		s= s+"\n"+p+": "+dev_chadata[p];
				// 	}
				// 	alert(s);
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}

function no_arrange(logid, request_url, type) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;

		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var arrange_no_url;
		var arrange_no_url_0 = request_url + 'devDealScrapRecord?userAccount=' + user.userAccount + '&logId=' + logid +
			'&logStatus=2';
		var arrange_no_url_1 = request_url + 'logDealRepairLog?userAccount=' + user.userAccount + '&logId=' + logid +
			'&logStatus=2';
		if (type == 0) {
			arrange_no_url = arrange_no_url_0;
		} else if (type == 1) {
			arrange_no_url = arrange_no_url_1;
		}
		mui.ajax({
			type: 'GET',
			url: arrange_no_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if ((data.code == 0)) {
					mui.toast("驳回成功！")
					load_dai(request_url);
				}
				// 	var s ="";

				// 	for (var p in dev_chadata) {
				// 		s= s+"\n"+p+": "+dev_chadata[p];
				// 	}
				// 	alert(s);
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}

function more_arrange(enId, request_url) { //type=0 报废申请的更多  type=1 购置申请的更多   type =2 报修申请的更多
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;

		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		// alert(dev_id);
		var arrange_load_url = request_url + "queryEnrolByEnId?enId=" + enId;
		// alert(user.userAuthority);
		mui.ajax({
			type: 'GET',
			url: arrange_load_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {
				if ((data.data != null)) {
					var dev_data = data.data[0];
					var s = "";
					//alert(dev_data);
					for (var p in dev_data) {
						if (p == "enId") {
							s = s + "\n" + "约球ID: " + dev_data.enId;
						}else if(p == "teamId"){
							s = s + "\n" + "球队Id: " + dev_data.teamId;
						}else if(p == "teamName"){
							s = s + "\n" + "球队名称: " + dev_data.teamName;
						}else if(p == "playerNum"){
							s = s + "\n" + "预计参加人数: " + dev_data.playerNum;
						}else if(p == "fieldName"){
							s = s + "\n" + "暂定地点: " + dev_data.fieldName;
						}else if(p == "time"){
							s = s + "\n" + "预定时间:" + dev_data.time;
						}else if(p == "goPlayerNum"){
							s = s + "\n" + "已报名人数: " + dev_data.goPlayerNum;
						}else if(p == "isNeedReferee"){
							if(p == 0){
								s = s + "\n" + "不需要裁判";
							}else{
								s = s + "\n" + "需要裁判";
							}
						}
						
					}
					alert(s);
				}
				// alert(data.message);
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}


function who_manager(sel_num, logid, request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;
		// alert(sel_num);
		var manager_account_se = document.getElementById("sel_manager-" + sel_num);
		var manager_account = manager_account_se.options[manager_account_se.selectedIndex].value;
		// alert(manager_account);
		// var s ="";
		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var que_manager_url = request_url + 'logDealBuyTempRecord?userAccount=' + user.userAccount + '&managerAccount=' +
			manager_account + '&logId=' + logid + '&logStatus=3';
		mui.ajax({
			type: 'GET',
			url: que_manager_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if ((data.code == 0)) {
					mui.toast("确认成功！")
					load_dai(request_url);
				} else {
					mui.toast("操作失败！")
					load_dai(request_url);
				}
				// 	var s ="";

				// 	for (var p in dev_chadata) {
				// 		s= s+"\n"+p+": "+dev_chadata[p];
				// 	}
				// 	alert(s);
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}
