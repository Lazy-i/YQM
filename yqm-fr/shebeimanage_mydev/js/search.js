	
function search(request_url){
	search_wzj_text(request_url);
	//get_follow(request_url);
}

function get_follow(request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;
		// var s ="";
		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var get_follow_url = request_url + "AttentionFindRecord?userAccount=" + user.userAccount;
		// alert(search_url);
		mui.ajax({
			type: 'GET',
			url: get_follow_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {
				if (data.data != null) {
					var dev_data = new Array();
					dev_data = data.data;
					search_yzj_text(request_url,dev_data);
				} else {
					alert(dev_data);
					print(dev_data);
				}
			},
			error: function(xhr, type, errorThrown) {
				alert("服务器内部出错！");
			}
		});
	});
}

function search_wzj_text(request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;
		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// mui.toast(s);
		var searchwt_url = request_url + 'queryEnrolAllShow';
		 //alert(search_url);
		mui.ajax({
			type: 'GET',
			url: searchwt_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if (data.data != null) {
					var dev_data = new Array();
					dev_data = data.data;
					var temp_data = new Array();
					var i =0;
					var j =0;
					for(var i = 0,j = 0;i < dev_data.length;i++){
							
						if(dev_data[i].devWorkStatus == 1 && dev_data[i].devStatus == 1){
							temp_data[j] = dev_data[i];
							j++;
						}
					}
					var temp_stable = document.getElementById('temp_stable_wzj').innerHTML;
					document.getElementById('tb').innerHTML = template(temp_stable, {
						list: dev_data
					});
				}
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}


function search_s(teamId, request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;

		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var searchs_url = request_url + "queryPlayerTelNumberByTeamId?teamId=" + teamId;
		// alert(search_url);
		mui.ajax({
			type: 'GET',
			url: searchs_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if ((data.data != null)) {
					var dev_data = data.data[0];
					var s = "";
					//alert(dev_data);
					for (var p in dev_data) {
						// if (p == "enId") {
						// 	s = s + "\n" + "约球ID: " + dev_data.enId;
						/* }else */if(p == "playerId"){
							s = s + "\n" + "队长Id: " + dev_data.playerId;
						}else if(p == "name"){
							s = s + "\n" + "队长名称: " + dev_data.name;
						}else if(p == "telephoneNumber"){
							s = s + "\n" + "联系电话: " + dev_data.telephoneNumber;
					    }//else if(p == "fieldName"){
						// 	s = s + "\n" + "暂定地点: " + dev_data.fieldName;
						// }else if(p == "time"){
						// 	s = s + "\n" + "预定时间:" + dev_data.time;
						// }else if(p == "goPlayerNum"){
						// 	s = s + "\n" + "已报名人数: " + dev_data.goPlayerNum;
						// }else if(p == "isNeedReferee"){
						// 	if(p == 0){
						// 		s = s + "\n" + "不需要裁判";
						// 	}else{
						// 		s = s + "\n" + "需要裁判";
						// 	}
						// }
						
					}
					alert(s);
				}
			},
			error: function(xhr, type, errorThrown) {
				alert("服务器内部出错！");
			}
		});
	});
}

function search_yzj(dev_id, request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;

		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var searchy_url = request_url + "AttentionAddRecord?userAccount=" + user.userAccount + "&devId=" + dev_id;
		 //alert(search_url);
		mui.ajax({
			type: 'GET',
			url: searchy_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if (data.message == "success") {
					var dev_data = new Array();
					dev_data = data.data;
					alert("已添加关注！");
					search(request_url);
				} else if(data.message == "already attention this device"){
					alert("您已经关注了此设备！");
					search(request_url);
				}
			},
			error: function(xhr, type, errorThrown) {
				alert("服务器内部出错！");
			}
		});
	});
}

function more(enId, request_url) {
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
						// if (p == "enId") {
						// 	s = s + "\n" + "约球ID: " + dev_data.enId;
						/* }else */if(p == "teamId"){
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

	// var s ="";

	// for (var p in dev_data) {
	// 	s= s+"n "+p+": "+dev_data[p];
	// }
	// alert(s);
}
