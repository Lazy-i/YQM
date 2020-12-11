	
function check_equ(request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 var team = self.team;
				 
				  // var s ="";
				 	
				  // for (var p in team[0]) {
				  // 	s= s+"n "+p+": "+team[0][p];
				  // }
				  // alert(s);
				 var get_Enrol_url = request_url + 'queryEnrolByTeamId?teamId=' + team[0].teamId;
				 // alert(search_check_url);
				 mui.ajax({
					 type:'GET',
					 url:get_Enrol_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if((data.data!=null)){
							var dev_data = new Array();
							dev_data=data.data;
								
							
							// var s ="";
								
							// for (var p in dev_data[0]) {
							// 	s= s+"n "+p+": "+dev_data[0][p];
							// }
							// alert(s);
							var temp_check2 = document.getElementById('temp_check2').innerHTML;
							document.getElementById('c_euq').innerHTML = template(temp_check2,{list:dev_data});
						}
					 },
					 error: function(xhr,type,errorThrown){
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
							if(dev_data.isNeedReferee == 0){
								s = s + "\n" + "不需要裁判";
							}else{
								s = s + "\n" + "需要裁判";
							}
						}else if(p == "isShowing"){
							if(dev_data.isShowing == 0){
								s = s + "\n" + "尚未发布";
							}else{
								s = s + "\n" + "已发布";
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

function more(dev_data_num,request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var search_check_url = request_url+'devUserAccount?userAccount='+user.userAccount;
				 // alert(search_url);
				 mui.ajax({
					 type:'GET',
					 url:search_check_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if((data.data!=null)){
							var dev_data = new Array();
							var dev_data_f = new Array();
							dev_data_f=data.data;
								
							for(i = 0, j = 0; i < dev_data_f.length; i++){
								if((dev_data_f[i].managerAccount==user.userAccount)||(dev_data_f[i].userAccount==user.userAccount)){
									dev_data[j]=dev_data_f[i];
									j++;
								}
							}
							// alert(dev_data_num);
							var dev_chadata=dev_data[dev_data_num];
							var s ="";
								
							for (var p in dev_chadata) {
									
								if((p=="devWorkStatus")||(p=="devStatus")){
										
									if(p=="devWorkStatus"){
										if(dev_chadata[p]==1){
											s= s+"\n"+"设备状态"+": "+"正常";
										}
										else if(dev_chadata[p]==2){
											s= s+"\n"+"设备状态"+": "+"报废";
										}
										else if(dev_chadata[p]==3){
											s= s+"\n"+"设备状态"+": "+"故障";
										}
										else if(dev_chadata[p]==4){
											s= s+"\n"+"设备状态"+": "+"维修";
										}
										else if(dev_chadata[p]==5){
											s= s+"\n"+"设备状态"+": "+"待报废";
										}
									}
									
									else if(p=="devStatus"){
										if(dev_chadata[p]==1){
											s= s+"\n"+"设备出借状态"+": "+"空闲";
										}
										else if(dev_chadata[p]==2){
											s= s+"\n"+"设备出借状态"+": "+"出借";
										}
									}
								}
									
								else if(p=="devId"){
									s= s+"\n"+"设备序号"+": "+dev_chadata[p];
								}
								else if(p=="devName"){
									s= s+"\n"+"设备名称"+": "+dev_chadata[p];
								}
								else if(p=="devType"){
									s= s+"\n"+"设备类型"+": "+dev_chadata[p];
								}
								else if(p=="devPrise"){
									s= s+"\n"+"设备价格(元)"+": "+dev_chadata[p];
								}
								else if(p=="devDate"){
									var data=new Array();
									var ti_me=new Array();
									data=dev_chadata[p].split(" ");
									ti_me=data[3].split(":");
									var mon=date_chin(data[1]);
									s= s+"\n"+"设备日期"+": "+data[5]+ "年" + mon + "月" + data[2]+"日"+"  "+ ti_me[0]+":"+ ti_me[1];
								}
								else if(p=="devPeriod"){
									s= s+"\n"+"设备保质期（天）"+": "+dev_chadata[p];
								}
								else if(p=="chargeAccount"){
									s= s+"\n"+"经办人"+": "+dev_chadata[p];
								}
								else if(p=="managerAccount"){
									s= s+"\n"+"设备负责人"+": "+dev_chadata[p];
								}
								else if(p=="devAuth"){
									s= s+"\n"+"设备权限"+": "+quan_chin(dev_chadata[p]);
								}
								else if(p=="userAccount"){
									if(dev_chadata[p]!=null)
									s= s+"\n"+"用户账号"+": "+dev_chadata[p];
								}
								else {
									s= s+"\n"+"用户账号"+": 无";
								}
							}
							alert(s);
						}
					 },
					 error: function(xhr,type,errorThrown){
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
