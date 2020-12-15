function addteam(user,request_url) {
	mui.init();
	var o_password = document.getElementById("o_password").value;
	var useraccount = document.getElementById("account").value;
	var cha_opd = is_special(o_password);
	var cha_ua = is_special(useraccount);

	if ( cha_opd == 1 || cha_ua == 1) {
		mui.toast("输入的格式不正确！应输入数字或字母！");
	}
	if (useraccount.length == 0) {
		mui.toast("名称不能为空！");
		return;

	} else if (o_password.length == 0) {
		mui.toast("请填写联系电话！");
		return;
	} else {
		if (user.isCaptain==-1) {
			mui.toast("您当前不是队长！");
			return;
		} else {
			var repasswordurl = request_url + 'addTeam?teamName=' + useraccount + '&CaptainId=' + user.isCaptain +
				'&captainTelephoneNumber=' + o_password;
			mui.plusReady(function() {
				mui.ajax({
					type: 'GET',
					url: repasswordurl,
					timeout: 10000,
					success: function(data) {
						// var s ="";

						// for (var p in data) {
						// 	s= s+"n "+p+": "+data[p];
						// }
						// alert(s);
						if (data.code == 0) {
							mui.toast(data.message);
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
	}
}