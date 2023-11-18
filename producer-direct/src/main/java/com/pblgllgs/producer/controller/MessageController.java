package com.pblgllgs.producer.controller;
/*
 *
 * @author pblgl
 * Created on 18-11-2023
 *
 */

import com.pblgllgs.producer.entities.Message;
import com.pblgllgs.producer.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/messages")
public class MessageController {

    private final MessageProducer messageProducer;

    @PostMapping
    public void sendMessage(@RequestBody Message message) {
        messageProducer.sendMessage(message);
    }
}
