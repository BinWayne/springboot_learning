package com.ibm.mybatis.mybatis.repository;

import com.ibm.mybatis.mybatis.entity.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository {
    Iterable<Message> findAll();
    Message save(Message message);
    Message findMessage(long id);
    void deleteMessage(long id);
}
