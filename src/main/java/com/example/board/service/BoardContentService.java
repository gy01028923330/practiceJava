package com.example.board.service;


import com.example.board.domain.BoardContent;
import com.example.board.dto.BoardContentResponseDto;
import com.example.board.dto.BoardContentSearchCondition;
import com.example.board.repository.BoardContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardContentService {
    private final BoardContentRepository boardContentRepository;


    @Transactional
    public void create(String title, String content) {
        boardContentRepository.save(
                BoardContent.builder()
                        .title(title)
                        .content(content)
                        .build()
        );
    }

    @Transactional(readOnly = true)
    public List<BoardContentResponseDto> findBoardContentList(BoardContentSearchCondition condition) {
        List<BoardContent> boardContentList = boardContentRepository.findByBoardContentIdByCondition(condition);

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

}
