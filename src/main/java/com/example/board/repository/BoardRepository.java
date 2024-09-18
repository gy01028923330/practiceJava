package com.example.board.repository;


import com.example.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    /**
     * repository 란 DB아 직접적으로 맞닿아 있는 클래스(컴포 넌트)
     */

}



