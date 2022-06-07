import request from '../utils/request';

export default {
    // 登录
    login(pojo) {
        return request({
            url:'login',
            method:'post',
            data:pojo
        })
    },

    // 记录查询
    searchAdjustInfo(condition) {
        return request({
            url:'/furry/adjust/search/condition',
            method:'post',
            headers:{
                'Authorization':localStorage.getItem('Authorization')
            },
            data:condition,
            
        })
    },

    // 退出登录
    loginout() {
        return request({
            url:'login/loginout',
            method:'get',
            headers:{
                'Authorization':localStorage.getItem('Authorization')
            }
        })
    },

    // 逻辑删除 TJ 记录
    deleteAdjustInfo(id) {
        return request({
            url:`/furry/delete/${id}`,
            method:'delete',
            headers:{
                'Authorization':localStorage.getItem('Authorization')
            }
        })
    },
}

export const fetchData = query => {
    return request({
        url: './table.json',
        method: 'get',
        params: query
    });
};
