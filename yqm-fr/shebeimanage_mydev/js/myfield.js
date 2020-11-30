
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
						// if (p == "fieldId") {

						// 	if (p == "devWorkStatus") {
						// 		if (dev_data[p] == 1) {
						// 			s = s + "\n" + "设备状态" + ": " + "正常";
						// 		} else if (dev_data[p] == 2) {
						// 			s = s + "\n" + "设备状态" + ": " + "报废";
						// 		} else if (dev_data[p] == 3) {
						// 			s = s + "\n" + "设备状态" + ": " + "故障";
						// 		} else if (dev_data[p] == 4) {
						// 			s = s + "\n" + "设备状态" + ": " + "维修";
						// 		} else if (dev_data[p] == 5) {
						// 			s = s + "\n" + "设备状态" + ": " + "待报废";
						// 		}
						// 	} else if (p == "devStatus") {
						// 		if (dev_data[p] == 1) {
						// 			s = s + "\n" + "设备出借状态" + ": " + "空闲";
						// 		} else if (dev_data[p] == 2) {
						// 			s = s + "\n" + "设备出借状态" + ": " + "出借";
						// 		}
						// 	}
						// } 
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
	