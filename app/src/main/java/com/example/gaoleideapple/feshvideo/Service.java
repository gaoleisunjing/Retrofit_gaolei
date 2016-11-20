package com.example.gaoleideapple.feshvideo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gaoleideapple on 16/9/30.
 */

public interface Service {

    @GET("/")//没有参数 所以用get  "/" 参数要求是网址地下的子目录  访问的是主页 所以没有
    Call<String> getBaidu();

}
