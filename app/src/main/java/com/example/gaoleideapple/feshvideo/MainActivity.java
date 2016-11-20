package com.example.gaoleideapple.feshvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Tngou> {

    private TextView view;
    private ListView listView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        Service2 service2=retrofit.create(Service2.class);
//        Call<Tngou> call=service2.getList("cook",0,1,10);

        //post请求
        ServicePost servicePost=retrofit.create(ServicePost.class);
        Call<Tngou> call=servicePost.getList("cook",0,1,10);
        call.enqueue(this);

        listView = (ListView)findViewById(R.id.listId);
        adapter = new MyAdapter(this,new ArrayList<Cook>());
        listView.setAdapter(adapter);


        //第一次的加载百度页面的时候的retrofit
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com")
//                .addConverterFactory(new Converter.Factory() {
//                    //Converter 转换器
//                    @Override
//                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
//
//                        //String 要转换的类型
//                        return new Converter<ResponseBody, String>() {
//                            @Override
//                            public String convert(ResponseBody value) throws IOException {
//
//                                return value.string();//注意是string
//                            }
//                        };
//                    }
//                }).build();
//        Service service=retrofit.create(Service.class);
//        Call<String> call = service.getBaidu();
//        call.enqueue(this);//异步请求
//        view = (TextView) findViewById(R.id.textId);
//
//    }
//
//    @Override
//    public void onResponse(Call<String> call, Response<String> response) {
//            view.setText(response.body());
//    }
//
//    @Override
//    public void onFailure(Call<String> call, Throwable t) {
//        Toast.makeText(this,"请求失败:"+call.request().url(),Toast.LENGTH_SHORT).show();
//        t.printStackTrace();// 打印栈
//



    }

    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {
        List<Cook> list = response.body().getList();
        adapter.addAll(list);
    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {
        t.printStackTrace();
    }
}
