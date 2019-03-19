var vm = new Vue({
    el: '#app',
    data: {
        userList: [],
        allotList: [],
        fDisabled: false,
        lDisabled: false,
        totalCount: 200,
        //分页数
        pageCount: 20,
        //当前页面
        pageCurrent: 1,
        //分页大小
        pageSize: 10,
        //显示分页按钮数
        showPages: 11,
        //开始显示的分页按钮
        showPagesStart: 1,
        //结束显示的分页按钮
        showPageEnd: 20
    },
    created: function () {
        this.init();
    },
    methods: {
        showUser: function () {
            axios.get(getHost() + "api/user/getAllUser")
                .then(function (response) {
                    if (response.data.result === true) {
                        var data = response.data;
                        vm.userList = data.data;
                    }
                    else {
                        alert(data.errorMessage ? data.errorMessage : "请求异常");
                    }
                });
        },

        saveInvest:function () {
            axios.post(getHost() + "api/allot/saveAllot", vm.userList
            )
                .then(function (response) {
                    if (response.data.result === true) {
                        var data = response.data;
                        vm.userList = data.data;
                    }
                    else {
                        alert(data.errorMessage ? data.errorMessage : "请求异常");
                    }
                });
        },

        showPage: function (pageIndex, $event, forceRefresh) {
            if (pageIndex > 0) {
                if (pageIndex > this.pageCount) {
                    pageIndex = this.pageCount;
                }
                //判断数据是否需要更新
                var currentPageCount = Math.ceil(this.totalCount / this.pageSize);
                if (currentPageCount !== this.pageCount) {
                    pageIndex = 1;
                    this.pageCount = currentPageCount;
                }
                else if (this.pageCurrent === pageIndex && currentPageCount === this.pageCount && typeof (forceRefresh) === "undefined") {
                    return;
                }

                //分页数据
                axios.post(getHost() + "api/allot/getAllotPageInfo", {
                    pageIndex: pageIndex,
                    pageSize: this.pageSize
                })
                    .then(function (response) {
                        if (response.data.result === true) {
                            debugger;
                            var data = response.data;
                            this.allotList = data.data.rows;
                        }
                        else {
                            alert(data.errorMessage ? data.errorMessage : "请求异常");
                        }
                    });
                //处理分页按钮的样式
                var buttons = $("#pager").find("span");
                for (var i = 0; i < buttons.length; i++) {
                    if (buttons.eq(i).html() === pageIndex.toString()) {
                        buttons.eq(i).addClass("active");
                    } else {
                        buttons.eq(i).removeClass("active");
                    }
                }

                //如果当前页首页或者尾页，则上一页首页就不能点击，下一页尾页就不能点击
                if (this.pageCount === 1) {
                    this.lDisabled = true;
                    this.fDisabled = true;
                } else if (pageIndex === 1) {
                    this.fDisabled = true;
                    this.lDisabled = false;
                } else if (pageIndex === this.pageCount) {
                    this.lDisabled = true;
                    this.fDisabled = false;
                } else {
                    this.fDisabled = false;
                    this.lDisabled = false;
                }

                //计算分页按钮数据
                if (this.pageCount > this.showPages) {
                    if (pageIndex <= (this.showPages - 1) / 2) {
                        this.showPagesStart = 1;
                        this.showPageEnd = this.showPages - 1;
                    }
                    else if (pageIndex >= this.pageCount - (this.showPages - 3) / 2) {
                        this.showPagesStart = this.pageCount - this.showPages + 2;
                        this.showPageEnd = this.pageCount;
                    }
                    else {
                        this.showPagesStart = pageIndex - (this.showPages - 3) / 2;
                        this.showPageEnd = pageIndex + (this.showPages - 3) / 2;
                    }
                }
            }
        },
        init: function () {
            this.showUser();
            this.showPage(1, null, true);
        }
    }
});