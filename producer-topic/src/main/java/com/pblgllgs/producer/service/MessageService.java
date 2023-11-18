package com.pblgllgs.producer.service;
/*
 *
 * @author pblgl
 * Created on 18-11-2023
 *
 */

import com.pblgllgs.producer.entities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }
}
