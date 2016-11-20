package com.example.gaoleideapple.feshvideo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gaoleideapple on 16/10/22.
 */

public class Tngou {

    @SerializedName("status")//注解
    private boolean status;
    @SerializedName("total")
    private int total;
    @SerializedName("tngou")
    private List<Cook> list;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Cook> getList() {
        return list;
    }

    public void setList(List<Cook> list) {
        this.list = list;
    }
}
