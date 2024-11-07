package com.example.app.board.repository;


import com.example.app.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
    //
    // 아래와 같은 자동생성 메소드로는 동적 쿼리 불가능
    List<Board> findAllByBoardNameAndCategory(String boardName, String category);

}



