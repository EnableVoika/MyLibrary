<template>
    <div class="header">
        <a href="#">
            <img src="@/assets/etoak_logo.png" class="logo">
            <span class="company">易影网</span>
        </a>
    </div>
</template>

<script>
export default {
   
}
</script>

<style scoped>

    .logo{
        /* 垂直居中 */
        vertical-align: middle;
        padding: 0px 10px 0 40px;
        width:30px;
    }
    .company {
        position: absolute;
        color: white;
        font-weight:bolder;
    }

    .el-dropdown {
        float: right;
        margin-right: 50px;
    }
    .el-dropdown-link {
        color: white;
        cursor: pointer;
        font-weight: bolder;
    }
</style>