package com.practice.community.mapper;

import com.practice.community.model.Comment;
import com.practice.community.model.CommentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommenteExtMapper {
    int incCommentCount(Comment comment);
}