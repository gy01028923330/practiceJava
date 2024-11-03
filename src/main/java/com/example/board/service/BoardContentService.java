package com.example.board.service;


import com.example.board.domain.Board;
import com.example.board.domain.BoardContent;
import com.example.board.dto.BoardContentResponseDto;
import com.example.board.dto.BoardContentSearchCondition;
import com.example.board.repository.BoardContentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public BoardContent getOneBoardContent (Long boardContentId) throws Exception {
//        Optional<BoardContent> byId = boardContentRepository.findById(boardContentId);
//        BoardContent boardContent = byId.get();
        return boardContentRepository.findById(boardContentId).orElseThrow(()-> new Exception("test"));
    }

    private BoardContent findById(Long id) {
        try {
            return boardContentRepository.findById(id).orElseThrow(() -> new Exception("조회 실패"));
        } catch (Exception e) {
            return null;
        }
    }


    @Transactional
    public void delete(Long id) {
        boardContentRepository.delete(findById(id));
    }

}
