import request from '@/utils/request'
import url from 'postcss-url'

export default {
    /** 登录 */
    login(username,password){
        return request({
            url:'/login',
            method:'post',
            data:{
                username,
                password
            }
        })
    },

    addMovie(ruleForm){
        return request({
            url:'movie/add',
            method:'post',
            data:ruleForm
        })
    },

    selectAll(searchMap,page,itemsPerPage){
        return request({
            //url: `movie/select?name=${searchMap.name}${searchMap.protagonist?'&protagonist='+searchMap.protagonist:''}${searchMap.type?'&type='+searchMap.type:''}${searchMap.startDate?'&startDate='+searchMap.startDate:''}${searchMap.endDate?'&endDate='+searchMap.endDate:''}&page=${page}&itemsPerPage=${itemsPerPage}`,
            url:'movie',
            method:'post',
            data:searchMap
        })
    },

    selectAllManager(searchMap,page,itemsPerPage){
        return request({
            //url: `movie/select?name=${searchMap.name}${searchMap.protagonist?'&protagonist='+searchMap.protagonist:''}${searchMap.type?'&type='+searchMap.type:''}${searchMap.startDate?'&startDate='+searchMap.startDate:''}${searchMap.endDate?'&endDate='+searchMap.endDate:''}&page=${page}&itemsPerPage=${itemsPerPage}`,
            url:'movie/manager',
            method:'post',
            data:searchMap
        })
    },

    modifyStatus(id,status){
        return request({
            url:`movie/updateStatus?id=${id}&status=${status}`,
            method:'get',
            // data:{
            //     id,
            //     status,
            // }
        })
    },

    /** 查询调教记录 */
    selectPopular(pageNum,pageSize){
        return request({
            url:`/query/condition`,
            method:'post',
        })
    },

    /** 删除调教记录 */
    delAdjustInfo(id) {
        return request({
            url:`/del/${id}`,
            method:'delete'
        })
    },


    selectMovieById(id){
        return request({
            url:`movie/selectById?id=${id}`,
            method:'get'
        })
    },

    addMovieReview(mid,userId,name,content){
        return request({
            url:'movie/addFilmReview',
            method:'post',
            data:{
                mid,
                name,
                content,
                userId,
            },
        })
    },

    selectAllReview(mid){
        return request({
            url:`movie/selectFilmReview?mid=${mid}`,
            method:'get'
        })
    },


    updateMovie(updateList){
        return request({
            url:'movie/update',
            method:'post',
            data:updateList
        })
    }



}