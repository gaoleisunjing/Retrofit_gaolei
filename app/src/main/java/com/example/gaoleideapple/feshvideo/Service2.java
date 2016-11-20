package com.example.gaoleideapple.feshvideo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by gaoleideapple on 16/10/22.
 */

public interface Service2 {

    @GET("/api/{category}/list")                        //@Query 查询 下载数据需要用这个
    Call<Tngou> getList(@Path("category") String category, @Query("id") int id, @Query("page") int page, @Query("rows")int rows);
}
