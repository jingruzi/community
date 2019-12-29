package com.practice.community.service;

import com.practice.community.enums.CommentTypeEnum;
import com.practice.community.exception.CustomizeErrorCode;
import com.practice.community.exception.CustomizeException;
import com.practice.community.mapper.CommentMapper;
import com.practice.community.mapper.QuestionExtMapper;
import com.practice.community.mapper.QuestionMapper;
import com.practice.community.model.Comment;
import com.practice.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Transactional//将insert功能封装成事物，让添加评论数和评论内容两个方法，具有同时成功同时失败的事物原子性
    public void insert(Comment comment) {
        if(comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if(comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if(comment.getType() == CommentTypeEnum.COMMENT.getType()){
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if(dbComment == null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        }else{
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if(question == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);//添加评论内容等信息
            question.setCommentCount(1);
            questionExtMapper.incComment(question);//增加评论数
        }
    }
}
