<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 基础表格
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-select
                    v-model="query.address"
                    placeholder="地址"
                    class="handle-select mr10"
                >
                    <el-option key="1" label="广东省" value="广东省"></el-option>
                    <el-option key="2" label="湖南省" value="湖南省"></el-option>
                </el-select>
                <el-input
                    v-model="query.name"
                    placeholder="用户名"
                    class="handle-input mr10"
                ></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch"
                    >搜索</el-button
                >
            </div>
            <el-table
                :data="adjustData"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
            >
                <el-table-column
                    prop="id"
                    label="ID"
                    width="55"
                    align="center"
                ></el-table-column>
                <el-table-column label="头像(查看大图)" align="center">
                    <template #default="scope">
                        <el-image
                            class="table-td-thumb"
                            :src="scope.row.thumb"
                            :preview-src-list="[scope.row.thumb]"
                        >
                        </el-image>
                    </template>
                </el-table-column>
                <el-table-column prop="adjustedDog" label="奴隶名字"></el-table-column>
                <el-table-column
                    prop="adjustContentValue"
                    label="调教内容"
                ></el-table-column>
                <el-table-column
                    prop="adjustInfo"
                    label="调教内容详细描述"
                ></el-table-column>
                <el-table-column prop="adjustDatetime" label="调教时间"></el-table-column>
                <el-table-column label="调教次数">
                    <template #default="scope">{{ scope.row.adjustCount }}</template>
                </el-table-column>
                <!-- <el-table-column prop="address" label="地点"></el-table-column> -->
                <el-table-column label="本次调教是否有效">
                    <template #default="scope">
                        <div
                            :class="
                                scope.row.effectivenessValue === '有效'
                                    ? 'green'
                                    : scope.row.effectivenessValue === '待审批'
                                    ? 'orange'
                                    : scope.row.effectivenessValue === '无效'
                                    ? 'red'
                                    : 'orange'
                            "
                        >
                            {{ scope.row.effectivenessValue }}
                        </div>
                    </template></el-table-column
                >
                <!-- <el-table-column label="状态" align="center">
                    <template #default="scope">
                        <el-tag
                            :type="
                                scope.row.state === '成功'
                                    ? 'success'
                                    : scope.row.state === '失败'
                                    ? 'danger'
                                    : ''
                            "
                            >{{ scope.row.state }}</el-tag
                        >
                    </template>
                </el-table-column> -->
                <el-table-column label="操作" width="180" align="center">
                    <template #default="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.$index, scope.row)"
                            >编辑
                        </el-button>
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.$index, scope.row)"
                            >删除</el-button
                        >
                        <!-- @click="handleDelete(scope.$index, scope.row)" -->
                        <!-- @click="handleDelete(scope.row)" -->
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    layout="total, prev, pager, next"
                    :current-page="query.pageIndex"
                    :page-size="query.pageSize"
                    :total="pageTotal"
                    @current-change="handlePageChange"
                ></el-pagination>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" v-model="editVisible" width="30%">
            <el-form label-width="70px">
                <el-form-item label="用户名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="地址">
                    <el-input v-model="form.address"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="editVisible = false">取 消</el-button>
                    <el-button type="primary" @click="saveEdit">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
import { ref, reactive } from "vue";
import { ElMessage, ElMessageBox } from "element-plus";
import dao from "../../api/dao";
import { useRouter } from "vue-router";

export default {
    data() {
        return {};
    },
    methods: {},
    created() {
        this.getAdjustData();
    },
    name: "basetable",
    setup() {
        const username = localStorage.getItem("ms_username");
        const query = reactive({
            address: "",
            name: "",
            pageIndex: 1,
            pageSize: 10,
        });
        const tableData = ref([]);
        const pageTotal = ref(0);
        const adjustData = ref([]);
        const condition = {
            pageNum: 1,
            pageSize: 5,
        };

        const getAdjustData = () => {
            dao.searchAdjustInfo(condition).then((resp) => {
                // console.log(resp)
                if (resp.ref === false) {
                    ElMessage.error(resp.msg);
                }
                adjustData.value = resp.data;
            });
        };

        // 获取表格数据
        const getData = () => {
            fetchData(query).then((res) => {
                tableData.value = res.list;
                pageTotal.value = res.pageTotal || 50;
            });
        };
        // getData();

        // 查询操作
        const handleSearch = () => {
            query.pageIndex = 1;
            getData();
        };
        // 分页导航
        const handlePageChange = (val) => {
            query.pageIndex = val;
            getData();
        };
        // 表格编辑时弹窗和保存
        const editVisible = ref(false);
        let form = reactive({
            name: "",
            address: "",
        });
        let idx = -1;
        const handleEdit = (index, row) => {
            idx = index;
            Object.keys(form).forEach((item) => {
                form[item] = row[item];
            });
            editVisible.value = true;
        };
        // 删除
        const handleDelete = (index, row) => {
            // 二次确认删除
            ElMessageBox.confirm("确定要删除吗？", "提示", {
                type: "warning",
            })
                .then(() => {
                    dao.deleteAdjustInfo(row.id).then((resp) => {
                        if (resp.ref) {
                            getAdjustData();
                            ElMessage.success(resp.msg);
                        } else {
                            getAdjustData();
                            ElMessage.error(resp.msg);
                        }
                    });
                    //tableData.value.splice(index, 1);
                })
                .catch(() => {
                    getAdjustData();
                    if (username === "sin") {
                        ElMessage.warning("龙奴感谢sin主人的仁慈");
                    } else if (username === "luni") {
                        ElMessage.warning("龙奴感谢陛下的仁慈");
                    }
                });
        };
        const saveEdit = () => {
            editVisible.value = false;
            ElMessage.success(`修改第 ${idx + 1} 行成功`);
            Object.keys(form).forEach((item) => {
                tableData.value[idx][item] = form[item];
            });
        };

        return {
            query,
            tableData,
            pageTotal,
            editVisible,
            form,
            adjustData,
            condition,
            username,
            handleSearch,
            handlePageChange,
            handleDelete,
            handleEdit,
            saveEdit,
            getAdjustData,
        };
    },
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}
.table {
    width: 100%;
    font-size: 14px;
}
.red {
    color: #ff0000;
}
.orange {
    color: orange;
}
.green {
    color: green;
}
.mr10 {
    margin-right: 10px;
}
.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
