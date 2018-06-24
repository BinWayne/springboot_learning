package com.ibm.mybatis.mybatis.repository;

import com.ibm.mybatis.mybatis.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryMessageRepository implements MessageRepository{

    // 用来模拟主键自增
    private static AtomicLong counter = new AtomicLong();

    private ConcurrentMap<Long,Message> message = new ConcurrentHashMap <>();

    @Override
    public Iterable <Message> findAll() {
        return this.message.values();
    }

    @Override
    public Message save(Message message) {
        Long id = message.getId();
        if(id==null){
            id = counter.incrementAndGet();
            message.setId(id);
        }
        this.message.putIfAbsent(id,message);
        return message;
    }

    @Override
    public Message findMessage(long id) {
        return this.message.get(id);
    }

    @Override
    public void deleteMessage(long id) {
        this.message.remove(id);
    }
}
