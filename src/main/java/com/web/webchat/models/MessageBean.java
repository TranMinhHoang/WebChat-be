package com.web.webchat.models;

import java.util.List;

public class MessageBean {

    private String from;
    private String message;
    private String to;
    private String time;
    private List<MessageImage> images;

    public List<MessageImage> getImages() {
        return images;
    }

    public void setImages(List<MessageImage> images) {
        this.images = images;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
