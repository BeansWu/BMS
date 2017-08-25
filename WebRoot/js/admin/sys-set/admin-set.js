/** 获取所有管理员信息 **/
function findAll() {
	$.get("../../../super-admin/sys-set/admin-set/find-all", function(data) {
		adminSetForm.init(data);
	})
}
findAll();
/** 添加管理员 **/
function add(newAdmin) {
	$.ajax({
		type : "POST",
		url : "../../../super-admin/sys-set/admin-set/add",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(newAdmin),
		success : function(data) {
			switch (data["result"]) {
			case "success":
				alert("添加成功");
				break;
			case "failure":
				alert("添加失败");
				break;
			default:
				alert("未知错误");
				break;
			}
			findAll();
		}
	})
}
/** 删除管理员 **/
function del(id) {
	$.get("../../../super-admin/sys-set/admin-set/del", {
		id : id
	}, function(data) {
		switch (data["result"]) {
		case "success":
			alert("删除成功");
			break;
		case "failure":
			alert("删除失败");
			break;
		default:
			alert("未知错误");
			break;
		}
		findAll();
	}, "json");
}
/** 修改权限 **/
function modify(newAdmin) {
	$.ajax({
		type : "POST",
		url : "../../../super-admin/sys-set/admin-set/update",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(newAdmin),
		success : function(data) {
			switch (data["result"]) {
			case "success":
				alert("修改成功");
				break;
			case "failure":
				alert("修改失败");
				break;
			default:
				alert("未知错误");
				break;
			}
			findAll();
		}
	})
}
var adminSetForm = new Vue({
	el : "#admin-set-form",
	data : {
		admins : ""
	},
	methods : {
		init : function(data) {
			this.admins = data;
		},
		add : function() {
			$("#admin-add-modal").modal();
		},
		del : function(event) {
			del($(event.target).attr("name"));
		},
		modify : function(event) {
			for (var i = 0; i < this.admins.length; i++) {
				if (this.admins[i].id == $(event.target).attr("name")) {
					modify(this.admins[i]);
					break;
				}
			}
		}
	}
})
new Vue({
	el : "#admin-add-modal",
	data : {
		repeatPassword : "",
		admin : {
			id : "",
			name : "",
			password : "",
			sysSet : false,
			bookMgt : false,
			readerMgt : false,
			bookBorrowAndReturn : false,
			sysSearch : false
		}
	},
	methods : {
		submit : function(event) {
			add(this.admin);
			this.admin.id = "";
			this.admin.name = "";
			this.admin.password = "";
			this.repeatPassword = "";
		}
	}
})