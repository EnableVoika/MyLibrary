<template>
    <div class="navbar">
        <!-- 
                default-active:默认选中的菜单，这里表示根据路由地址选择
                当前路由是什么地址，就选中什么菜单

                :router="true"注意！true表示开启路由模式,开启之后, index值代表的就是路由地址
                默认如果不开启没有路由功能！！！这里触发的路由组件显示在AppMain/index.vue组件中的<router-view>中
         -->
        <el-menu :router="true" :default-active="$route.path" class="el-menu-vertical-demo"
        background-color="#545c64" text-color="#fff" active-text-color="coral">
        
            <el-menu-item index="/home">
                <i class="el-icon-home"></i>
                <span>热门电影</span>
            </el-menu-item>

            <el-menu-item index="/manager">
                <i class="el-icon-home"></i>
                <span>电影信息管理</span>
            </el-menu-item>

        </el-menu>
    </div>
</template>

<script>
export default {
}
</script>

<style scoped>
</style>