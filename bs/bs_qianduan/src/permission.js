

import router from './router'

router.beforeEach((to,from,next) => {
    const token = localStorage.getItem('etoak_cms_token')

    if(!token)
    {
        if(to.path !== '/login'){
            alert('请先登录')
            next({ path:'/login' })
        }else{
           next()
        }
    }
    else{
        /* 获取到token */
        if(to.path === './login'){
            next()
        }else{
            /* 获取用户信息 */
            const userInfo = localStorage.getItem('etoak_cms_user')
            if(userInfo){
                next()
            }else{
                       /* 强制用户登录 */
                       next({ path:'/login' })
                   }
               
            }
        }/* if(to.path === './manager'){
            console.log(token)
            console.log(token)
            console.log(token)
            if(token === 1){
                alert('权限不足！')
                next({ path:'/home' })
            }
        }
 */


    })
