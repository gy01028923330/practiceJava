package com.example.app.boardContent.controller;


import com.example.app.boardContent.domain.BoardContent;
import com.example.app.boardContent.dto.BoardContentCreateDto;
import com.example.app.boardContent.dto.BoardContentResponseDto;
import com.example.app.boardContent.dto.BoardContentSearchCondition;
import com.example.app.boardContent.dto.BoardContentUpdateDto;
import com.example.app.boardContent.service.BoardContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardContentController {

    private final BoardContentService boardContentService;


    @PostMapping("/api/board-content/")
    public ResponseEntity<String> createBoardContent(@RequestBody BoardContentCreateDto createDto) {
        boardContentService.create(createDto.getTitle(), createDto.getContent());
        return ResponseEntity.ok("게시판 생성 완료");
    }

    @GetMapping("/api/board-content")
    public ResponseEntity<List<BoardContentResponseDto>> searchBoardContent(
            @ModelAttribute BoardContentSearchCondition condition) {
        List<BoardContentResponseDto> boardContent = boardContentService.findBoardContentList(condition);
        return ResponseEntity.ok(boardContent);
    }

    @GetMapping("/api/board-content/{id}")
    public ResponseEntity<BoardContentResponseDto> searchOne(@PathVariable Long id) throws Exception {
        BoardContentResponseDto boardContent = boardContentService.getOneBoardContent(id);
        return ResponseEntity.ok(boardContent);
    }


    @PutMapping("/api/board-content/{id}")
    public ResponseEntity<String> updateBoardContent(@PathVariable Long id,
                                                     @RequestBody BoardContentUpdateDto updateDto) {
        boardContentService.update(id, updateDto);
        return ResponseEntity.ok("게시판 수정 완료");
    }

    @DeleteMapping("/api/board-content/{id}")
    public ResponseEntity<String> deleteBoardContent(@PathVariable Long id) {
        boardContentService.delete(id);
        return ResponseEntity.ok("게시판 삭제 완료");
    }

}
