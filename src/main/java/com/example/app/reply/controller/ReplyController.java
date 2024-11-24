package com.example.app.reply.controller;

import com.example.app.boardContent.dto.BoardContentResponseDto;
import com.example.app.reply.dto.ReplyCreateDto;
import com.example.app.reply.dto.ReplyResponseDto;
import com.example.app.reply.dto.ReplySearchCondition;
import com.example.app.reply.dto.ReplyUpdateDto;
import com.example.app.reply.service.ReplyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor //스프링에게 동작을 요청하기 위함
@RestController
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/api/reply")
    public ResponseEntity<String> createReply(@RequestBody ReplyCreateDto createDto) {
        replyService.create(createDto);
        return ResponseEntity.ok("댓글 생성 완료");
    }

    @GetMapping("/api/reply")
    public ResponseEntity<List<ReplyResponseDto>> searchReply(@ModelAttribute ReplySearchCondition condition) {
        List<ReplyResponseDto> reply = replyService.findReplyList(condition);
        return ResponseEntity.ok(reply);
    }

    @GetMapping("/api/reply")
    public ResponseEntity<ReplyResponseDto> getOne(@PathVariable Long id) throws Exception {
        ReplyResponseDto reply = replyService.getOneReply(id);
        return ResponseEntity.ok(reply);
    }


    @PutMapping("/api/reply/{id}")
    public ResponseEntity<String> updateReply(@PathVariable Long id,
                                              @RequestBody ReplyUpdateDto updateDto) {
        replyService.update(id, updateDto);
        return ResponseEntity.ok("댓글 수정 완료");
    }

    @DeleteMapping("/api/reply/{id}")
    public ResponseEntity<String> deleteReply(@PathVariable Long id) {
        replyService.delete(id);
        return ResponseEntity.ok("댓글 삭제 완료");
    }

}
