package com.example.app.boardContent.service;


import com.example.app.board.domain.Board;
import com.example.app.board.service.BoardService;
import com.example.app.boardContent.domain.BoardContent;
import com.example.app.boardContent.dto.BoardContentCreateDto;
import com.example.app.boardContent.dto.BoardContentResponseDto;
import com.example.app.boardContent.dto.BoardContentSearchCondition;
import com.example.app.boardContent.dto.BoardContentUpdateDto;
import com.example.app.boardContent.repository.BoardContentRepository;
import com.example.app.member.domain.Member;
import com.example.app.reply.domain.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardContentService {

    private final BoardContentRepository boardContentRepository;

    private final BoardService boardService;

    @Transactional
    public void create(BoardContentCreateDto createDto) {

        BoardContent savedBoardContent =
                boardContentRepository.save(
                BoardContent.builder()
                        .title(createDto.getTitle())
                        .content(createDto.getContent())
                        .board(Board.builder().id(createDto.getBoardId()).build())
                        .createdBy(Member.builder().id(createDto.getCreatedMemberId()).build())
                        .build()
        );
    }

    @Transactional(readOnly = true)
    public List<BoardContentResponseDto> findBoardContentList(BoardContentSearchCondition condition) {
        List<BoardContent> boardContentList = boardContentRepository.findBoardContentByCondition(condition);

        List<BoardContentResponseDto> boardContentResponseDtoList = new ArrayList<>();
        for (BoardContent boardContent : boardContentList) {
            boardContentResponseDtoList.add(BoardContentResponseDto.builder()
                    .boardContentId(boardContent.getId())
                    .title(boardContent.getTitle())
                    .content(boardContent.getContent())
                    .build());
        }
        return boardContentResponseDtoList;

    }

    @Transactional(readOnly = true)
    public BoardContentResponseDto getOneBoardContent (Long boardContentId) throws Exception {
//        Optional<BoardContent> byId = boardContentRepository.findById(boardContentId);
//        BoardContent boardContent = byId.get();
        BoardContent byId = findById(boardContentId);
        return BoardContentResponseDto.builder()
                .boardContentId(boardContentId)
                .title(byId.getTitle())
                .content(byId.getContent())
                .build();
    }

    @Transactional
    public void update (Long id, BoardContentUpdateDto updateDto) {
        BoardContent boardContent = findById(id);
        boardContent.updateFrom(updateDto);

    }


    @Transactional(readOnly = true)
    public BoardContent findById(Long id) {

        return boardContentRepository.findById(id).orElse(null);
    }


    @Transactional
    public void delete(Long id) {
        boardContentRepository.delete(findById(id));
    }

}
