<template>
    <div class="main">
        <link1 v-show="$route.path != '/home'"></link1>
        <router-view></router-view>
    </div>
</template>

<script>
import link1 from './link'
export default {
    components:{
        link1
    }
}
</script>

<style scoped>
</style>