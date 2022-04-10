package com.etoak.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.etoak.entity.Movie;
import com.etoak.entity.ReView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieMapper extends BaseMapper<Movie> {

    /**
     * 根据条件查询电影
     * @param movie
     * @return
     */
    List<Movie> getMoviesVo(Movie movie);

    /**
     * 更新电影状态
     * @param id
     * @param status 1上架 2下架
     * @return
     */
    int updateStatus(@Param("id")Integer id, @Param("status")Integer status);

    /**
     * 根据id查询电影
     * @param id
     * @return
     */
    Movie selectById(int id);

    /**
     * 根据状态查电影
     * @return
     */
    public List<Movie> selectByStatus();


    public List<ReView> selectAllReview(int mid);

    /**
     * 管理员查询全部电影
     * @param movie
     * @return
     */
    public List<Movie> getMoviesVoManager(Movie movie);


}
