package com.javaboy.vhr.mapper;

import com.javaboy.vhr.pojo.MailSendLog;

public interface MailSendLogMapper {
    int insert(MailSendLog record);

    int insertSelective(MailSendLog record);
}