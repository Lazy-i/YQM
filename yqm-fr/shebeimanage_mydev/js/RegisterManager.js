
function finish(request_url) {
    mui.init();
    var Telephone = document.getElementById("Telephone").value;
    // var EmergencyTelephone = document.getElementById("EmergencyTelephone").value;
    var username = document.getElementById("name").value;
    var Check_Emer_Tele = is_num(EmergencyTelephone);
    var Check_Tele = is_num(Telephone);



    if (Check_Emer_Tele == 1 || Check_Tele == 1) {
        mui.toast("输入的格式不正确！应输入数字！");
        return;
    }
    if (username.length == 0) {
        mui.toast("姓名不能为空！");
        return;
    } else if (Telephone.length == 0) {
        mui.toast("请填写联系电话！");
        return;
    // } else if (EmergencyTelephone.length == 0) {
    //     mui.toast("请填写紧急联系电话！");
    //     return;
    } else {
        mui.plusReady(function() {
            var self = plus.webview.currentWebview();
            var user = self.user;
            var registerurl = request_url + 'AddFieldManager?name=' + username 
                    + '&telephoneNumber=' + Telephone 
                    + '&userAccount' + user.userAccount
                    + '&userPassword' + user.userPassword;
            mui.ajax({
                type: 'GET',
                url: registerurl,
                timeout: 10000,
                success: function(data) {
                    if (data.code == 0) {
                        mui.toast(data.message);
                        mui.openWindow({
                            url:'mine.html'
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
}

function quit() {
	mui.init();
	mui.plusReady(function() {
		mui.back();
	});
}