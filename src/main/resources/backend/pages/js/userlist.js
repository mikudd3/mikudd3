new Vue({

    el: '#app',
    data: {
        currentPage: 1,
        pageSize: 5,
        totalCount: 0,
        pagination: {},
        dataList: [
            {
                username: "张三",
                isAdmin: 0,
                phone: "13131313131",
                email: "12345@qq.com",
                status: 0,
            }

        ],//当前页要展示的列表数据
        formData: {},//表单数据
        dialogFormVisible: false,//控制表单是否可见
        dialogFormVisible4Edit: false,//编辑表单是否可见
        rules: {//校验规则
            username: [{required: true, message: '用户名为必填项', trigger: 'blur'}],
        },
        user: {
            id: "",
            username: "",
            pwd: "",
            isAdmin: 0,
            phone: "",
            email: "",
            url: "",
            status: 0,
        }
    },

    //钩子函数，VUE对象初始化完成后自动执行
    created() {
        this.getAll();
    },

    methods: {
        //列表
        getAll() {
            axios({
                method: "post",
                url: "http://localhost:8080/admin/selectByPageAndCondition?currentPage=" + this.currentPage + "&pageSize=" + this.pageSize,
                data: this.user,
            }).then((res) => {
                this.dataList = res.data.rows;
                //设置总记录数
                this.totalCount = res.data.totalCount;
            })

        },

        //弹出添加窗口
        handleCreate() {
            this.dialogFormVisible = true;
            this.resetForm();
        },

        //重置表单
        resetForm() {
            this.formData = {};
        },

        //添加
        handleAdd() {
            //发送请求
            axios({
                method: "POST",
                url: "http://localhost:8080/admin/add",
                data: this.formData
            }).then((res) => {
                if (res.data == "userHadExist") {
                    this.$message.error("添加失败，用户名已存在");
                } else if (res.data == "success") {
                    this.$message.success("添加成功");
                    //关闭弹窗
                    this.dialogFormVisible = false;
                }
            }).finally(() => {
                this.getAll();
            })
        },

        //弹出编辑窗口
        handleUpdate(row) {
            //根据id查询数据
            axios({
                method: "get",
                url: "http://localhost:8080/admin/selectById?id=" + row.id,
                data: this.formData,
            }).then((res) => {
                this.formData = res.data;
                this.dialogFormVisible4Edit = true;
            })

        },

        //编辑
        handleEdit() {
            //发送请求
            axios({
                method: "post",
                url: "http://localhost:8080/admin/update",
                data: this.formData
            }).then((res) => {
                //弹窗
                this.$message.success("修改成功")
                //操作成功，关闭窗口
                this.dialogFormVisible4Edit = false;
            }).finally(() => {
                this.getAll();
            })
        },

        // 删除
        handleDelete(row) {
            //弹出提示框
            this.$confirm("此操作将永久删除该数据，是否继续？", "提示", {
                type: "info"
            }).then(() => {
                //做删除业务
                //根据id查询数据
                axios({
                    method: "post",
                    url: "http://localhost:8080/admin/delete?id=" + row.id,
                }).then((res) => {
                    this.$message.success("删除成功")
                }).finally(() => {
                    this.getAll();
                });

            }).catch(() => {
                this.$message.info("取消删除")
            })

        },
        handleCurrentChange(val) {
            this.currentPage = val;
            this.getAll();
        },
        handleSizeChange(val) {
            this.pageSize = val;
            this.getAll();
        }
    }
})