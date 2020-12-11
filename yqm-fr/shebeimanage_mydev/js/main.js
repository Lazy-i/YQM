function load_xian() {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		user = self.user;
		document.getElementById("main_username").innerHTML = user.userName;
	});
	
}

function load_xian_my() {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		user = self.user;
		document.getElementById("my_username").innerHTML = user.userName;
		if (user.userAuthority == 3) {
			document.getElementById("my_auth").innerHTML = "租借用户";
		} else if (user.userAuthority == 2) {
			document.getElementById("my_auth").innerHTML = "设备负责人";
		} else if (user.userAuthority == 1) {
			document.getElementById("my_auth").innerHTML = "经办人";
		} else if (user.userAuthority == 0) {
			document.getElementById("my_auth").innerHTML = "领导";
		} else if (user.userAuthority == -1) {
			document.getElementById("my_auth").innerHTML = "内测用户";
		}
	});
}

function to_myplayer(user) {
	mui.init();
	mui.openWindow({
		url: 'myplayer.html',
		extras: {
			user: user,
		}
	});
}

function to_myfield(user) {
	mui.init();
	mui.openWindow({
		url: 'myfield.html',
		extras: {
			user: user,
		}
	});
}

function to_arrange(user,request_url) {
	mui.init();
	var get_team_url = request_url + 'queryTeamByCaptainId?captainId=' + user.isPlayer;
	mui.plusReady(function() {
		mui.ajax({
			type: 'GET',
			url: get_team_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {
				if (data.data != null) {
					// var team_s = JSON.stringify(data.data);
					// team_s = team_s.substring(1, team_s.length - 1);
					// var team = JSON.parse(team_s);
					var team = new Array();
					team = data.data;
				}
				 var s ="";
	
				 // for (var p in team[0]) {
				 // 	s= s+"n "+p+": "+team[0][p];
				 // }
				 // alert(s);
	
				if (data.code == 0) {
					mui.toast(data.message);
					mui.openWindow({
						url:'arrange.html',
						// url: 'lineVis.html',
						extras: {
							user: user,
							team: team,
						},
						
					});
				} else {
					mui.toast(data.message);
				}
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}

function to_mine(user) {
	mui.init();
	mui.openWindow({
		url: 'mine.html',
		extras: {
			user: user,
		}
	});
}

function to_main(user) {
	mui.init();
	mui.plusReady(function() {
		var curr = plus.webview.currentWebview();
		var main_1 = plus.webview.getWebviewById('main_1');  
		       main_1.reload();  
		mui.openWindow({
			url: 'main.html',
			extras: {
				user: user,
			},
			id:'main_1',
		});
		curr.close();
	});
}

function to_search(user) {
	mui.init();
	mui.openWindow({
		url: 'search.html',
		extras: {
			user: user,
		}
	});
}

function to_buymore(user,team) {
	mui.init();
	mui.openWindow({
		url: 'buymore.html',
		extras: {
			user: user,
			team: team,
		}
	});
}

function to_checkEquipment(user) {
	mui.init();
	var get_team_url = request_url + 'queryTeamByCaptainId?captainId=' + user.isPlayer;
	mui.plusReady(function() {
		mui.ajax({
			type: 'GET',
			url: get_team_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {
				if (data.data != null) {
					// var team_s = JSON.stringify(data.data);
					// team_s = team_s.substring(1, team_s.length - 1);
					// var team = JSON.parse(team_s);
					var team = new Array();
					team = data.data;
				}
	// 			 var s ="";
	
	// 			  for (var p in team[0]) {
	// 			  	s= s+"n "+p+": "+team[0][p];
	// 			  }
	// 			  alert(s);
	
				if (data.code == 0) {
					mui.toast(data.message);
					mui.openWindow({
						url:'checkequipment.html',
						// url: 'lineVis.html',
						extras: {
							user: user,
							team: team,
						},
						
					});
				} else {
					mui.toast(data.message);
				}
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}

function to_myteam(user) {
	mui.init();
	mui.openWindow({
		url: 'myteam.html',
		extras: {
			user: user,
		}
	});
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
	
	function to_undoemail(user) {
		mui.init();
		mui.openWindow({
			url: 'undoemail.html',
			extras: {
				user: user,
			}
		});
	}