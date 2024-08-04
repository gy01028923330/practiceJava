package com.example.board.service;


import com.example.board.dto.BoardCreateRequestDto;
import org.springframework.stereotype.Service;

@Service
public class BoardService {


    /**
     * Service 란 Controller 에서 전달받은 데이터를 기반으로 서비스로직을 구현하는 클래스(컴포넌트)
     *  역할
     *      1. 사용자에게 제공되어야 하는 기능(API)을 작성하는 실질적인 부분
     *      2. DB 에서 받아온 데이터를 가공하여 기능에 사용하기 적합하도록 만드는 부분
     *      3. 에러가 발생 할 경우 이를 처리하는 부분 (프로젝트 전략에 따라 다를 수 있다)
     *
     */

    public void create(String boardName, String category) {

    }

}
