function login(name, password) {
	if (name != null && password != null && name != "" && password != "") {
		$.post("../../admin/login/info-verify", {
			name : name,
			password : password
		}, function(data) {
			switch (data["result"]) {
			case "success":
				window.location.href = "../../views/admin/index.html";
				break;
			case "failure": {
				alert("用户名或密码错误");
				loginForm.password = "";
			}
			;
			break;
			default: {
				alert("未知错误")
				loginForm.password = "";
			}
			;
			}
		}, "json")
	} else {
		alert("用户名或密码都不能为空");
	}
}
var loginForm = new Vue({
	el : "#login-form",
	data : {
		name : "",
		password : ""
	},
	methods : {
		submit : function() {
			login($.trim(this.name), $.trim(this.password));
		}
	}
})