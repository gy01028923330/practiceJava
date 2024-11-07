package com.example.app.member.controller;

import com.example.app.member.domain.Member;
import com.example.app.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    /**

     Architecture : 게시판 > 게시글
     Domain : 로마자로 나타낸 인터넷 사이트 주소 , 숫자로만 구성된 아이피(IP) 주소의 단점을 보완하기 위해 사용함.
     게시판 기능 == 카테고리
     a. 게시판 작성 -> 카테고리 생성 (Create)
     b. 게시판 조회 -> 카테고리 목록 출력
     c. 게시판 수정 -> 카테고리 명칭 변경
     d. 게시판 삭제 -> 카테고리에 포함되어있는 게시글 전체 삭제
     *
     게시글 기능
     게시글의 구성요소
     -> 제목, 내용, 작성자, 조회수, 댓글, 작성 일자, 수정 일자, 수정자(==작성자), 카테고리, 공개 여부, 좋아요, 해시태그
     A. 게시글 작성
     B. 게시글 조회 -> 게시글 목록 조회, 게시글 상세 조회.
     a. 게시글 목록 조회
     a-1. 조건 검색 [제목, 내용, 제목+내용, 작성자, 작성일자(범위)]
     a-2. 표시 항목 : [게시글번호, 게시글 제목, 작성자, 조회수, 댓글 수, 좋아요 수, 작성일자(<>수정일자)]
     a-3. 페이징 기능 (목록 하단에 게시글을 일정 수량 단위로 나눈 페이지의 갯수 출력)
     a-4. 정렬
     b. 게시글 상세 조회
     b-1. 표시 항목 : [제목, 내용, 작성자, 조회수, 댓글, 작성 일자, 수정 일자, 수정자(==작성자), 카테고리, 공개 여부, 좋아요, 해시태그]
     b-2. 댓글 (작성, 수정, 삭제)
     b-3. 좋아요 (Like, Unlike)
     C. 게시판 수정 -> 게시글 상세 내용 수정
     a. 수정 가능 항목 : [제목, 댓글, 내용, 카테고리, 해시 태그, 공개여부]
     D. 게시글 삭제 -> 게시글 단일 삭제
     *
     댓글 기능 (첫 댓글을 기준으로만 하위 댓글이 달리게 한다)
     A. 댓글 CRUD
     B. 대댓글 기능
     a. 대댓글
     ---------------- 고도화 기능 ---------------
     신고 기능
     A. 불량, 불법 게시글 신고처리.
     *
     통계 기능
     게시판(카테고리) 별 게시글 수
     전체 게시글 수
     게시판 별 조회 수
     신고 게시글 수
     */

    @PostMapping
    public String createMember() {
        return null;
    }

    @GetMapping("/member")
    public Member findMember(String inputId) {
        List<Member> completeMember = memberService.findMAllMember();
        return memberService.findMember(completeMember, inputId);
    }

    @GetMapping("/member/login")
    public Boolean login(String inputId, String inputPassword) {
        List<Member> completeMember = memberService.findMAllMember();

        Member findedMember = memberService.findMember(completeMember, inputId);
        return memberService.login(findedMember, inputId, inputPassword);
    }
}
