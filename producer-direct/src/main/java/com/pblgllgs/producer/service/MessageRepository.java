package com.pblgllgs.producer.service;

import com.pblgllgs.producer.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message,Long> {
}
