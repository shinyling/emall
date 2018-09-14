package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.Attachment;
import java.util.List;

public interface AttachmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Attachment record);

    Attachment selectByPrimaryKey(String id);

    List<Attachment> selectAll();

    int updateByPrimaryKey(Attachment record);
}