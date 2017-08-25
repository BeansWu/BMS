/** 获取所有书架信息 **/
function findAll() {
	$.get("../../../admin/sys-set/bookrack-set/find-all", function(data) {
		bookrackSetForm.init(data);
	})
}
findAll();
/** 添加书架 **/
function add(newBookrack) {
    $.ajax({
        type: "POST",
        url: "../../../admin/sys-set/bookrack-set/add",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newBookrack),
        success: function(data) {
        	switch(data["result"]) {
        	case"success": alert("添加成功");break;
        	case"failure": alert("添加失败");break;
        	default: alert("未知错误");
        	}
        	findAll();
        }
    })
}
/** 删除书架 **/
function del(id) {
    $.get("../../../admin/sys-set/bookrack-set/del", {id : id}, function(data) {
    	switch(data["result"]) {
    	case"success": alert("删除成功");break;
    	case"failure": alert("删除失败");break;
    	default: alert("未知错误");
    	}
    	findAll();
    }, "json");
}
/** 修改书架信息 **/
function modify(newBookrack) {
    $.ajax({
        type: "POST",
        url: "../../../admin/sys-set/bookrack-set/update",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newBookrack),
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
var bookrackSetForm = new Vue({
    el : "#bookrack-set-form",
    data : {
        bookracks: ""
    },
    methods : {
    	init: function (data) {
    		this.bookracks = data;
    	},
        add : function () {
            $("#bookrack-add-modal").modal();
        },
        del : function (event) {
            del($(event.target).attr("name"));
        },
        modify : function (event) {
            for (var i = 0; i < this.bookracks.length; i++) {
                if (this.bookracks[i].id == $(event.target).attr("name")) {
                    modify(this.bookracks[i]);
                    break;
                }
            }
        }
    }
})
new Vue({
    el : "#bookrack-add-modal",
    data : {
        bookrack : {
            id: "",
            pressmark: ""
        }
    },
    methods : {
        submit : function (event) {
            add(this.bookrack)
        }
    }
})