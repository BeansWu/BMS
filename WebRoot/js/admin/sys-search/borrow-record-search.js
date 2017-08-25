/* 找到所有借阅记录 */
function findAll() {
	$.get("../../../admin/sys-search/borrow-record-search/find-all", function(data) {
		borrowRecordSearch.init(data);
	})
}
/* 根据条件查找 */
function find(basis, borrowDateLowerBound, borrowDateUpperBound, basisType) {
	$.post("../../../admin/sys-search/borrow-record-search/find", {
		basis : basis,
		borrowDateLowerBoundStr : borrowDateLowerBound,
		borrowDateUpperBoundStr : borrowDateUpperBound,
		basisType : basisType
	}, function(data) {
		borrowRecordSearch.init(data);
	})
}
var borrowRecordSearch = new Vue({
	el : "#borrow-record-search",
	data : {
		basis : "",
		borrowDateLowerBound : "",
		borrowDateUpperBound : "",
		borrowRecords : ""
	},
	methods : {
		init : function(data) {
			this.borrowRecords = data;
			for (var i = 0; i < this.borrowRecords.length; i++) {
				this.borrowRecords[i].borrowDate = moment(this.borrowRecords[i].borrowDate).format("YYYY-MM-DD HH:mm:ss");
				this.borrowRecords[i].returnDate = moment(this.borrowRecords[i].returnDate).format("YYYY-MM-DD HH:mm:ss");
			}
		},
		findByBasis : function(event) {
			var borrowDateLowerBound = this.borrowDateLowerBound == "" ? "":moment(this.borrowDateLowerBound).format("YYYY-MM-DD HH:mm:ss");
			var borrowDateUpperBound = this.borrowDateUpperBound == "" ? "":moment(this.borrowDateUpperBound).format("YYYY-MM-DD HH:mm:ss");
			find(this.basis, borrowDateLowerBound, borrowDateUpperBound, $(event.target).attr("id"));
		},
		resetBorrowDateRange: function() {
			this.borrowDateLowerBound = "";
			this.borrowDateUpperBound = "";
		}
	}
})
//刷新页面时执行
findAll();