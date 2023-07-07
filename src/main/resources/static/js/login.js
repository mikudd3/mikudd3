new Vue({
    el: "#app",
    data: {
        employee: {
            username: "",
            password: "",
        },

    },
    methods: {
        dosubmit() {
            axios.post("http://localhost:8080/login", "username=" + this.user.username + "&password=" + this.user.password)
                .then(resp => {
                    // alert("这是then")
                    console.log(resp.data)
                    if (resp.data == 1) {
                        location.href = '../pages/admin/main.html';
                    } else if (resp.data == 2) {
                        location.href = '../index.html';
                    } else if (resp.data == 0) {
                        this.$message.error("登录失败");
                    }
                }).catch(function () {
                // alert("这是catch")
            }).finally(function () {
                // alert("这是finally")
            })
        },

    },
})