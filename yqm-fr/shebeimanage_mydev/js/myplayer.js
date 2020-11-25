var player_data = new Array();
function sleep(interval) {
				return new Promise(resolve => {
					setTimeout(resolve, interval);
				})
			}
function search_teamallplayer(request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;
			
		if(user.isplayer==-1){
			 alert("您还未成为球员，请前往'我的'界面注册成为球员！");
		}
		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var get_player_url = request_url + 'queryPlayerByUserAccount?userAccount=' + user.userAccount;
		// alert(search_url);
		mui.ajax({
			type: 'GET',
			url: get_player_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {
                   
				if ((data.data != null)) {
					 player_data = data.data;
					 player_now=player_data[0];	
					if(player_now.isCaptain==-1){
						alert('您当前不是球队队长，请前往创建球队!');
					}
					else{
						var search_teamallplayer_url = request_url + 'queryTeamAllPlayerById?teamId=' + player_now.isCaptain;
						
						// var s ="";
						// for (var p in player_now){
						// 	s= s+"n "+p+": "+player_now[p];
						// }
						// alert(s);
						mui.ajax({
							type:'GET',
							url:search_teamallplayer_url,
							timeout:10000,
							dataType:"json",
							success:function(data_teamplayer){
								var teamplayer_data = new Array();
								teamplayer_data=data_teamplayer.data;
								
								var temp_stable = document.getElementById('temp_stable').innerHTML;
								document.getElementById('fuze').innerHTML = template(temp_stable, {
									list: teamplayer_data
								});
							},
							error: function(xhr, type, errorThrown) {
								mui.toast("服务器内部出错！-111");
							}
						});
					}
					
				}
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	})
}

function more(playerId, request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;

		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var search_player_url = request_url + 'queryPlayerById?playerId=' + playerId;
		//alert(search_player_url);
		mui.ajax({
			type: 'GET',
			url: search_player_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if ((data.data != null)) {
					
					var player_data = data.data[0];
					// var k ="";
					// for (var p in player_data){
					// 	k= k+"n "+p+": "+player_data[p];
					// }
					// alert(k);
					var s = "";

					for (var p in player_data) {
						
						if(p=="playerId"){
							s= s+"\n"+"球员id"+": "+player_data[p];
						}
						else if(p=="name"){
							s= s+"\n"+"球员名称"+": "+player_data[p];
						}
						else if(p=="telephoneNumber"){
							s= s+"\n"+"联系电话"+": "+player_data[p];
						}
						else if(p=="emergencyContactNumber"){
							s= s+"\n"+"紧急联系电话"+": "+player_data[p];
						}
					}
					alert(s);
				}
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

// function more_zujie(dev_data_num, request_url) {
// 	mui.init();
// 	mui.plusReady(function() {
// 		var self = plus.webview.currentWebview();
// 		var user = self.user;

// 		// var s ="";

// 		// for (var p in user) {
// 		// 	s= s+"n "+p+": "+user[p];
// 		// }
// 		// alert(s);
// 		var search_zujie_url = request_url + 'devDevUserAccount?userAccount=' + user.userAccount;
// 		// alert(search_url);
// 		mui.ajax({
// 			type: 'GET',
// 			url: search_zujie_url,
// 			timeout: 10000,
// 			dataType: "json",
// 			success: function(data) {

// 				if ((data.data != null)) {
// 					var dev_data = new Array();
// 					dev_data = data.data;
// 					var dev_chadata = dev_data[dev_data_num];
// 					var s = "";
// 					for (var p in dev_chadata) {

// 						if ((p == "devWorkStatus") || (p == "devStatus")) {

// 							if (p == "devWorkStatus") {
// 								if (dev_chadata[p] == 1) {
// 									s = s + "\n" + "设备状态" + ": " + "正常";
// 								} else if (dev_chadata[p] == 2) {
// 									s = s + "\n" + "设备状态" + ": " + "报废";
// 								} else if (dev_chadata[p] == 3) {
// 									s = s + "\n" + "设备状态" + ": " + "故障";
// 								} else if (dev_chadata[p] == 4) {
// 									s = s + "\n" + "设备状态" + ": " + "维修";
// 								} else if (dev_chadata[p] == 5) {
// 									s = s + "\n" + "设备状态" + ": " + "待报废";
// 								}
// 							} else if (p == "devStatus") {
// 								if (dev_chadata[p] == 1) {
// 									s = s + "\n" + "设备出借状态" + ": " + "空闲";
// 								} else if (dev_chadata[p] == 2) {
// 									s = s + "\n" + "设备出借状态" + ": " + "出借";
// 								}
// 							}
// 						}
// 						else if(p=="devId"){
// 							s= s+"\n"+"设备序号"+": "+dev_chadata[p];
// 						}
// 						else if(p=="devName"){
// 							s= s+"\n"+"设备名称"+": "+dev_chadata[p];
// 						}
// 						else if(p=="devType"){
// 							s= s+"\n"+"设备类型"+": "+dev_chadata[p];
// 						}
// 						else if(p=="devPrise"){
// 							s= s+"\n"+"设备价格(元)"+": "+dev_chadata[p];
// 						}
// 						else if(p=="devDate"){
// 							var data=new Array();
// 							var ti_me=new Array();
// 							data=dev_chadata[p].split(" ");
// 							ti_me=data[3].split(":");
// 							var mon=date_chin(data[1]);
// 							s= s+"\n"+"设备日期"+": "+data[5]+ "年" + mon + "月" + data[2]+"日"+"  "+ ti_me[0]+":"+ ti_me[1];
// 						}
// 						else if(p=="devPeriod"){
// 							s= s+"\n"+"设备保质期（天）"+": "+dev_chadata[p];
// 						}
// 						else if(p=="chargeAccount"){
// 							s= s+"\n"+"经办人"+": "+dev_chadata[p];
// 						}
// 						else if(p=="managerAccount"){
// 							s= s+"\n"+"设备负责人"+": "+dev_chadata[p];
// 						}
// 						else if(p=="devAuth"){
// 							s= s+"\n"+"设备权限"+": "+quan_chin(dev_chadata[p]);
// 						}
// 						else if(p=="userAccount"){
// 							if(dev_chadata[p]!="null"){
// 							s= s+"\n"+"用户账号"+": "+dev_chadata[p];
// 							}
// 							else {
// 								s= s+"\n"+"用户账号"+": 无";
// 							}
// 						}
// 					}
// 					alert(s);
// 				}
// 			},
// 			error: function(xhr, type, errorThrown) {
// 				mui.toast("服务器内部出错！");
// 			}
// 		});
// 	});

// 	// var s ="";

// 	// for (var p in dev_data) {
// 	// 	s= s+"n "+p+": "+dev_data[p];
// 	// }
// 	// alert(s);
// }

// function add_xiu(request_url, dev_data_num) {
// 	mui.init();
// 	mui.plusReady(function() {
// 		var self = plus.webview.currentWebview();
// 		var user = self.user;

// 		// var s ="";

// 		// for (var p in user) {
// 		// 	s= s+"n "+p+": "+user[p];
// 		// }
// 		// alert(s);
// 		var add_fix_url = request_url + 'devAddFixRecord?userAccount=' + user.userAccount + '&devId=' + dev_data_num;
// 		mui.ajax({
// 			type: 'GET',
// 			url: add_fix_url,
// 			timeout: 10000,
// 			dataType: "json",
// 			success: function(data) {
// 				mui.toast(data.message);
// 				search_fuze_zujie(request_url);
// 			},
// 			error: function(xhr, type, errorThrown) {
// 				mui.toast("服务器内部出错！");
// 			}
// 		});
// 	});
// }

// function add_damage(request_url, dev_data_num) {
// 	mui.init();
// 	mui.plusReady(function() {
// 		var self = plus.webview.currentWebview();
// 		var user = self.user;

// 		// var s ="";

// 		// for (var p in user) {
// 		// 	s= s+"n "+p+": "+user[p];
// 		// }
// 		// alert(s);
// 		var add_damage_url = request_url + 'devAddDamageRecord?userAccount=' + user.userAccount + '&devId=' + dev_data_num;
// 		mui.ajax({
// 			type: 'GET',
// 			url: add_damage_url,
// 			timeout: 10000,
// 			dataType: "json",
// 			success: function(data) {
// 				mui.toast(data.message);
// 				search_fuze_zujie(request_url);
// 			},
// 			error: function(xhr, type, errorThrown) {
// 				mui.toast("服务器内部出错！");
// 			}
// 		});
// 	});
// }

// function add_scrap(request_url, dev_data_num) {
// 	mui.init();
// 	mui.plusReady(function() {
// 		var self = plus.webview.currentWebview();
// 		var user = self.user;

// 		// var s ="";

// 		// for (var p in user) {
// 		// 	s= s+"n "+p+": "+user[p];
// 		// }
// 		// alert(s);
// 		var add_scrap_url = request_url + 'devAddScrapRecord?userAccount=' + user.userAccount + '&devId=' + dev_data_num;
// 		mui.ajax({
// 			type: 'GET',
// 			url: add_scrap_url,
// 			timeout: 10000,
// 			dataType: "json",
// 			success: function(data) {
// 				mui.toast(data.message);
// 				search_fuze_zujie(request_url);
// 			},
// 			error: function(xhr, type, errorThrown) {
// 				mui.toast("服务器内部出错！");
// 			}
// 		});
// 	});
// }


// function add_record(request_url, dev_data_num, num) {
// 	var record_se = document.getElementById("record-" + num);
// 	var record_type = record_se.options[record_se.selectedIndex].value;
// 	if (record_type == "item-2") {
// 		add_xiu(request_url, dev_data_num);
// 	} else if (record_type == "item-3") {
// 		add_damage(request_url, dev_data_num);
// 	} else if (record_type == "item-4") {
// 		add_scrap(request_url, dev_data_num);
// 	} else if (record_type == "item-1") {
// 		alert("请选择您要添加的记录类型！")
// 	}
// }


// function back(request_url, dev_data_num) {
// 	mui.init();
// 	mui.plusReady(function() {
// 		var self = plus.webview.currentWebview();
// 		var user = self.user;

// 		// var s ="";

// 		// for (var p in user) {
// 		// 	s= s+"n "+p+": "+user[p];
// 		// }
// 		// alert(s);
// 		var back_url = request_url + 'devRevert?userAccount=' + user.userAccount + '&devId=' + dev_data_num;
// 		mui.ajax({
// 			type: 'GET',
// 			url: back_url,
// 			timeout: 10000,
// 			dataType: "json",
// 			success: function(data) {
// 				mui.toast(data.message);
// 				search_fuze_zujie(request_url);
// 			},
// 			error: function(xhr, type, errorThrown) {
// 				mui.toast("服务器内部出错！");
// 			}
// 		});
// 	});
// }

// function add_guzhang(dev_data_num,request_url) {
// 	mui.init();
// 	mui.plusReady(function() {
// 		var self = plus.webview.currentWebview();
// 		var user = self.user;

// 		// var s ="";
// 		// for (var p in user) {
// 		// 	s= s+"n "+p+": "+user[p];
// 		// }
// 		// alert(s);
// 		var add_xiuli_url = request_url + 'logAddRepairRecord?userAccount=' + user.userAccount + '&devId=' + dev_data_num;
// 		mui.ajax({
// 			type: 'GET',
// 			url: add_xiuli_url,
// 			timeout: 10000,
// 			dataType: "json",
// 			success: function(data) {
// 				mui.toast(data.message);
// 				search_fuze_zujie(request_url);
// 			},
// 			error: function(xhr, type, errorThrown) {
// 				mui.toast("服务器内部出错！");
// 			}
// 		});
// 	});
// }
