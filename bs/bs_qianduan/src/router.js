import Vue from 'vue'
import Router from 'vue-router'


import Layout from './components/Layout.vue'


import Home from './views/home'
import Login from './views/login'
import Manager from './views/manager'
import Putong from './views/home copy'



Vue.use(Router)

export default new Router({
    routes:[
        
        {
            path:'/',
            component:Layout,
            name:'layout',
            redirect:'/login',
            children:[
                {
                    path:'/home',
                    component:Home,
                    meta:{title:'首页'}
                },
                
                {
                    path:'/manager',
                    component:Manager,
                    meta:{title:'管理'}
                }
            ]
        },

        {
            path:'/login',
            name:'login',
            component:Login,
            meta:{title:'登录'}
        },

        {
            path:'/putong',
            name:'putong',
            component:Putong,
            meta:{title:'普通'}
        },

    ]

})