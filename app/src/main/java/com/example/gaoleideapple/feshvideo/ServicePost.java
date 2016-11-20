package com.example.gaoleideapple.feshvideo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by gaoleideapple on 16/10/22.
 */

public interface ServicePost {

    @POST("/api/{category}/list")
    @FormUrlEncoded //文本数据必须加 psot必须加               //@Field  属性  上传数据需要用
    Call<Tngou> getList(@Path("category") String category, @Field("id") int id, @Field("page") int page, @Field("rows") int rows);
}
