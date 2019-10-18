package com.codeguy.myallcomponent.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserLists {

    @SerializedName("page")
    public Integer page;

    @SerializedName("per_page")
    public Integer perPage;

    @SerializedName("total")
    public Integer total;

    @SerializedName("total_pages")
    public Integer totalPages;

    @SerializedName("data")
    public List<Datum> data = null;



    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserLists{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }
}
