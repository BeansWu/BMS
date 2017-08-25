/* 查询所有书籍 */
function findAll() {
	$.get("../../../admin/sys-search/book-info-search/find-all", function(data) {
		bookInfoSearch.books = data;
	})
}
/* 根据查询依据查找图书 */
function findByBasis(basis, basisType) {
	$.post("../../../admin/sys-search/book-info-search/find-by-basis", {basis: basis, basisType: basisType}, function(data) {
		bookInfoSearch.books = data;
	})
}
var bookInfoSearch = new Vue({
	el: "#book-info-search",
	data: {
		basis: "",
		books: ""
	},
	methods: {
		findByBasis: function(event) {
			findByBasis(this.basis, $(event.target).attr("id"));
		}
	}
})
//打开页面后即执行
findAll();