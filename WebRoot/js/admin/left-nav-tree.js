/**
 * Created by Administrator on 2017/6/2.
 */
function logout() {
	$.get("../../admin/logout/logout-verify", function(data) {
		switch(data["result"]) {
		case"success": window.location.href = "../../views/admin/login.html";break
		case"failure": alert("登出失败");break;
		default: alert("未知错误");
		}
	}, "json")
}
function queryRoles() {
	$.get("../../admin/login/query-roles", function(data) {
		sysSet.initAllow(data["sysSet"]);
		readerMgt.initAllow(data["readerMgt"]);
		bookMgt.initAllow(data["bookMgt"]);
		bookBorrowAndReturn.initAllow(data["bookBorrowAndReturn"]);
		SysSearch.initAllow(data["sysSearch"]);
	})
}
function quertAdminLevel() {
	$.get("../../admin/login/query-admin-level", function(data) {
		sysSet.initAdminLevel(data);
	})
}
queryRoles();
quertAdminLevel();
/** 构建组件 **/
Vue.component("tree-branch", {
    props : {
        branch : Array
    },
    data : function() {
        return {
            show: false
        }
    },
    template : "#tree_branch",
    methods : {
        toggle : function() {
            if (this.show)
                this.show = false;
            else
                this.show = true;
        }
    }
});
/** 注册 **/
var sysSet = new Vue({
    el : "#left-nav-tree-part1",
    data : {
        attr : {
            icon : "glyphicon glyphicon-cog",
            root : "系统设置",
            leaves : [
                {name : "图书馆信息", link : "sys-set/library-info.html"},
                {name : "管理员设置", link : "sys-set/admin-set.html"},
                {name : "书架设置", link : "sys-set/bookrack-set.html"}
            ],
            allow: ""
        }
    },
    methods: {
    	initAllow: function(data) {
    		if (!data) {
    			this.attr.allow = "btn btn-link disabled";
    		} else {
    			this.attr.allow = "btn btn-link";
    		}
    	},
    	initAdminLevel: function(data) {
    		if (data != "SUPER") {
    			this.attr.leaves = [
                    {name : "图书馆信息", link : "sys-set/library-info.html"},
                    {name : "书架设置", link : "sys-set/bookrack-set.html"}
    			]
    		}
    	}
    }
})

var readerMgt = new Vue({
    el : "#left-nav-tree-part2",
    data : {
        attr : {
            icon : "glyphicon glyphicon-user",
            root : "读者管理",
            leaves : [
                {name : "读者类型管理", link : "reader-mgt/reader-type-mgt.html"},
                {name : "读者信息管理", link : "reader-mgt/reader-info-mgt.html"}
            ],
            allow: ""
        }
    },
    methods: {
    	initAllow: function(data) {
    		if (!data) {
    			this.attr.allow = "btn btn-link disabled";
    		} else {
    			this.attr.allow = "btn btn-link";
    		}
    	}
    }
})

var bookMgt = new Vue({
    el : "#left-nav-tree-part3",
    data : {
        attr : {
            icon : "glyphicon glyphicon-book",
            root : "图书管理",
            leaves : [
                {name : "图书类型管理", link : "book-mgt/book-type-mgt.html"},
                {name : "图书信息管理", link : "book-mgt/book-info-mgt.html"}
            ],
            allow: ""
        }
    },
    methods: {
    	initAllow: function(data) {
    		if (!data) {
    			this.attr.allow = "btn btn-link disabled";
    		} else {
    			this.attr.allow = "btn btn-link";
    		}
    	}
    }
})

var bookBorrowAndReturn = new Vue({
    el : "#left-nav-tree-part4",
    data : {
        attr : {
            icon : "glyphicon glyphicon-tags",
            root : "图书借还",
            leaves : [
                {name : "图书借阅", link : "book-borrow-return/book-borrow.html"},
                {name : "图书归还", link : "book-borrow-return/book-return.html"}
            ],
            allow: ""
        }
    },
    methods: {
    	initAllow: function(data) {
    		if (!data) {
    			this.attr.allow = "btn btn-link disabled";
    		} else {
    			this.attr.allow = "btn btn-link";
    		}
    	}
    }
})
var SysSearch = new Vue({
    el : "#left-nav-tree-part5",
    data : {
        attr : {
            icon : "glyphicon glyphicon-search",
            root : "系统查询",
            leaves : [
                {name : "图书信息查询", link : "sys-search/book-info-search.html"},
                {name : "借阅信息查询", link : "sys-search/borrow-record-search.html"}
            ],
            allow: ""
        }
    },
    methods: {
    	initAllow: function(data) {
    		if (!data) {
    			this.attr.allow = "btn btn-link disabled";
    		} else {
    			this.attr.allow = "btn btn-link";
    		}
    	}
    }
})
new Vue({
	el: "#left-nav-tree-part6",
	data: {
		attr: {
			icon: "glyphicon glyphicon-off",
			root: "安全退出",
		}
	},
	methods: {
		logout: function() {
			logout();
		}
	}
})