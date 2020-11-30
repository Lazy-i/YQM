function to_register() {
    mui.init();
    mui.openWindow({
        url: 'RegisterPlayer.html',
    });
}

function register_m(request_url) {
    mui.init();
    var Telephone = document.getElementById("Telephone").value;
    var code = document.getElementById("code").value;
    var username = document.getElementById("PlayerNmae").value;
    var Check_Emer_Tele = is_num(code);
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
    } else if (code.length == 0) {
        mui.toast("请填写裁判员证书编码！");
        return;
    } else {
        mui.plusReady(function() {
            var self = plus.webview.currentWebview();
            var user = self.user;
            var registerurl = request_url + '/api/addReferee?name=' + username 
                    + '&telephoneNumber=' + refereeNumber 
                    + '&refereeNumber=' + code 
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
