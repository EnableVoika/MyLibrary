<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">后台管理系统</div>
            <el-form
                :model="userobj"
                :rules="rules"
                ref="login"
                label-width="0px"
                class="ms-content"
            >
                <el-form-item prop="username">
                    <el-input v-model="userobj.username" placeholder="username">
                        <template #prepend>
                            <el-button icon="el-icon-user"></el-button>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="password"
                        v-model="userobj.password"
                        @keyup.enter="login()"
                    >
                        <template #prepend>
                            <el-button icon="el-icon-lock"></el-button>
                        </template>
                    </el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="login()">登录</el-button>
                </div>
                <p class="login-tips">Tips : 用户名和密码随便填。</p>
            </el-form>
        </div>
    </div>
</template>

<script>
import { ref, reactive } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import { ElMessage } from "element-plus";
import dao from "../api/dao";

export default {
    created() {
        
    },
    data() {
        return {
            router: useRouter(),
            store:useStore(),
            userobj: {
                username: "",
                password: "",
            },
            rules: {
                username: [
                    {
                        required: true,
                        message: "请输入用户名",
                        trigger: "blur",
                    },
                ],
                password: [{ required: true, message: "请输入密码", trigger: "blur" }],
            },
        };
    },
    methods: {
        login() {
            dao.login(this.userobj).then((resp) => {
                //console.log("dasddadaadsd");
                console.log(resp);
                if (resp.status == true) {
                    ElMessage.success(resp.msg);
                    localStorage.setItem("ms_username", this.userobj.username);
                    this.router.push("/");
                } else {
                    ElMessage.error(resp.msg);
                    return false;
                }
            });
        },
    },
    setup() {
        const router = useRouter();
        // const param = reactive({
        //     username: "",
        //     password: "",
        // });

        // const rules = {
        //     username: [
        //         {
        //             required: true,
        //             message: "请输入用户名",
        //             trigger: "blur",
        //         },
        //     ],
        //     password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        // };

        // const login = ref(null);
        // const submitForm = () => {
        //     login.value.validate((valid) => {
        //         if (valid) {
        //             ElMessage.success("登录成功");
        //             localStorage.setItem("ms_username", param.username);
        //             router.push("/");
        //         } else {
        //             ElMessage.error("登录成功");
        //             return false;
        //         }
        //     });
        //};

        const store = useStore();
        store.commit("clearTags");

        // return {
        //     //param
        //     //userobj,
        //     rules,
        //     login,
        //    // submitForm,
        // };
    },
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../assets/img/login-bg.jpg);
    background-size: 100%;
}
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #fff;
    border-bottom: 1px solid #ddd;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}
.ms-content {
    padding: 30px 30px;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #fff;
}
</style>
