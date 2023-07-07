new Vue({
    el: "#app",
    data() {
        return {
            checkCode: "",
            employee: {
                username: "",
                pwd: "",
                phone: "",
                email: "",
            },
            imgCode: "/checkCode?" + new Date().getMilliseconds()
        }
    },
    methods: {
        validateForm() {
            if (!this.user.username) {
                alert("账号不能为空");
                return false;
            } else if (!this.user.pwd) {
                alert("密码不能为空");
                return false;
            } else if (!this.user.phone) {
                alert("电话不能为空");
                return false;
            } else if (!this.checkCode) {
                alert("验证码不能为空");
                return false;
            } else if (!this.user.email) {
                alert("邮箱不能为空")
                return false;
            } else {
                return true;
            }
        },
        dosubmit() {
            if (this.validateForm()) {
                axios({
                    method: "post",
                    url: "http://localhost:8080/register?checkCode=" + this.checkCode,
                    data: this.user,
                }).then(resp => {
                    //如果注册成功
                    if (resp.data == "success") {
                        location.href = "../login.html";
                    } else if (resp.data == "usernameHad") {
                        this.$message.error("注册失败,该用户已存在")
                    } else if (resp.data == "codeFail") {
                        this.$message.error("验证码错误")
                    }

                }).catch(function () {
                    alert("这是catch")
                })

            }
        },

        changeImg() {
            this.imgCode = "/checkCode?" + new Date().getMilliseconds();
        }

    }
})