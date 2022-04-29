<template>
    <div class="login-container">

        <el-form ref="etoak" :rules="rules" :model="form" label-width="90px" class="login-form">
            <h2 class="login-title">调教网站，请登录</h2>

            <el-form-item label="用户姓名" prop="username">
                <el-input v-model="form.username"></el-input>
            </el-form-item>
            <el-form-item label="用户密码" prop="password">
                <el-input v-model="form.password" type="password"></el-input>
            </el-form-item>
            <el-form-item label="用户身份" prop="password">
                <el-radio v-model="form.role" label="0">管理员</el-radio>
                <el-radio v-model="form.role" label="1">普通用户</el-radio>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('etoak')">登录</el-button>
                <el-button @click="resetForm('etoak')">重置</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
    import dao from '@/api/dao'

    export default {
        data() {
            return {
                form: {
                    username: '',
                    password: '',
                    role:null,
                },

                rules: {
                    username: [
                        { required: true, message: "帐号不能为空", trigger: "blur" },
                        { min: 2, max: 32, message: '长度必须在2到32位之间', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: "密码不能为空", trigger: "blur" },
                        { min: 2, max: 32, message: '长度必须在2到32位之间', trigger: 'blur' }
                    ]
                },

                info:{
                    username:'',
                    role:null,
                    realname:'',
                    key:'',
                }
            }
        },
        methods: {
            submitForm(formName){
                this.$refs[formName].validate(valid=>{
                    /* 表单验证成功则valid为true */
                    if(valid){
                        // 测试代码，记得删掉，否则登陆失效
                       // this.$router.push('/master')
                        dao.login(this.form.username,this.form.password).then(response=>{
                            console.log(response)
                            const resp = response.data
                            /* 用户登录成功 */
                            if(resp.flag){
                                /* 获得用户资料 */
                                this.info = resp.data
                                console.log(this.info)
                                /* 将数据缓存进浏览器 */
                                localStorage.setItem('etoak_cms_user', JSON.stringify(this.info.username))
                                localStorage.setItem('etoak_cms_token', this.info.role) 
                                localStorage.setItem('etoak_cms_userId', this.info.id) 
                                /* 调用路由前往首页 */
                                if(this.info.role === 1){
                                    this.$router.push('/master')
                                }
                                if(this.info.role === 0){
                                    this.$router.push('/putong')
                                }
                            }else{
                                /* 登录失败 */
                                this.$message({
                                    message:resp.msg,
                                    type:'warning',
                                })
                            }   
                        })
                    }else{
                        /* 
                            表单验证没通过 
                        */
                        this.$message({
                            message:'登录失败！请查看验证条件',
                            type:'warning',
                        })
                    }
                })
            },
            /* 重置表单 */
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
    }
</script>

<style scoped>
.login-form {
  width: 350px;
  /* 上下间隙 160px, 左右自动居中 */
  margin: 160px auto;
  background-color: rgb(255, 255, 255, 0.6);
  padding: 28px;
  border-radius: 60px;
}
.login-container {
  position: absolute;
  width: 100%;
  height: 100%;
  background: url("../../assets/login.jpg");
}
.login-title {
  color: #303133;
  text-align: center;
}
</style>