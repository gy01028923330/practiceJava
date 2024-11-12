package com.example.app.boardContent.service;


import com.example.app.boardContent.domain.BoardContent;
import com.example.app.boardContent.dto.BoardContentResponseDto;
import com.example.app.boardContent.dto.BoardContentSearchCondition;
import com.example.app.boardContent.dto.BoardContentUpdateDto;
import com.example.app.boardContent.repository.BoardContentRepository;
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

    @Transactional(readOnly = true)
    public BoardContentResponseDto getOneBoardContent (Long boardContentId) throws Exception {
//        Optional<BoardContent> byId = boardContentRepository.findById(boardContentId);
//        BoardContent boardContent = byId.get();
        return BoardContentResponseDto.builder()
                .boardContentId(boardContentId)
                .title(findById(boardContentId).getTitle())
                .content(findById(boardContentId).getContent())
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
