package com.example.websocketdemo.Repository;

import com.example.websocketdemo.Entity.ChatMessageentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatMessageentity, Long> {

}
