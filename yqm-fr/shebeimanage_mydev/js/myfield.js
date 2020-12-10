
function myfield(request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;
		// var s ="";
		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// mui.toast(s);
		if(user.isFieldManager==-1){
			 alert("您当前不是场地负责人，请前往'我的'界面注册成为场地负责人！");
		}
		var myfield_url = request_url + 'queryFieldByFieldManagerId?fieldManagerId=' + user.isFieldManager;
		// alert(user.isFieldManger);
		mui.ajax({
			type: 'GET',
			url: myfield_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {
				// alert(data.message);
				if (data.data != null) {
					var field_data = new Array();
					field_data = data.data;
					// var s ="";
					// for (var p in field_data[0]) {
					// 	s= s+"n "+p+": "+field_data[0][p];
					// }
					// alert(s);
					var temp_stable = document.getElementById('follow_texts').innerHTML;
					document.getElementById('follow_tb').innerHTML = template(temp_stable, {
						list: field_data
					});
				}
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}

// function is_have_mail(request_url) {
// 	mui.init();
// 	mui.plusReady(function() {
// 		var self = plus.webview.currentWebview();
// 		var user = self.user;
// 		// var s ="";

// 		// for (var p in user) {
// 		// 	s= s+"n "+p+": "+user[p];
// 		// }
// 		// mui.toast(s);
// 		var search_url = request_url + 'EmailFindByUserAccount?userAccount=' + user.userAccount;
// 		// alert(search_url);
// 		mui.ajax({
// 			type: 'GET',
// 			url: search_url,
// 			timeout: 10000,
// 			dataType: "json",
// 			success: function(data) {

// 				if (data.data != null) {
// 					var dev_data = new Array();
// 					dev_data = data.data;
// 					if(dev_data.length == 0){
// 					    var btn_is_mail = ['稍后再说', '现在绑定'];
// 						mui.confirm("您还没有绑定邮箱!\n若您不绑定邮箱,您将无法通过邮箱获得您关注设备的事实信息。","提示",btn_is_mail,function(e) {
// 							if (e.index == 1) {
// 								to_email(user);
// 							}
// 						});
// 					}	
// 				}
// 			},
// 			error: function(xhr, type, errorThrown) {
// 				mui.toast("服务器内部出错！");
// 			}
// 		});
// 	});
// }

function more(fieldid, request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;

		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var field_info_url = request_url + "queryFieldById?fieldId=" + fieldid;
		
		mui.ajax({
			type: 'GET',
			url: field_info_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if ((data.data != null)) {
					var field_info_data = data.data[0];
					var s ="";
					//alert(dev_data);
					for (var p in field_info_data) {
						
						if(p=="fieldId"){
							s= s+"\n"+"场地识别码"+": "+field_info_data[p];
						}
						else if(p=="fieldName"){
							s= s+"\n"+"场地名称"+": "+field_info_data[p];
						}
						else if(p=="fieldSpace"){
							s= s+"\n"+"场地地点"+": "+field_info_data[p];
						}
						else if(p=="fieldState"){
							if(field_info_data[p]==0){
								s = s + "\n" + "场地状态" + ": " + "空闲";
							}
							else if(field_info_data[p]==1){
								s = s + "\n" + "场地状态" + ": " + "已租用";
							}
							else if(field_info_data[p]==2){
								s = s + "\n" + "场地状态" + ": " + "维护";
							}
							
						}
						else if(p=="openTime"){
							var open_time=new Array();
							open_time=field_info_data[p].split("-");
							s= s+"\n"+"开放时间"+": "+open_time[0]+ "时 至 " + open_time[1]+"时";
						}
						else if(p=="fieldManagerId"){
							s= s+"\n"+"负责人"+": "+field_info_data[p];
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

	function to_email(user) {
		mui.init();
		mui.openWindow({
			url: 'email.html',
			extras: {
				user: user,
			}
		});
	}
	
	function undo_follow(request_url,devId) {
		mui.init();
		mui.plusReady(function() {
			var self = plus.webview.currentWebview();
			var user = self.user;
			// var s ="";
	
			// for (var p in user) {
			// 	s= s+"n "+p+": "+user[p];
			// }
			// mui.toast(s);
			var undofollow_url = request_url + 'AttentionCancelRecord?userAccount=' + user.userAccount + '&devId=' + devId;
			 //alert(undofollow_url);
			mui.ajax({
				type: 'GET',
				url: undofollow_url,
				timeout: 10000,
				dataType: "json",
				success: function(data) {
					if (data.message == "success") {
						mui.toast("已取消关注");
						follow_m(request_url);
					}
				},
				error: function(xhr, type, errorThrown) {
					mui.toast("服务器内部出错！");
					follow_m(request_url);
				}
			});
		});
	}
	function add_record(request_url, fieldName, fieldSpace,openTime,fieldState,fieldManagerId,fieldId,num) {
		var record_se = document.getElementById("record-" + num);
		var record_type = record_se.options[record_se.selectedIndex].value;
		if (record_type == "item-2") {
			add_kong(request_url, fieldName, fieldSpace,openTime,0,fieldManagerId,fieldId);
		} else if (record_type == "item-3") {
			add_zu(request_url, fieldName, fieldSpace,openTime,1,fieldManagerId,fieldId);
		} else if (record_type == "item-4") {
			add_wei(request_url, fieldName, fieldSpace,openTime,2,fieldManagerId,fieldId);
		} else if (record_type == "item-1") {
			alert("请选择您要添加的记录类型！")
		}
	 }
	 function add_kong(request_url, fieldName, fieldSpace,openTime,fieldState,fieldManagerId,fieldId) {
	 	mui.init();
	 	mui.plusReady(function() {
	 		var self = plus.webview.currentWebview();
	 		var user = self.user;
	 
	 		// var s ="";
	 
	 		// for (var p in user) {
	 		// 	s= s+"n "+p+": "+user[p];
	 		// }
	 		// alert(s);
	 		var add_kong_url = request_url + 'updateField?fieldName=' + fieldName + '&fieldSpace=' + fieldSpace + '&openTime=' + openTime + '&fieldState=' + fieldState + '&fieldManagerId=' + fieldManagerId+ '&fieldId=' + fieldId;
	 		mui.ajax({
	 			type: 'GET',
	 			url: add_kong_url,
	 			timeout: 10000,
	 			dataType: "json",
	 			success: function(data) {
	 				mui.toast(data.message);
	 				myfield(request_url);
	 			},
	 			error: function(xhr, type, errorThrown) {
	 				mui.toast("服务器内部出错！");
	 			}
	 		});
	 	});
	 }
	 
	 function add_zu(request_url, fieldName, fieldSpace,openTime,fieldState,fieldManagerId,fieldId) {
	 	mui.init();
	 	mui.plusReady(function() {
	 		var self = plus.webview.currentWebview();
	 		var user = self.user;
	 
	 		// var s ="";
	 
	 		// for (var p in user) {
	 		// 	s= s+"n "+p+": "+user[p];
	 		// }
	 		// alert(s);
	 		var add_zu_url = request_url + 'updateField?fieldName=' + fieldName + '&fieldSpace=' + fieldSpace + '&openTime=' + openTime + '&fieldState=' + fieldState + '&fieldManagerId=' + fieldManagerId+ '&fieldId=' + fieldId;
	 		mui.ajax({
	 			type: 'GET',
	 			url: add_zu_url,
	 			timeout: 10000,
	 			dataType: "json",
	 			success: function(data) {
	 				mui.toast(data.message);
	 				myfield(request_url);
	 			},
	 			error: function(xhr, type, errorThrown) {
	 				mui.toast("服务器内部出错！");
	 			}
	 		});
	 	});
	 }
	 
	 function add_wei(request_url, fieldName, fieldSpace,openTime,fieldState,fieldManagerId,fieldId) {
	 	mui.init();
	 	mui.plusReady(function() {
	 		var self = plus.webview.currentWebview();
	 		var user = self.user;
	 
	 		// var s ="";
	 
	 		// for (var p in user) {
	 		// 	s= s+"n "+p+": "+user[p];
	 		// }
	 		// alert(s);
	 		var add_wei_url = request_url + 'updateField?fieldName=' + fieldName + '&fieldSpace=' + fieldSpace + '&openTime=' + openTime + '&fieldState=' + fieldState + '&fieldManagerId=' + fieldManagerId+ '&fieldId=' + fieldId;
	 		mui.ajax({
	 			type: 'GET',
	 			url: add_wei_url,
	 			timeout: 10000,
	 			dataType: "json",
	 			success: function(data) {
	 				mui.toast(data.message);
	 				myfield(request_url);
	 			},
	 			error: function(xhr, type, errorThrown) {
	 				mui.toast("服务器内部出错！");
	 			}
	 		});
	 	});
	 }
	