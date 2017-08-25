/** 获取所有图书类型信息 **/
function findAll() {
	$.get("../../../admin/book-mgt/book-type-mgt/find-all", function(data) {
		bookTypeSetForm.init(data);
	})
}
findAll();
/** 添加图书类型 **/
function add(newBookType) {
	$.ajax({
		type : "POST",
		url : "../../../admin/book-mgt/book-type-mgt/add",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(newBookType),
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
			}
			findAll();
		}
	})
}
/** 删除书架 **/
function del(id) {
	$.get("../../../admin/book-mgt/book-type-mgt/del", {
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
		}
		findAll();
	}, "json");
}
/** 修改书架 **/
function modify(newBookType) {
	$.ajax({
		type : "POST",
		url : "../../../admin/book-mgt/book-type-mgt/update",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(newBookType),
        success: function(data) {
        	switch(data["result"]) {
        	case"success": alert("修改成功");break;
        	case"failure": alert("修改失败");break;
        	default: alert("未知错误");
        	}
        	findAll();
        }
	})
}
var bookTypeSetForm = new Vue({
	el : "#book-type-set-form",
	data : {
		bookTypes : ""
	},
	methods : {
		init : function(data) {
			this.bookTypes = data;
		},
		add : function() {
			$("#book-type-add-modal").modal();
		},
		del : function(event) {
			del($(event.target).attr("name"));
		},
		modify : function(event) {
			for (var i = 0; i < this.bookTypes.length; i++) {
				if (this.bookTypes[i].id == $(event.target).attr("name")) {
					modify(this.bookTypes[i]);
					break;
				}
			}
		}
	}
})
new Vue({
	el : "#book-type-add-modal",
	data : {
		bookType : {
			id : "",
			name : "",
			dayCanBorrow : ""
		}
	},
	methods : {
		submit : function(event) {
			add(this.bookType);
			this.bookType.id = "";
			this.bookType.name = "";
			this.bookType.dayCanBorrow = "";
		}
	}
})