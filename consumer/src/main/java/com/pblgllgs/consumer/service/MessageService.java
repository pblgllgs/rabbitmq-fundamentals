package com.pblgllgs.consumer.service;
/*
 *
 * @author pblgl
 * Created on 18-11-2023
 *
 */

import com.pblgllgs.consumer.entities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public void saveMessage(Message message){
        messageRepository.save(message);
    }
}
