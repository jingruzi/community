package com.practice.community.dto;
/*
功能：实现将数据库中，Question table的creator可以拿到User table的id信息，从而获取avatar_url
补充说明：model包是存放数据库表单中对应的信息，为了实现数据库中不同表之间信息的传输借助dto包实现传输功能
*/
import com.practice.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
