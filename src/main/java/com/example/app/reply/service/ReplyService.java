package com.example.app.reply.service;


import com.example.app.boardContent.domain.BoardContent;
import com.example.app.member.domain.Member;
import com.example.app.reply.domain.Reply;
import com.example.app.reply.dto.ReplyCreateDto;
import com.example.app.reply.dto.ReplyResponseDto;
import com.example.app.reply.dto.ReplySearchCondition;
import com.example.app.reply.dto.ReplyUpdateDto;
import com.example.app.reply.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;


    @Transactional
    public void create(ReplyCreateDto createdDto) {

        Reply savedReply =
                replyRepository.save(
                        Reply.builder()
                                .replyContent(createdDto.getReplyContent())
                                .boardContent(BoardContent.builder().id(createdDto.getBoardContentId()).build())
                                .member(Member.builder().id(createdDto.getMemberId()).build())
                                .build()
        );
    }

    @Transactional
    public List<ReplyResponseDto> findReplyList(ReplySearchCondition condition) {
        List<Reply> replyList = replyRepository.findReplyByCondition(condition);

        List<ReplyResponseDto> replyResponseDtoList = new ArrayList<>();
        for (Reply reply : replyList) {
            replyResponseDtoList.add(ReplyResponseDto.builder()
                            .replyId(reply.getId())
                            .replyContent(reply.getReplyContent())
                            .boardContentId(reply.getBoardContent().getId())
                            .memberId(reply.getMember().getId())
                            .build());
        }
        return replyResponseDtoList;
    }


    @Transactional(readOnly = true)
    public ReplyResponseDto getOneReply (Long replyId) throws Exception {
        Reply byId = findById(replyId);
        return ReplyResponseDto.builder()
                .replyId(replyId)
                .replyContent(byId.getReplyContent())
                .boardContentId(byId.getBoardContent().getId())
                .memberId(byId.getMember().getId())
                .build();
    }


    @Transactional(readOnly = true)
    public Reply findById(Long id) {
        return replyRepository.findById(id).orElse(null);
    }


    @Transactional
    public void update(Long id, ReplyUpdateDto updatedDto) {
        Reply reply = findById(id);
        reply.updateFrom(updatedDto);
    }


    @Transactional
    public void delete(Long id) {
        replyRepository.deleteById(id);
    }


}
