package com.web.webchat.controllers;

import com.web.webchat.models.MessageBean;
import com.web.webchat.models.UserOnline;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("*")
public class SocketController {

    private List<UserOnline> listUserOnline = new ArrayList<UserOnline>();
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketController.class);
    @MessageMapping("/user-all")
    @SendTo("/topic/user")
    public MessageBean sendToAll(@Payload MessageBean message) {
        
        LOGGER.warn("",message);
        return message;
    }

    @MessageMapping("/user-online")
    @SendTo("/topic/userOnline")
    public List<UserOnline> setOnline(@Payload UserOnline userOnline) {
        if(userOnline.getId() == null)
        {
            return this.listUserOnline;
        }
        for (int i = 0; i < listUserOnline.size(); i++) {
            if (listUserOnline.get(i).getId() == userOnline.getId()) {
                listUserOnline.remove(i);
            }
        }
        this.listUserOnline.add(userOnline);
        for (int i = 0; i < listUserOnline.size(); i++) {
            if (listUserOnline.get(i).isStatus() == false) {
                listUserOnline.remove(i);
            }
        }
        return this.listUserOnline;
    }
}
