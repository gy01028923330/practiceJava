package com.example.app.reply.controller;

import com.example.app.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor //스프링에게 동작을 요청하기 위함
@RestController
public class ReplyController {

    private final ReplyService replyService;



}
