new Vue({
    el: "#app",
    data: {
        user: {
            username: "",
            password: "",
        },
        username: "",
        password1: "",
        password2: "",
        checkCode: "",
    },
    mounted() {
        this.changeImg();
    },
    methods: {
        validateForm() {
            if (!this.password1) {
                alert("密码不能为空");
                return false;
            } else if (this.password1 !== this.password2) {
                alert("两次输入的密码不一致");
                return false;
            } else if (!this.password2) {
                alert("密码不能为空");
                return false;
            } else if (!this.checkCode) {
                alert("验证码不能为空");
                return false;
            } else {
                this.user.username = this.username;
                this.user.password = this.password1;
                return true;
            }

        },
        forgetPwd() {
            if (this.validateForm()) {
                // 这里可以提交表单数据
                console.log("密码验证通过，提交表单");
                axios({
                    method: "post",
                    url: "http://localhost:8080/forgetPassword?checkCode=" + this.checkCode + "&username=" + this.user.username + "&password=" + this.user.password,
                }).then(Response => {
                    if (Response.data == "checkError") {
                        this.$message.error("验证码输入错误")
                    } else if (Response.data == "userNotFound") {
                        this.$message.error("用户未注册")
                    } else if (Response.data == "success") {
                        this.$message.success("修改成功")
                    }
                }).catch(function () {
                    alert("catch")
                }).finally(function () {
                    alert("finally")
                })
            }
        },
        changeImg() {
            document.getElementById("checkImg").src = "/checkCode?" + new Date().getMilliseconds();
        }
    }


})