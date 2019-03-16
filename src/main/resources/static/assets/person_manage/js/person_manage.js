var vm = new Vue({
    el:'#app',
    data:{
        userList:[]
    },
    created: function () {
        this.showUser();
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
        }
    }
});