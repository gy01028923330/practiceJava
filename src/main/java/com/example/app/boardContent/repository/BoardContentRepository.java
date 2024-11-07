package com.example.app.boardContent.repository;

import com.example.app.boardContent.domain.BoardContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardContentRepository extends JpaRepository<BoardContent, Long>, BoardContentRepositoryCustom {

}