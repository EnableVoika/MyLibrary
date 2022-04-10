package com.etoak.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.etoak.entity.Movie;
import com.etoak.entity.ReView;
import com.etoak.entity.User;
import com.etoak.mapper.MovieMapper;
import com.etoak.mapper.ReViewMapper;
import com.etoak.service.MovieService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieMapper movieMapper;
    @Autowired
    ReViewMapper reViewMapper;

    /**
     * 根据条件查询电影
     * @param movie
     * @return
     */
    @Override
    public List<Movie> getMoviesVo(Movie movie) {
        return movieMapper.getMoviesVo(movie);
    }

    /**
     * 更新电影状态
     * @param id
     * @param status 1上架 2下架
     * @return
     */
    @Override
    public int updateStatus(Integer id, Integer status) {
        return movieMapper.updateStatus(id,status);
    }

    /**
     * 根据id查询电影
     * @param id
     * @return
     */
    @Override
    public Movie selectById(int id) {
        return movieMapper.selectById(id);
    }

    /**
     * 更新电影
     * @param updateList
     * @return
     */
    @Override
    public int update(Movie updateList) {
        return movieMapper.updateById(updateList);
    }

    /**
     * 根据状态查电影
     * @param page
     * @param itemsPerPage
     * @return
     */
    @Override
    public PageInfo<Movie> selectByStatus(int page,int itemsPerPage) {
        PageHelper.startPage(page,itemsPerPage);
        List<Movie> data = movieMapper.selectByStatus();
        PageInfo<Movie> info = new PageInfo<>(data);
        return info;
    }

    /**
     * 添加电影
     * @param movie
     * @return
     */
    @Override
    public int addMovie(Movie movie) {
        return movieMapper.insert(movie);
    }

    @Override
    public List<ReView> selectAllReview(int mid) {
        return movieMapper.selectAllReview(mid);
    }

    @Override
    public int addFilmReview(ReView reView) {
        reView.setName(null);
        return reViewMapper.insert(reView);
    }

    /**
     * 管理员查询全部电影
     * @param movie
     * @return
     */
    @Override
    public PageInfo<Movie> getMoviesVoManager(Movie movie) {
        PageHelper.startPage(movie.getPage(),movie.getItemsPerPage());
        List<Movie> data = movieMapper.getMoviesVoManager(movie);
        PageInfo info = new PageInfo(data);
        return info;
    }


}
