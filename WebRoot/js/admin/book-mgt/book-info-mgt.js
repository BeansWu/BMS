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
/* 获取所有图书信息 */
function findAll() {
    $.get("../../../admin/book-mgt/book-info-mgt/find-all", function(data) {
    	bookInfoMgtForm.init(data);
    })
}
findAll();
/** 获取所有书架信息 **/
function findAllBookracks() {
	var bookracks = [];
	$.get("../../../admin/sys-set/bookrack-set/find-all", function(data) {
		for (var i = 0; i < data.length; i++) {
			bookracks.push({
				id : data[i].id,
				pressmark : data[i].pressmark
			})
		}
	})
	return bookracks;
}
/** 获取所有图书编号（出版社）信息 **/
function findAllBookNumbers() {
	var bookNumbers = [];
	$.get("../../../admin/book-mgt/book-info-mgt/find-all-bookNumber", function(data) {
		for (var i = 0; i < data.length; i++) {
			bookNumbers.push({
				id : data[i].id,
				interSBN : data[i].interSBN,
				press : data[i].press
			})
		}
	})
	return bookNumbers;
}
/** 获取所有图书类型信息 **/
function findAllBookTypes() {
	var bookTypes = []
    $.get("../../../admin/book-mgt/book-type-mgt/find-all", function(data) {
    	for (var i = 0; i < data.length; i++) {
    		bookTypes.push({
    			id : data[i].id,
    			name : data[i].name,
    			dayCanBorrow : data[i].dayCanBorrow
    		})
    	}
    })
    return bookTypes;
}
/* 添加或保存图书 */
function saveOrUpdate(newBook) {
    $.ajax({
        type: "POST",
        url: "../../../admin/book-mgt/book-info-mgt/saveOrUpdate",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newBook),
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
/* 删除图书 */
function del(id) {
    $.get("../../../admin/book-mgt/book-info-mgt/del", {id : id}, function(data) {
    	switch(data["result"]) {
    	case"success": alert("删除成功");break;
    	case"failure": alert("删除失败");break;
    	default: alert("未知错误");
    	}
    	findAll();
    }, "json");
}

var bookInfoMgtForm = new Vue({
    el : "#book-info-mgt-form",
    data : {
        books: ""
    },
    methods : {
    	init: function(data) {
    		this.books = data;
    	},
        update : function () {
            this.books = findAll();
        },
        add : function () {
        	bookAddModal.show("add");
        },
        del : function (event) {
            del($(event.target).attr("name"));
        },
        modify : function (event) {
            for (var i = 0; i < this.books.length; i++) {
                if (this.books[i].id == $(event.target).attr("name")) {
                    bookAddModal.update(this.books[i]);
                    break;
                }
            }
        }
    }
})

var bookAddModal = new Vue({
    el : "#book-add-modal",
    data : {
        book : {
			id: "",
			barCode: "",
			name: "",
			bookTypes: findAllBookTypes(),
			author: "",
			translator: "",
			bookNumbers: findAllBookNumbers(),
			price: "",
			page: "",
			bookracks: findAllBookracks(),
			reader: null
        }
    },
    methods : {
    	initBook : function () {
    		this.book.id = "";
    		this.book.barCode = autoInitBarCode();
    		this.book.name = "";
			this.book.bookTypes = findAllBookTypes();
			this.book.author = "";
			this.book.translator = "";
			this.book.bookNumbers = findAllBookNumbers();
			this.book.price = null;
			this.book.page = "";
			this.book.bookracks = findAllBookracks();
			this.book.reader = null;
    	},
    	show : function (ope) {
    		if (ope == "add") {
    			this.initBook();
    		} else {
        		this.book.id = ope.id;
        		this.book.barCode = ope.barCode;
        		this.book.name = ope.name;
        		$("#book-add-type").val(ope.bookType.id);
        		this.book.author = ope.author;
        		this.book.translator = ope.translator;
        		$("#book-add-press").val(ope.bookNumber.id);
        		this.book.price = ope.price;
        		this.book.page = ope.page;
        		$("#book-add-bookrack").val(ope.bookrack.id);
        		this.book.reader = ope.reader;
    		}
    		$("#book-add-modal").modal();
    	},
        submit : function (event) {
        	var bookType = {
        		id: "",
        		name: "",
        		dayCanBorrow: ""
        	};
        	var bookNumber = {
        		id: "",
        		interSBN: "",
        		press: ""
        	};
        	var bookrack = {
        		id: "",
        		pressmark : ""
        	};
        	for (var i = 0; i < this.book.bookTypes.length; i++) {
        		if ($("#book-add-type").val() ==  this.book.bookTypes[i].id) {
        			bookType.id = this.book.bookTypes[i].id;
        			bookType.name = this.book.bookTypes[i].name;
        			bookType.dayCanBorrow = this.book.bookTypes[i].canBorrow;
        		}
        	}
        	for (var i = 0; i < this.book.bookNumbers.length; i++) {
        		if ($("#book-add-press").val() ==  this.book.bookNumbers[i].id) {
        			bookNumber.id = this.book.bookNumbers[i].id;
        			bookNumber.interSBN = this.book.bookNumbers[i].interSBN;
        			bookNumber.press = this.book.bookNumbers[i].press;
        		}
        	}
        	for (var i = 0; i < this.book.bookracks.length; i++) {
        		if ($("#book-add-bookrack").val() ==  this.book.bookracks[i].id) {
        			bookrack.id = this.book.bookracks[i].id;
        			bookrack.pressmark = this.book.bookracks[i].pressmark;
        		}
        	}
        	var newBook = {
        		id: this.book.id,
        		bookrack: bookrack,
        		bookType: bookType,
        		bookNumber: bookNumber,
        		name: this.book.name,
        		author: this.book.author,
        		barCode: this.book.barCode,
        		page: this.book.page,
        		translator: this.book.translator,
        		reader: this.book.reader,
        		price: this.book.price
        	}
            saveOrUpdate(newBook);
        },
    	update : function (oldBook) {
    		this.show(oldBook);
    	}
    }
})