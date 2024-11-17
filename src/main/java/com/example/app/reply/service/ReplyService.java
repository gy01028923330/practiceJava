package com.example.app.reply.service;


import com.example.app.reply.domain.Reply;
import com.example.app.reply.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;


    @Transactional
    public void create(String replyContent) {

    }
}
