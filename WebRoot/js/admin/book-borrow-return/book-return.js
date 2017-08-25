/* 通过条形码找到读者*/
function findReader(readerBarCode) {
	$.post("../../../admin/book-borrow-return/find-reader", {readerBarCode: readerBarCode}, function(data) {
		if (data == null || data == "") {
			alert("查无此人");
		} else {
			readerVerification.init(data);
		}
	})
}
/* 通过读者条形码找到其已借阅图书 */
function findBooksHasBorrow(readerBarCode) {
	$.post("../../../admin/book-borrow-return/find-books-has-borrow", {readerBarCode: readerBarCode}, function(data) {
		bookReturn.init(data);
	})
}
/* 归还 */
function remand(bookId) {
	$.post("../../../admin/book-borrow-return/remand", {bookId: bookId}, function(data) {
    	switch(data["result"]) {
    	case"success": alert("归还成功");break;
    	case"failure": alert("归还失败");break;
    	default: alert("未知错误");
    	}
    	//更新数据
    	readerVerification.submit();
	}, "json");
}
var readerVerification = new Vue({
	el: "#reader-verification",
	data: {
		reader: {
			id: "",
			name: "",
			barCode: "",
			readerType: "",
			hasBorrow: "",
			certType: "",
			certNumber: "",
			phone: "",
			email: "",
			books: ""
		}
	},
	methods: {
		init: function (data) {
			this.reader = data;
		},
		submit: function () {
			findReader(this.reader.barCode);
			bookReturn.findBooksHasBorrow(this.reader.barCode);
		}
	}
})
var bookReturn = new Vue({
	el: "#book-return",
	data: {
		books:""
	},
	methods: {
		findBooksHasBorrow: function (readerBarCode) {
			findBooksHasBorrow(readerBarCode);
		},
		init: function (data) {
			this.books = data;
			for (var i = 0; i < this.books.length; i++) {
				this.books[i].borrowDate = moment(this.books[i].borrowDate).format("YYYY-MM-DD HH:mm:ss");
				this.books[i].returnDate = moment(this.books[i].returnDate).format("YYYY-MM-DD HH:mm:ss");
			}
		},
		remand: function (event) {
			remand($(event.target).attr("id"));
		}
	}
})