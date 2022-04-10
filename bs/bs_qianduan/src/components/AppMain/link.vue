<template>
    <el-breadcrumb  separator="/">
        <el-breadcrumb-item class="line" :to="{ path: '/' }">  
             首页 
        </el-breadcrumb-item>
        <el-breadcrumb-item class="line">  
             {{$route.meta.title}} 
        </el-breadcrumb-item>
    </el-breadcrumb>
</template>

<script>
export default {
}
</script>

<style scoped>
    .el-breadcrumb {
      height: 10px;
      padding: 20px;
      border-radius: 15px;
      /* 这里是elementui中的阴影显示方式 */
      box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.4);
   }
   .line {
      border-left: 5px solid coral;
      padding-left: 15px;
      font-weight: bolder;
   }
</style>