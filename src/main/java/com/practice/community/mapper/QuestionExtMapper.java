package com.practice.community.mapper;

import com.practice.community.model.Question;
import com.practice.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/*为了防止mybaties generator 更新的时候覆盖掉之前生成的mapper文件
* */
public interface QuestionExtMapper {
        int incView(Question record);
        int incComment(Question record);
        List<Question> selectRelated(Question question);
}