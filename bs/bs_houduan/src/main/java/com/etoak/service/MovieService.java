package com.etoak.service;

import com.etoak.entity.Movie;
import com.etoak.entity.ReView;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MovieService {

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
    int updateStatus(Integer id,Integer status);

    /**
     * 根据id查询电影
     * @param id
     * @return
     */
    Movie selectById(int id);

    int update(Movie updateList);

    /**
     * 根据状态查电影
     * @param page
     * @param itemsPerPage
     * @return
     */
    public PageInfo<Movie> selectByStatus(int page, int itemsPerPage);

    /**
     * 添加电影
     * @param movie
     * @return
     */
    public int addMovie(Movie movie);

    /**
     * 查询全部评论
     * @return
     */
    public List<ReView> selectAllReview(int mid);

    public int addFilmReview(ReView reView);

    /**
     * 管理员查询全部电影
     * @param movie
     * @return
     */
    public PageInfo<Movie> getMoviesVoManager(Movie movie);

}
