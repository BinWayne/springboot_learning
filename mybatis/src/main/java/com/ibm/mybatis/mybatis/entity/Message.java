package com.ibm.mybatis.mybatis.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;


public class Message {

    private  long id;

    @NotEmpty(message = "Message is required.")
    private  String text;

    @NotEmpty(message = "Summary is required.")
    private String summary;

    private Calendar created = Calendar.getInstance();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }
}
