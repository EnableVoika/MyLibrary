import request from '../utils/request';

export default {
    // 登录
    login(pojo) {
        return request({
            url:'/login',
            method:'post',
            data:pojo
        })
    },
    // 调教记录查询
    searchAdjustInfo(condition) {
        return request({
            url:'/'
        })
    }
}

export const fetchData = query => {
    return request({
        url: './table.json',
        method: 'get',
        params: query
    });
};
