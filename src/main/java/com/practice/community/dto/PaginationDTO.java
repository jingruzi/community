package com.practice.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//封装分页中的页码信息，通过问题总数，当前页，每一页的问题数，来实现分页的功能
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;//向前按钮
    private boolean showFirstPage;//第一页按钮
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        if(totalCount% size == 0){
            totalPage = totalCount / size;
        }else{
            totalPage = totalCount / size + 1;
        }

        if(page < 1) page = 1;
        if(page > totalPage) page = totalPage;

        this.page = page;
        pages.add(page);
        for(int i = 1; i< 3; i++){
            if(page - i > 0){
                pages.add(0, page - i);
            }
            if(page + i <= totalPage){
                pages.add(page + i);
            }
        }

        //是否展示上一页的标识
        if(page == 1){
            showPrevious = false;
        }else{
            showPrevious = true;
        }
        //是否展示下一页的标识
        if(page == totalPage){
            showNext = false;
        }else {
            showNext = true;
        }
        //是否展示首页标识
        if(pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }
        //是否展示尾页标识
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }

    }
}
