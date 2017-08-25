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
/* 通过依据找到图书 */
function findBook(bookBasicType, bookBasic) {
	$.post("../../../admin/book-borrow-return/find-book", {bookBasicType: bookBasicType, bookBasic: bookBasic}, function(data) {
		if (data == null || data == "") {
			alert("查无此书");
		} else {
			bookVerification.init(data);
		}
	})
}
/* 完成借阅 */
function borrow(reader, book) {
	var jsonArray = {};
	jsonArray["reader"] = JSON.stringify(reader);
	jsonArray["book"] = JSON.stringify(book);
	$.ajax({
		url: "../../../admin/book-borrow-return/borrow",
		method: "post",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(jsonArray),
        success: function(data) {
        	switch(data["result"]) {
        	case"success": alert("借阅成功");break;
        	case"failure": alert("借阅失败");break;
        	default: alert("未知错误");
        	}
        	//更新数据
        	readerVerification.submit();
        }
	});
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
		}
	}
})
var bookVerification = new Vue({
	el: "#book-verification",
	data: {
		basis: "",
		book: {
			id: "",
			bookrack: "",
			bookType: "",
			bookNumber: "",
			name: "",
			author: "",
			barCode: "",
			page: "",
			translator: "",
			price: "",
			borrowDate: "",
			returnDate: "",
			reader: ""
		}
	},
	methods: {
		init: function (data) {
			if (data == "empty") {
				this.basis = "";
				this.book.id = "";
				this.book.bookrack = "";
				this.book.bookType = "";
				this.book.bookNumber = "";
				this.book.name = "";
				this.book.author = "";
				this.book.barCode = "";
				this.book.page = "";
				this.book.translator = "";
				this.book.price = "";
				this.book.borrowDate = "";
				this.book.returnDate = "";
				this.book.reader = "";
			} else {
				this.book = data;
				//获得当前日期作为借阅时间
				this.book.borrowDate = moment().format("YYYY-MM-DD HH:mm:ss");
				//获取应还日期：借阅时间加上可借时间
				var returnDate = new Date(this.book.borrowDate);
				returnDate.setDate(returnDate.getDate() + this.book.bookType.dayCanBorrow);
				this.book.returnDate = moment(returnDate).format("YYYY-MM-DD HH:mm:ss");
			}
		},
		submit: function (event) {
			findBook($(event.target).attr("id"), this.basis);
		}
	}
})
var bookBorrow = new Vue({
	el: "#book-borrow",
	methods: {
		submit: function () {
			if (bookVerification.book.reader == null) {
				borrow(readerVerification.reader, bookVerification.book);
				bookVerification.init("empty");
			} else {
				alert("图书已借阅");
			}
		}
	}
})