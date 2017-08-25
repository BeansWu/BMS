/* 自动生成条形码 */
function autoInitBarCode () {
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var barCode = "".concat(year).concat(month).concat(day).concat(hour).concat(minute).concat(second);
	return barCode;
}
/* 获取所有读者信息 */
function findAll() {
    $.get("../../../admin/reader-mgt/reader-info-mgt/find-all", function(data) {
    	readerInfoMgtForm.init(data);
    })
}
findAll();
/* 获取所有读者类型信息 */
function findAllReaderType() {
	var readerTypes = []
    $.get("../../../admin/reader-mgt/reader-type-mgt/find-all", function(data) {
    	for (var i = 0; i < data.length; i++) {
    		readerTypes.push({
    			id : data[i].id,
    			name : data[i].name,
    			canBorrow : data[i].canBorrow
    		})
    	}
    })
    return readerTypes;
}
/* 添加或保存读者 */
function saveOrUpdate(newReader) {
    $.ajax({
        type: "POST",
        url: "../../../admin/reader-mgt/reader-info-mgt/saveOrUpdate",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newReader),
        success: function(data) {
        	switch(data["result"]) {
        	case"success": alert("提交成功");break;
        	case"failure": alert("提交失败");break;
        	default: alert("未知错误");
        	}
        	findAll();
        }
    })
}
/* 删除读者 */
function del(id) {
    $.get("../../../admin/reader-mgt/reader-info-mgt/del", {id : id}, function(data) {
    	switch(data["result"]) {
    	case"success": alert("删除成功");break;
    	case"failure": alert("删除失败");break;
    	default: alert("未知错误");
    	}
    	findAll();
    }, "json");
}

var readerInfoMgtForm = new Vue({
    el : "#reader-info-mgt-form",
    data : {
        readers: ""
    },
    methods : {
    	init: function(data) {
    		this.readers = data;
    	},
        add : function () {
        	readerAddModal.show("add");
        },
        del : function (event) {
            del($(event.target).attr("name"));
        },
        modify : function (event) {
            for (var i = 0; i < this.readers.length; i++) {
                if (this.readers[i].id == $(event.target).attr("name")) {
                    readerAddModal.update(this.readers[i]);
                    break;
                }
            }
        }
    }
})

var readerAddModal = new Vue({
    el : "#reader-add-modal",
    data : {
        reader : {
			id: "",
			barCode: "",
			name: "",
			readerTypes: findAllReaderType(),
			certType: "",
			certNumber: "",
			phone: "",
			email: "",
        }
    },
    methods : {
    	initReader : function () {
    		this.reader.id = "";
    		this.reader.name = "";
			this.reader.barCode = autoInitBarCode();
			this.reader.readerTypes = findAllReaderType();
			this.reader.certType = "";
			this.reader.certNumber = "";
			this.reader.phone = "";
			this.reader.email = "";
    	},
    	show : function (ope) {
    		if (ope == "add") {
    			this.initReader();
    		} else {
        		this.reader.id = ope.id;
        		$("#reader-add-type").val(ope.readerType.id);
        		this.reader.name = ope.name;
    			this.reader.barCode = ope.barCode;
    			this.reader.certType = ope.certType;
    			this.reader.certNumber = ope.certNumber;
    			this.reader.phone = ope.phone;
    			this.reader.email = ope.email;
    		}
    		$("#reader-add-modal").modal();
    	},
        submit : function (event) {
        	var readerType = {
        		id: "",
        		name: "",
        		canBorrow: ""
        	};
        	for (var i = 0; i < this.reader.readerTypes.length; i++) {
        		if ($("#reader-add-type").val() ==  this.reader.readerTypes[i].id) {
        			readerType.id = this.reader.readerTypes[i].id;
        			readerType.name = this.reader.readerTypes[i].name;
        			readerType.canBorrow = this.reader.readerTypes[i].canBorrow;
        		}
        	}
            saveOrUpdate({
        		id: this.reader.id,
        		barCode: this.reader.barCode,
        		name: this.reader.name,
        		readerType: readerType,
        		certType: this.reader.certType,
        		certNumber: this.reader.certNumber,
        		phone: this.reader.phone,
        		email: this.reader.email
        	});
        },
    	update : function (oldReader) {
    		this.show(oldReader);
    	}
    }
})