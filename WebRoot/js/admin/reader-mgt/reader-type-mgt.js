/** 获取所有读者类型信息 **/
function findAll() {
    $.get("../../../admin/reader-mgt/reader-type-mgt/find-all", function(data) {
    	readerTypeSetForm.init(data);
    })
}
findAll();
/** 添加读者类型 **/
function add(newReaderType) {
    $.ajax({
        type: "POST",
        url: "../../../admin/reader-mgt/reader-type-mgt/add",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newReaderType),
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
    $.get("../../../admin/reader-mgt/reader-type-mgt/del", {id : id}, function(data) {
    	switch(data["result"]) {
    	case"success": alert("删除成功");break;
    	case"failure": alert("删除失败");break;
    	default: alert("未知错误");
    	}
    	findAll();
    }, "json");
}
/** 修改书架 **/
function modify(newReaderType) {
    $.ajax({
        type: "POST",
        url: "../../../admin/reader-mgt/reader-type-mgt/update",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newReaderType),
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
var readerTypeSetForm = new Vue({
    el : "#reader-type-set-form",
    data : {
        readerTypes: ""
    },
    methods : {
    	init: function(data) {
    		this.readerTypes = data;
    	},
        update : function () {
            this.readerTypes = findAll();
        },
        add : function () {
            $("#reader-type-add-modal").modal();
        },
        del : function (event) {
            del($(event.target).attr("name"));
        },
        modify : function (event) {
            for (var i = 0; i < this.readerTypes.length; i++) {
                if (this.readerTypes[i].id == $(event.target).attr("name")) {
                    modify(this.readerTypes[i]);
                    break;
                }
            }
        }
    }
})
new Vue({
    el : "#reader-type-add-modal",
    data : {
        readerType : {
            id: "",
            name: "",
            canBorrow: ""
        }
    },
    methods : {
        submit : function (event) {
            add(this.readerType)
        }
    }
})