<template>
    <div>
        <app-header></app-header>
        <app-navbar></app-navbar>
        <app-main></app-main>
    </div>
</template>

<script>

import AppHeader from './AppHeader'
import AppNavbar from './AppNavbar'
import AppMain from './AppMain'

export default {
    components:{
        AppHeader,
        AppNavbar,
        AppMain,
    }
}
</script>

<style scoped>
    .header {
        position: absolute;
        line-height: 50px;
        top: 0px;
        left: 0px;
        right: 0px;
        background-color: #2d3a4b;
    }
    /* 设置左侧导航栏 */
    .navbar {
        position: absolute;
        width: 230px;
        top: 50px;
        left: 0px;
        bottom: 0px;
        /* y轴高度不够自动显示滚动条 */
        overflow-y: auto;
        background-color: #545c64;
    }   
    /* 设置主体区域 */
    .main {
        position: absolute;
        top: 50px;
        left: 230px;
        right: 0px;
        bottom: 0px;
        padding: 10px;
        overflow-y: auto;
        background-color: whitesmoke;
    }
</style>