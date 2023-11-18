package com.pblgllgs.consumer.service;

import com.pblgllgs.consumer.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
