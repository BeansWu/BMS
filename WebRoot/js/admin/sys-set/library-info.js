/** 获取图书馆信息 **/
function getLibraryInfo () {
    $.get("../../../admin/sys-set/library/get-library-info", function (data) {
    	libraryInfoForm.init(data);
	});
}
getLibraryInfo();
/** 修改图书馆信息 **/
function updateLibraryInfo (newLibraryInfo) {
	$.ajax({
		type: "POST",
		url: "../../../admin/sys-set/library/update-library-info",
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(newLibraryInfo),
		success: function(data) {
			switch(data["result"]) {
			case"success": alert("修改成功");break;
			case"failure": alert("修改失败");break;
			default: alert("未知错误");
			}
			getLibraryInfo();
		}
	})
	
}
var libraryInfoForm = new Vue({
	el: "#library_info_form",
	data: {
		libraryInfo: ""
	},
	methods: {
		init: function(data) {
			this.libraryInfo = data;
		},
		save: function (event) {
			updateLibraryInfo (this.libraryInfo);
		}
	}
})