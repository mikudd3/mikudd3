第二个web项目--mikudd3游戏商城

本项目的前端主要使用html+vue+Ajax实现，后端采用mybatis和基于mvc三层架构的javaweb实现，数据库主要使用MySQL进行实现

主要实现功能有：

1.网站的登录功能
该登录功能后台会对所登录用户的身份进行判断，如果你的身份是普通用户，则登录后会跳转至商城首页，如果你是超级管理员则会跳转至用户管理界面
![image](https://github.com/mikudd3/mikudd3/assets/96935176/149c972f-8986-4110-b68f-ed2a61a5d342)


2.网站的注册功能
注册功能实现了验证码的输出以及接收校验，该共功能会判断注册的用户是否已经存在，如果用户存在，则会提示该用户已经存在，这时将不允许该用户注册并作出该用户已存在的提示
![image](https://github.com/mikudd3/mikudd3/assets/96935176/e2f62e4c-8cce-4e2a-be08-fc01772774a1)

3.找回密码功能
该功能主要对用户进行密码找回，也有验证码功能
![image](https://github.com/mikudd3/mikudd3/assets/96935176/4dc83cd4-8b52-40e9-ad3d-8de7bd60a0bf)


4.短信登录功能
由于个人无法申请阿里云的短信功能，故该功能只进行了假实现，即控制台输出验证码，页面输入验证码
![image](https://github.com/mikudd3/mikudd3/assets/96935176/4480cff8-4451-46eb-871d-f6b890d0a03b)

5.用户管理页面
采用vue与element ui以及Ajax实现，主要实现的功能有分页查询，新增用户，删除用户，模糊查找，修改用户等
![image](https://github.com/mikudd3/mikudd3/assets/96935176/fa5b203e-a8b3-4051-9fd5-ed072e4b6f3f)








