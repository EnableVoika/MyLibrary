<template>
    <div id="container">
        <i class="el-icon-aim"></i><span>调教记录 </span>
        <hr />
        <el-table :data="list" style="width: 100%">
            <!-- 执行日期 -->
            <el-table-column label="日期" width="180">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span style="margin-left: 10px">{{ scope.row.adjustDatetime }}</span>
                </template>
            </el-table-column>
            <!-- 名字和详情 -->
            <el-table-column label="狗子" width="180">
                <template slot-scope="scope">
                    <el-popover trigger="hover" placement="top">
                        <p>姓名: {{ scope.row.adjustedDog }}</p>
                        <p>任务: {{ scope.row.adjustContent }}</p>
                        <p>详情: {{ scope.row.adjustInfo }}</p>
                        <div slot="reference" class="name-wrapper">
                            <el-tag size="medium">{{ scope.row.adjustedDog }}</el-tag>
                        </div>
                    </el-popover>
                </template>
            </el-table-column>
            <!-- 执行次数 -->
            <el-table-column label="完成次数" width="180">
                <template slot-scope="scope">
                    <i class="el-icon-info"></i>
                    <span style="margin-left: 10px">{{ scope.row.adjustCount }} 次</span>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button
                    >
                    <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.$index, scope.row)"
                        >删除</el-button
                    >
                </template>
            </el-table-column>
        </el-table>

        <!-- 弹框修改 -->
        <el-dialog title="狗子调教不容易，主子谨慎编辑" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="调教日期" :label-width="formLabelWidth">
                    <el-input v-model="form.adjustDatetime" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="狗子" :label-width="formLabelWidth">
                    <el-input v-model="form.adjustedDog" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="任务内容" :label-width="formLabelWidth">
                    <el-select v-model="form.region" placeholder="请选调教内容">
                        <el-option label="边缘调教" value="1"></el-option>
                        <el-option label="捶蛋" value="2"></el-option>
                        <el-option label="野裸" value="3"></el-option>
                        <el-option label="狗姿撒尿" value="4"></el-option>
                        <el-option label="榨精" value="5"></el-option>
                        <el-option label="憋尿" value="6"></el-option>
                        <el-option label="尿道开发" value="7"></el-option>
                        <el-option label="龟头责" value="8"></el-option>
                        <el-option label="屁眼开发" value="9"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="调教详情" :label-width="formLabelWidth">
                    <el-input v-model="form.adjustInfo" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="完成次数" :label-width="formLabelWidth">
                    <el-input v-model="form.adjustCount" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogCancle">取 消</el-button>
                <el-button type="primary" @click="dialogSure">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import dao from "@/api/dao";
export default {
    data() {
        return {
            formLabelWidth: "120px",
            list: [],
            page: 1,
            itemsPerPage: 3,
            total: null,
            dialogFormVisible: false,
            form: {
                adjustContent: "",
                adjustContentCode: "",
                adjustCount: "",
                adjustDatetime: "",
                adjustInfo: "",
                adjustedDog: "",
            },
        };
    },

    methods: {
        /** 编辑按钮 */
        handleEdit(index, row) {
            this.dialogFormVisible = true;
            this.form = row;
            //console.log(this.form)
            //console.log(index, row);
        },
        /** 删除按钮 */
        handleDelete(index, row) {
            this.$confirm(
                "此操作将永久删除狗子的调教记录，狗子辛苦的调教全白费了！狗子会骚死的！！主子要三思！！, 真的要折磨狗子看着狗子发骚取悦主子么?",
                "提示",
                {
                    confirmButtonText: "那当然，虐狗逗狗多有意思～",
                    cancelButtonText: "狗子也可怜，饶了它这一次吧",
                    type: "warning",
                }
            )
                .then(() => {
                    let resp = null
                    let msg = ''
                    dao.delAdjustInfo(row.id).then((res) => {
                        resp = res.data
                    });
                    this.fetchData();
                    this.$message({
                        type: "success",
                        message: "虐狗成功～～等着狗子回来发现主子给它的礼物～!",
                        time:10
                    });
                })
                .catch(() => {
                    this.fetchData();
                    this.$message({
                        type: "info",
                        message: "这次赦免狗子了",
                    });
                });
            // console.log(index, row);
            
        },
        /** 弹框中的取消按钮 */
        dialogCancle() {
            this.dialogFormVisible = false;
            this.fetchData();
        },
        /** 弹框中的确定按钮 */
        dialogSure() {
            this.dialogFormVisible = false;
            this.fetchData();
        },

        fetchData() {
            dao.selectPopular(this.page, this.itemsPerPage).then((response) => {
                console.log(response);
                this.list = response.data.data;
                this.total = response.data.total;
            });
        },

        /* 分页 */
        handleSizeChange(val) {
            this.itemsPerPage = val;
            this.fetchData();
        },
        handleCurrentChange(val) {
            this.page = val;
            this.fetchData();
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },

        /* 详情 */
        seeMore(id) {
            this.form.id = id;
            dao.selectMovieById(id).then((response) => {
                const resp = response.data;
                this.movie = resp.data;
            });
            this.fetchReview();
            this.dialogVisible = true;
        },

        /* 关闭对话框 */
        handleClose(done) {
            this.$confirm("确认关闭？")
                .then((_) => {
                    done();
                })
                .catch((_) => {});
        },

        review() {
            if (this.button === "不想写了！") {
                this.show = false;
                this.button = "我要写短评";
                return;
            }
            this.show = true;
            this.button = "不想写了！";
        },

        addReview(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    const name = localStorage.getItem("etoak_cms_user");
                    const userId = localStorage.getItem("etoak_cms_userId");
                    const content = this.form.text;
                    dao.addMovieReview(this.form.id, userId, name, content)
                        .then((response) => {
                            const resp = response.data;
                            this.$message({
                                message: resp.msg,
                                type: "success",
                            });
                            this.form.text = "";
                            this.fetchReview();
                        })
                        .catch(() => {
                            this.$message({
                                message: "内容不能为空",
                                type: "error",
                            });
                        });
                    this.button = "我要写短评";
                } else {
                    console.log("error submit!!");
                    return false;
                }
            });
        },

        fetchReview() {
            dao.selectAllReview(this.form.id).then((response) => {
                this.reviewList = response.data.data;
            });
        },
    },

    created() {
        this.fetchData();
    },
};
</script>

<style scoped>
div#container {
    margin-top: 20px;
    margin-left: 200px;
    margin-right: 200px;
}
h1 {
    text-align: center;
}
div#review {
    width: 600px;
}
</style>
