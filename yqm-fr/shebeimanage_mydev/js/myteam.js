function my_team(request_url) {
		mui.init();
		mui.plusReady(function() {
			var self = plus.webview.currentWebview();
			var user = self.user;

			// var s ="";

			// for (var p in user) {
			// 	s= s+"n "+p+": "+user[p];
			// }
			// alert(s);
			var search_myteam_url = request_url + 'queryPlayerAllTeamById?playerId=' + user.isPlayer;
			
			// alert(search_url);
				
			if(user.isPlayer==-1){
				alert("您还未成为球员，请前往'我的'界面注册成为球员！");
			}
			mui.ajax({
				type: 'GET',
				url: search_myteam_url,
				timeout: 10000,
				dataType: "json",
				success: function(data) {

					if ((data.data != null)) {
						var team_data = new Array();
						team_data = data.data;
						// var now_data = new Array();
						// var al_data = new Array();
						// for (i = 0, j = 0, k = 0; i < log_data.length; i++) {
						// 	if ((log_data[i].tokenStatus != 3)&&(log_data[i].senderAccount==user.userAccount)) {
						// 		al_data[j] = log_data[i];
						// 		j++;
						// 	} else if ((log_data[i].tokenStatus == 3)&&(log_data[i].senderAccount==user.userAccount)) {
						// 		now_data[k] = log_data[i];
						// 		k++;
						// 	}
						// }
						// al_data.sort(function(x,y){
						// 	return y.logId-x.logId;
						// });
						var temp_now_shen = document.getElementById('temp_now_shen').innerHTML;
						document.getElementById('shen_now').innerHTML = template(temp_now_shen, {
							list: team_data
						});
						// var temp_al_shen = document.getElementById('temp_al_shen').innerHTML;
						// document.getElementById('shen_al').innerHTML = template(temp_al_shen, {
						// 	list: al_data
						// });
						// 	var s ="";

						// 	for (var p in dev_chadata) {
						// 		s= s+"\n"+p+": "+dev_chadata[p];
						// 	}
						// 	alert(s);
					}
				},
				error: function(xhr, type, errorThrown) {
					mui.toast("服务器内部出错！");
				}
			});
		});
	}

	function team_more(teamid, request_url) {
		mui.init();
		mui.plusReady(function() {
			var self = plus.webview.currentWebview();
			var user = self.user;

			// var s ="";

			// for (var p in user) {
			// 	s= s+"n "+p+": "+user[p];
			// }
			// alert(s);
			var team_ifo_url = request_url + 'queryTeamById?teamId=' +teamid;
			// alert(search_url);
			mui.ajax({
				type: 'GET',
				url: team_ifo_url,
				timeout: 10000,
				dataType: "json",
				success: function(data) {

					if ((data.data != null)) {
						var team_data=data.data[0];
						// al_data.sort(function(x,y){
						// 	return y.logId-x.logId;
						// });

						var s = "";

						for (var p in team_data) {
							if (p == "teamId") {
								s = s + "\n" + "球队编号" + ": " + team_data[p];
							} else if (p == "teamName") {
								s = s + "\n" + "球队名称" + ": " + team_data[p];
							} else if (p == "captainId") {
								s = s + "\n" + "队长编号" + ": " + team_data[p];
							} else if (p == "captainTelephoneNumber") {
								s = s + "\n" + "队长电话" + ": " + team_data[p];
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


	function delete_teamplayer(playerid,teamid,iscap,request_url) {
		mui.init();
		mui.plusReady(function() {
			var self = plus.webview.currentWebview();
			var user = self.user;

			// var s ="";

			// for (var p in user) {
			// 	s= s+"n "+p+": "+user[p];
			// }
			// alert(s);
			var delete_teamplayer_url = request_url + 'deleteTeamPlayer?playerId=' + playerid + '&teamId=' + teamid +
				'&isCaptain='+iscap;
			// alert(search_url);
			mui.ajax({
				type: 'GET',
				url: delete_teamplayer_url,
				timeout: 10000,
				dataType: "json",
				success: function(data) {

					if ((data.code == 0)) {
						mui.toast("退出成功！")
						my_team(request_url);
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
	function to_team_add(user) {
		mui.init();
		mui.openWindow({
			url: 'addteam.html',
			extras: {
				user: user,
			}
		});
	}
