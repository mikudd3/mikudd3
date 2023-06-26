
let btn = document.getElementById("btn")
btn.addEventListener("click", function () {
    let pwdValue = pwd.value
    let nameValue = username.value
    if (nameValue == null || nameValue == "") {
        alert("账号不能为空")
    }
    if (pwdValue == null || pwdValue.length < 6) {
        alert('密码长度需要为6位数')
    }
})