import axios from 'axios';
import _Message from 'element-plus/lib/el-message';
import router from '../router'

//const router = useRouter()
const service = axios.create({
    // process.env.NODE_ENV === 'development' 来判断是否开发环境
    // easy-mock服务挂了，暂时不使用了
    baseURL: 'http://localhost:56789/voika/',
    timeout: 5000
});

service.interceptors.request.use(
    config => {
        // config.headers['Authorization'] = localStorage.getItem('Authorization')
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

service.interceptors.response.use(

    response => {
        //console.log(response)
        if (response.data.code === 200) {
            return response.data;
        } else {
            Promise.reject();
        }
        switch (response.data.code) {
            case 5000:
                // console.log('router='+router)
                //localStorage.removeItem("ms_username")
                //localStorage.removeItem("Authorization")
                //Message.error({message: '请求超时!'});
                _Message.error({message: response.data.msg})
                router.push('/dashboard')
                break;
            case 5001:
                //localStorage.removeItem("ms_username")
                // localStorage.removeItem("Authorization")
                //Message.error({message: '请求超时!'});
                _Message.error({message: response.data.msg})
                router.push('/dashboard')
                break;
        }
        return response.data

    },
    error => {
        // if(response.data.code === 50000) {
        //    // Vue.prototype.$message.error('哎呦我去，咋失败了');
        //    response.data.msg = '没有权限'
        //    console.log('2')
        //     router.push('/ss')
        // }
        //console.log(error);
        //return Promise.reject(error)
    }
);

export default service;
