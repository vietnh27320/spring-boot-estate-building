package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.UserDTO;

import java.util.List;

public class OutPut {
    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<UserDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<UserDTO> listResult) {
        this.listResult = listResult;
    }

    private int totalPage;
    private List<UserDTO> listResult;
}
