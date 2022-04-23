<template>
<div id="container">
    <!-- 条件查询 -->
    <el-form ref="searchForm" :inline="true" :model="searchMap" class="demo-form-inline" style="margin-top: 20px">
            <el-form-item prop="name">
                <el-input v-model="searchMap.name" placeholder="片名"></el-input>
            </el-form-item>
            <el-form-item prop="protagonist">
                <el-input v-model="searchMap.protagonist" placeholder="主演"></el-input>
            </el-form-item>

            <el-form-item prop="type">
                <el-select v-model="searchMap.type" placeholder="类型" >
                    <el-option label="剧情" value="剧情"></el-option>
                    <el-option label="动作" value="动作"></el-option>
                    <el-option label="悬疑" value="悬疑"></el-option>
                    <el-option label="犯罪" value="犯罪"></el-option>
                    <el-option label="动画" value="动画"></el-option>
                    <el-option label="奇幻" value="奇幻"></el-option>
                    <el-option label="惊悚" value="惊悚"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item prop="startDate">
                <div class="block">
                    <el-date-picker v-model="searchMap.startDate" type="date" placeholder="上映时间"
                    value-format="yyyy-MM-dd">
                    </el-date-picker>
                </div>
            </el-form-item>
            <el-form-item prop="endDate">
                <div class="block">
                    <el-date-picker v-model="searchMap.endDate" type="date" placeholder="下映时间"
                    value-format="yyyy-MM-dd">
                    </el-date-picker>
                </div>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="fetchData1">查询</el-button>
                <el-button type="primary" @click="handleAdd">新增</el-button>
                <el-button @click="resetForm('searchForm')">重置</el-button>
            </el-form-item>
        </el-form>
    <!-- 新增 -->
    
    <el-dialog title="新增电影" :visible.sync="dialogFormVisible_add" width="500px">
        <el-form :model="ruleForm" ref="ruleForm" label-width="150px">          
            <el-form-item label="电影名" prop="name">
                <el-input v-model="ruleForm.name" style="width:220px"></el-input>
            </el-form-item>

            <el-form-item label="导演" prop="direct">
                <el-input v-model="ruleForm.direct" style="width:220px"></el-input>
            </el-form-item>

            <el-form-item label="电影图片" prop="path">
                <el-upload
                action="http://localhost:8080/ks/fileUpload"
                list-type="picture-card"
                :on-remove="handleRemove"
                :on-preview="handlePictureCardPreview"
                :on-success="handleAvatarSuccess"
                :on-exceed="handleExceed"
                :limit="1"
                :show-file-list="true"
                :file-list="imageList"
                :before-upload="beforeAvatarUpload"
                ref="up">
                    <i class="el-icon-plus"></i>
                    <el-dialog :visible.sync="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                    </el-dialog>
                </el-upload>
            </el-form-item>

            <el-form-item prop="type">   
                <span>类型</span><el-checkbox-group v-model="typeList">
                    <el-checkbox label="剧情"></el-checkbox>
                    <el-checkbox label="动作"></el-checkbox>
                    <el-checkbox label="悬疑"></el-checkbox>
                    <el-checkbox label="犯罪"></el-checkbox>
                    <el-checkbox label="动画"></el-checkbox>
                    <el-checkbox label="奇幻"></el-checkbox>
                    <el-checkbox label="惊悚"></el-checkbox>
                </el-checkbox-group>
            </el-form-item>

            <el-form-item label="主演" prop="protagonist">
                <el-input v-model="ruleForm.protagonist" style="width:220px"></el-input>
            </el-form-item>

            <el-form-item label="制片国家/地区" prop="region">
                <el-input v-model="ruleForm.region" autocomplete="off" style="width:220px" prop="phone"></el-input>
            </el-form-item>

            <el-form-item label="语言" prop="language">
                <el-input v-model="ruleForm.language" autocomplete="off" style="width:220px"></el-input>
            </el-form-item>

            <el-form-item label="上映时间" prop="releaseDate">
                <el-date-picker v-model="ruleForm.releaseDateStr" type="date" placeholder="选择日期" value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
            
            <el-form-item>
                <el-button @click="dialogFormVisible_add = false">取 消</el-button>
                <el-button type="primary" @click="addMovie('ruleForm')">确 定</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>  


    <!-- 显示数据 -->  
    <el-table :data="list" stripe style="width: 100%">
        <el-table-column prop="path" label="图片" width="200">
            <template width="90" slot-scope="scope">
                <el-image :src="scope.row.path" fit="fill" style="width:200;height:200;"></el-image>
            </template>
        </el-table-column>
        <el-table-column prop="name" label="电影名称" width="150"></el-table-column>
        <el-table-column prop="direct" label="导演" width="150"></el-table-column> 
        <el-table-column prop="protagonist" label="主演" width="150"></el-table-column>
        <el-table-column prop="type" label="类型" width="80"></el-table-column>
        <el-table-column prop="region" label="制片国家/地区" width="150"></el-table-column>   
        <el-table-column prop="language" label="语言" width="150"></el-table-column>
        <el-table-column prop="releaseDateStr" label="上映日期" width="150"></el-table-column>
        <el-table-column prop="date" label="操作" width="300">
            <template slot-scope="scope">
                <el-button @click="modifyState(scope.row.id,scope.row.status)" 
                type="{scope.row.status===0:'primary',scope.row.status===1:'danger'}">
                    {{ scope.row.status | ustateFilter }}
                </el-button>
                
                <el-button @click="handleEdit(scope.row.id)">编辑</el-button>
            </template>
        </el-table-column>
    </el-table>

    <el-pagination  
        @size-change="handleSizeChange" 
        @current-change="handleCurrentChange" 
        :current-page="searchMap.page"
        :page-sizes="[2,3,4,6,8]" 
        :page-size="searchMap.itemsPerPage" 
        layout="total, sizes, prev, pager, next, jumper" :total="total">
    </el-pagination>


    <!-- 修改 -->
    
    <el-dialog title="修改电影" :visible.sync="dialogFormVisible_update" width="500px" :close-on-click-modal="false" :showClose="false">
        <el-form :model="updateList" ref="updateForm" label-width="150px">          
            <el-form-item label="电影名" prop="name">
                <el-input v-model="updateList.name" style="width:220px"></el-input>
            </el-form-item>

            <el-form-item label="导演" prop="direct">
                <el-input v-model="updateList.direct" style="width:220px"></el-input>
            </el-form-item>

            <el-form-item label="电影图片" prop="path">
                <el-upload
                action="http://localhost:8080/ks/fileUpload"
                list-type="picture-card"
                :on-remove="handleRemove"
                :on-preview="handlePictureCardPreview"
                :on-success="handleAvatarSuccess"
                :on-exceed="handleExceed"
                :limit="1"
                :show-file-list="true"
                :before-upload="beforeAvatarUpload"
                :file-list="imageList"
                ref="up">
                    <i class="el-icon-plus"></i>
                    <el-dialog :visible.sync="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                    </el-dialog>
                </el-upload>
            </el-form-item>

            <el-form-item>   
                <span>类型</span><el-checkbox-group v-model="typeList">
                    <el-checkbox label="剧情"></el-checkbox>
                    <el-checkbox label="动作"></el-checkbox>
                    <el-checkbox label="悬疑"></el-checkbox>
                    <el-checkbox label="犯罪"></el-checkbox>
                    <el-checkbox label="动画"></el-checkbox>
                    <el-checkbox label="奇幻"></el-checkbox>
                    <el-checkbox label="惊悚"></el-checkbox>
                </el-checkbox-group>
            </el-form-item>

            <el-form-item label="主演" prop="protagonist">
                <el-input v-model="updateList.protagonist" style="width:220px"></el-input>
            </el-form-item>

            <el-form-item label="制片国家/地区" prop="region">
                <el-input v-model="updateList.region" autocomplete="off" style="width:220px" prop="phone"></el-input>
            </el-form-item>

            <el-form-item label="语言" prop="language">
                <el-input v-model="updateList.language" autocomplete="off" style="width:220px"></el-input>
            </el-form-item>

            <el-form-item label="上映时间" prop="releaseDate">
                <el-date-picker v-model="updateList.releaseDateStr" type="date" placeholder="选择日期"></el-date-picker>
            </el-form-item>
            
            <el-form-item>
                <el-button @click="cancelUpdate">取 消</el-button>
                <el-button type="primary" @click="updateMovie('updateForm')">确 定</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>  
        
    </div>
</template>

<script>
import dao from '@/api/dao'
const ugoodsstate=[
    {id:0,name:'上架'},
    {id:1,name:'下架'}
]
export default {
    data() {
        return {
            name:'',
            ruleForm:{
                
                direct:'',
                protagonist:'',
                type:'',
                region:'',
                language:'',
                releaseDateStr:'',
                path:'',
            },
            typeList:[],
            imageList:[],
            dialogImageUrl: '',
            dialogVisible: false,
            dialogFormVisible_add:false,
            dialogFormVisible_update:false,

            list:[],

            searchMap:{
                name:'',
                protagonist:'',
                type:'',
                startDate:'',
                endDate:'',
                page:1,
                itemsPerPage:2,
                total:'',
            },

            page:1,
            itemsPerPage:3,
            total:null,

            updateList:{
                name:'',
                direct:'',
                protagonist:'',
                type:'',
                region:'',
                language:'',
                releaseDate:'',
                path:'',
                typeList:[],
                releaseDateStr:''
            },

            imageList:[],
        }
    },

    methods:{
        fetchData1(){
            this.page = 1
            this.fetchData()  
        },
        /* 文件上传 */
        handleRemove(file, fileList) {
            this.ruleForm.path = ''
            this.updateList.path = ''
        },
        handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
        },
        handleAvatarSuccess(response, file, fileList){
            const basePath = 'http://localhost:8080/ks/'
            if(response.flag){
                this.ruleForm.path = ''+basePath+response.msg
                this.updateList.path = ''+basePath+response.msg
            }
        },
        handleExceed(file,fileList){
            this.$message.error('只能传递一张图片！');
        },
        beforeAvatarUpload(file){
            const isJPG = file.type === 'image/jpeg';
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
            }
                
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return isJPG && isLt2M;
        },

        /* 添加电影 */
        addMovie(formName) {
            
            this.$refs[formName].validate((valid) => {
                
                let allType = ''
                this.typeList.forEach(type => {allType +=  type + '/'})
                this.ruleForm.type = allType
                if (valid) {
                    dao.addMovie(this.ruleForm).then(resp => {         
                        if (resp.data.flag){
                            this.$message({
                                message: "添加成功",
                                type: "success"
                            });
                            this.dialogFormVisible_add = false
                            this.fetchData()
                            this.$refs.ruleForm.resetFields()
                            this.imageList = []
                            this.typeList = []
                        } else {
                            this.$message({
                                message:resp.data.msg,
                                type: "warning"
                            });
                        }
                    });
                } else {
                    alert('error')
                    this.$message({
                        message:"填写格式有误",
                        type: "warning"
                    });
                return false;
                }
            });
         },

         handleAdd(){
             this.imageList = []
            this.dialogFormVisible_add = true
        },

        /* 条件查询 */
        fetchData(){
            console.log(this.searchMap)
            dao.selectAllManager(this.searchMap,this.page,this.itemsPerPage)
            .then(response => {

                console.log(response)
                this.list = response.data.data.data
                this.total = response.data.data.total
            })
            
        },

        /* 点开开始编辑电影 */
        handleEdit(id){
            this.imageList = []
            this.dialogFormVisible_update = true
            this.$nextTick(() => {
                this.$refs['updateForm'].resetFields()   
                this.updateList.path = ''
                this.typeList = []
                this.updateList.type = ''
            })
            dao.selectMovieById(id).then(response => {
                const resp = response.data
                this.updateList = resp.data
                this.typeList = this.updateList.type.split('/')
                 
                const img = {
                    name:'update.jpg',
                    url:resp.data.path
                }  
                this.imageList.push(img)
            })
        },

        /* 关闭编辑电影 */
        cancelUpdate(){
            this.imageList = []
            this.dialogFormVisible_update = false
        },

        beforeClose(){
            this.imageList = []
        },


        /* 分页 */
        handleSizeChange(val){
            this.searchMap.itemsPerPage = val
            this.fetchData()  
        },
        handleCurrentChange(val){
            this.searchMap.page = val
            this.fetchData()
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
            this.fetchData()
        }, 

        /* 上下架 */
        modifyState(id,state){
            let flag
            if(state){
                flag=0
            }else{
                flag=1
            } 
            if(flag === 0){
                this.$confirm('是否下架?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
                }).then(() => {
                    dao.modifyStatus(id,flag).then(response => {
                        this.$message({
                            type: 'success',
                            message: '下架成功!'
                        });
                        this.fetchData()
                    })
                }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消下架'
                });          
                });
            }else{
                this.$confirm('是否上架?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
                }).then(() => {
                    dao.modifyStatus(id,flag).then(response => {
                        this.$message({
                            type: 'success',
                            message: '上架成功!'
                        });
                        this.fetchData()
                    })
                }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消上架'
                });          
                });
            }       
        },

        /* 编辑电影 */
        updateMovie(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    let allType = ''
                    /* 去除split后数组中最后一个"" */
                    this.typeList = this.typeList.filter(a => {return a})
                    this.typeList.forEach(type => {allType +=  type + '/'})   
                    this.updateList.type = allType
                    this.updateList.releaseDate = this.updateList.releaseDateStr
                    dao.updateMovie(this.updateList).then(response => {
                        const resp = response.data
                        if(resp.flag){
                            this.dialogFormVisible_update = false
                            this.fetchData()  
                            this.imageList = [] 
                            this.$message({
                                message:resp.msg
                            })
                        }else{
                            alert('修改失败！')
                        }
                    })
                } else {
                    return false;
                }
            });
         },
    },

    created(){
        this.fetchData()
    },

    filters:{
        ustateFilter(value){
            const pro= ugoodsstate.find(val =>val.id===value)
            return pro? pro.name : null
        }

    },
}
</script>

<style scoped>
    #container{
        margin-top: 20px;
    }
</style>