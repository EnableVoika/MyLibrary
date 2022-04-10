<template>
    <div id="container">
        <i class="el-icon-aim"></i><span>热门电影</span>
        <hr>
        <el-row :gutter="20">
            
            <el-col :span="6" v-for="(movie,index) in list" :key="index">
                    <el-image :src="movie.path" fit="fill" style="width:250px;height:350px;cursor:pointer"
                    @click="seeMore(movie.id)"></el-image>    
                <pre>  
                    <span @click="seeMore(movie.id)" style="cursor:pointer">{{ movie.name }}</span> 
                </pre>
                
            </el-col>
            
        </el-row>

        <el-pagination  
        @size-change="handleSizeChange" 
        @current-change="handleCurrentChange" 
        :current-page="page"
        :page-sizes="[2,3,4,6,8]" 
        :page-size="itemsPerPage" 
        layout="total, sizes, prev, pager, next, jumper" :total="total">
        </el-pagination>

        <el-dialog title="提示" :visible.sync="dialogVisible" width="60%" :before-close="handleClose">
            <pre>             
                            <h1>{{ this.movie.name }}迅雷下载 百度云下载</h1>
                            导演：{{ this.movie.direct }}
                            主演：{{ this.movie.protagonist }}
                            类型：{{ this.movie.type }}
                            地区：{{ this.movie.region }}
                            语言：{{ this.movie.language }}
                            上映日期：{{ this.movie.releaseDateStr }}

                                        <hr>
                <el-image :src="this.movie.path" fit="fill" style="width:700px;height:350px;cursor:pointer"></el-image>
                                        <hr>
                <el-button type="primary" round @click="review">{{this.button}}</el-button> 

                <div id="review">
                    <el-form ref="form" :model="form" v-show="show"> 
                        <el-form-item>
                            <el-input type="textarea" placeholder="请输入内容" clearable
                            v-model="form.text" maxlength="350" show-word-limit>
                            </el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="addReview('form')">评论</el-button>
                        </el-form-item>
                    </el-form> 
                </div>    


                 <el-table :data="reviewList" stripe style="width: 100%" prop="review">
                    <el-table-column prop="name" label="姓名" width="150"></el-table-column>
                    <el-table-column prop="ftimeStr" label="评论时间" width="150"></el-table-column>
                    <el-table-column prop="content" label="内容" width="600"></el-table-column>
                </el-table>

            </pre>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
        </span>
        </el-dialog>

    </div>
</template>

<script>
import dao from '@/api/dao'
export default {
    data() {
        return {
            list:[],
            page:1,
            itemsPerPage:8,
            total:null,
            dialogVisible:false,
            movie:{
                id:'',
                name:'',
                direct:'',
                protagonist:'',
                type:'',
                region:'',
                language:'',
                releaseDate:'',
                path:'',
                releaseDateStr:'',
            },
            show:false,
            form:{
                text:'',
                id:'',
            },

            reviewList:[],
            button:'我要写短评',
        }
    },

    methods:{
        fetchData(){
            dao.selectPopular(this.page,this.itemsPerPage)
            .then(response => {
                this.list = response.data.data.data
                this.total = response.data.total
            })
        },

        /* 分页 */
        handleSizeChange(val){
            this.itemsPerPage = val
            this.fetchData()
        },
        handleCurrentChange(val){
            this.page = val
            this.fetchData()
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }, 

        /* 详情 */
        seeMore(id){
            this.form.id = id
            dao.selectMovieById(id).then(response => {
                const resp = response.data
                this.movie = resp.data   
            })         
            this.fetchReview()
            this.dialogVisible = true
        },

        /* 关闭对话框 */
        handleClose(done) {
            this.$confirm('确认关闭？')
            .then(_ => {
                done();
            })
            .catch(_ => {});
        },

        review(){
            if(this.button === '不想写了！'){
                this.show = false
                this.button = '我要写短评'
                return
            }
            this.show = true
            this.button = '不想写了！'
        },

        addReview(formName){
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    const name = localStorage.getItem('etoak_cms_user')
                    const userId = localStorage.getItem('etoak_cms_userId')
                    const content = this.form.text
                    dao.addMovieReview(this.form.id,userId,name,content).then(response => {
                        const resp = response.data
                        this.$message({
                            message:"添加成功",
                            type: "success"
                        });
                        this.form.text = ''
                        this.fetchReview()
                    })
                    this.button = '我要写短评'
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },

        fetchReview(){
            dao.selectAllReview(this.form.id).then(response => {
                this.reviewList = response.data.data
            })
        }
        
    },

    created(){
        this.fetchData()
    }
}
</script>
    
<style scoped>
div#container{
    margin-top: 20px;
    margin-left: 200px;
    margin-right: 200px;
}
h1{
    text-align: center;
}
div#review{
    width: 600px;
}
</style>