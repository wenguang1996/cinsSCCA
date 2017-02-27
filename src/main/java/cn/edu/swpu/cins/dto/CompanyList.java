package cn.edu.swpu.cins.dto;

import cn.edu.swpu.cins.entry.BaseInfo;

import java.util.List;

/**
 * Created by melo on 16-6-1.
 * 企业列表
 */
public class CompanyList {
    /*企业列表*/
    private List<BaseInfo> comList;
    /*总页数*/
    private int pages;
    /*总企业数*/
    private int number;

    public CompanyList(List<BaseInfo> comList, int pages, int number) {
        this.comList = comList;
        this.pages = pages;
        this.number = number;
    }

    @Override
    public String toString() {
        return "CompanyList{" +
                "comList=" + comList +
                ", pages=" + pages +
                ", number=" + number +
                '}';
    }

    public List<BaseInfo> getComList() {
        return comList;
    }

    public void setComList(List<BaseInfo> comList) {
        this.comList = comList;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
