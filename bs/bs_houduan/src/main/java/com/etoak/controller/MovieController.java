package com.etoak.controller;

import com.etoak.entity.Movie;
import com.etoak.entity.ReView;
import com.etoak.service.MovieService;
import com.etoak.utils.JsonResponse;
import com.etoak.utils.ResultStatus;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;

    /**
     * 根据条件查询电影
     * @param searchMap
     * @return
     */
    @PostMapping
    public JsonResponse getMovies(@RequestBody Movie searchMap) {
        List<Movie> data = movieService.getMoviesVo(searchMap);
        if (data == null ) {
            return ResultStatus.error("未查询到结果");
        }
        return ResultStatus.suc("查询成功",data);
    }

    @GetMapping("updateStatus")
    public JsonResponse updateStatus(@RequestParam Integer id,@RequestParam Integer status ) {
        int result = movieService.updateStatus(id,status);
        if (result <= 0) {
            return ResultStatus.error("更新失败");
        }
        return ResultStatus.suc("更新成功");
    }


    /**
     * 更新电影
     * @param updateList
     * @return
     */
    @PostMapping("update")
    public JsonResponse update(@RequestBody Movie updateList) {
        int result = movieService.update(updateList);
        if(result <= 0) {
            return ResultStatus.error("更新失败");
        }
        return ResultStatus.suc("更新成功");
    }

    @GetMapping("selectById")
    public JsonResponse selectById(int id) {
        Movie movie = movieService.selectById(id);
        return ResultStatus.suc("查询成功",movie);
    }


    @GetMapping("selectByStatus")
    public JsonResponse selectByStatus(int page,int itemsPerPage) {

        PageInfo info = movieService.selectByStatus(page,itemsPerPage);

        Map<String,Object> data = new HashMap<>();
        data.put("total",info.getTotal());
        data.put("data",info.getList());

        return ResultStatus.suc("查询成功",data);
    }

    @PostMapping("add")
    public JsonResponse addMovie(@RequestBody Movie movie) throws ParseException {
        String releaseDateStr = movie.getReleaseDateStr();
        movie.setDate("上架");
        movie.setStatus(1);
        int result = movieService.addMovie(movie);
        if (result <= 0 ) {
            return ResultStatus.error("添加失败");
        }
        return ResultStatus.suc("添加成功");
    }


    @GetMapping("selectFilmReview")
    public JsonResponse selectAllReview(@RequestParam(required = false,defaultValue = "-1") int mid) {
        List<ReView> data = movieService.selectAllReview(mid);
        if(data == null ) {
            return ResultStatus.error("未查询到评论");
        }
        return ResultStatus.suc("评论查询成功",data);
    }

    @PostMapping("addFilmReview")
    public JsonResponse addFilmReview(@RequestBody ReView reView) {
        log.info("revies========================={}",reView);
        log.info("revies========================={}",reView.getName());
        reView.setFtimeStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        int result = movieService.addFilmReview(reView);
        if(result <= 0) {
            return ResultStatus.error("添加失败");
        }
        return ResultStatus.suc("添加评论成功");
    }


    /**
     * 管理员查询全部电影
     * @param searchMap
     * @return
     */
    @PostMapping("manager")
    public JsonResponse getMoviesManager(@RequestBody Movie searchMap) {
        PageInfo<Movie> info = movieService.getMoviesVoManager(searchMap);
        Map<String,Object> data = new HashMap<>();
        data.put("data",info.getList());
        data.put("total",info.getTotal());
        if (info.getList() == null ) {
            return ResultStatus.error("未查询到结果");
        }
        return ResultStatus.suc("管理员查询成功",data);
    }









}
