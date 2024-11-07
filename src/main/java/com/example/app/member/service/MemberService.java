package com.example.app.member.service;


import com.example.app.member.domain.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Service
public class MemberService {

    public List<Member> createMember(Member m, List<Member> completeMember) {


        Boolean result = validateMember(m, completeMember);

        if (result) {
            return completeMember;
        } else {
            completeMember.add(m);

            return completeMember;
        }

    }

    public Boolean validateMember(Member member, List<Member> completeMember) {

        for (Member m : completeMember) {
            if (m.getId().equals(member.getId())) {
                return true;
            }
        }

        return false;
    }


    // 성별로 회원을 검색하는 메소드
    public List<Member> searchMemberByGender(List<Member> completeList, String gender) {

        List<Member> result = new ArrayList<>();

        for (Member m : completeList) {
            if (m.getGender().equals(gender)) {
                result.add(m);
            }
        }

        return result;

    }

    //성별+나이의 범위로 회원을 겁색하는 메소드

    public List<Member> searchMemberByGenderAndAge(List<Member> completeList, String gender, Integer minAge, Integer maxAge) {
        // 1.성별 또는 나이만 검색 가능
        // 2.최소나이만 검색
        // 3. 최대나이만 검색
        // 4. 성별+최대나이 검색
        // 5. 성별+최소나이 검색
        List<Member> result = new ArrayList<>();


        if (hasText(gender) && minAge != null && maxAge != null) {
            for (Member m : completeList) {
                if (m.getGender().equals(gender) && m.getAge() >= minAge && m.getAge() <= maxAge) {
                    result.add(m);
                }
            }
        } else if (!hasText(gender)) { // hasText() -> 비어있는 문자열 또는 null 값 두개를 모두 비교한다.
            for (Member m : completeList) {
                if (m.getAge() >= minAge && m.getAge() <= maxAge) {
                    result.add(m);

                }
            }
        } else if (!hasText(gender) && minAge == null) {
            for (Member m : completeList) {
                if (m.getAge() <= maxAge) {
                    result.add(m);
                }
            }
        } else if (!hasText(gender) && maxAge == null) {
            for (Member m : completeList) {
                if (m.getAge() >= minAge) {
                    result.add(m);
                }
            }
        } else if (minAge == null) {
            for (Member m : completeList) {
                if (m.getGender().equals(gender) && m.getAge() <= maxAge) {
                    result.add(m);
                }
            }
        } else if (maxAge == null) {
            for (Member m : completeList) {
                if (m.getGender().equals(gender) && m.getAge() >= minAge) {
                    result.add(m);
                }
            }
        }

        return result;
    }

    public Boolean login(Member findMember, String id, String password) {
        System.out.println("입력된 ID : " + id + "// 입력된 Password : " + password);
        if (findMember.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public Member findMember(List<Member> completeMember, String inputId) {
        for (Member m : completeMember) {
            if (m.getId().equals(inputId)) {
                return m;
            }
        }
        return null;
    }

    public Member updateMember(Member findedMember, String password, String name, String gender, Integer age) {
        findedMember.setPassword(password);
        findedMember.setName(name);
        findedMember.setGender(gender);
        findedMember.setAge(age);
        return findedMember;
    }

    public List<Member> save(List<Member> completeMember, Member updatedMember) {
        for (int i = 0; i < completeMember.size(); i++) {
            if(completeMember.get(i).getId().equals(updatedMember.getId())) {
                completeMember.set(i, updatedMember);
            }
        }
        return completeMember;
    }

    public List<Member> deleteMember( List<Member> completeMember, Member findedMember) {
        for (Member m : completeMember) {
            if(m.getId().equals(findedMember.getId())) {
                completeMember.remove(m);
                return completeMember;
            }
        }
        return completeMember;
    }

    public List<Member> findMAllMember() {
        List<Member> allMember = new ArrayList<>();
        //DB 조회 로직 적용 -> allMember 에 전체 회원정보를 입력 후 반환

        return allMember;
    }
}

    /**
     *  단일 책임 원칙 (개발 방법론중 하나)
     *  한개의 매소드 당 한가지의 기능만 가진다
     */

    /**
     *  게시판 서비스 개발
     *
     *  필요 기능 List
     *
     *  1. 회원 가입
     *      a. ID
     *      b. password
     *      d. Name
     *
     *
     *  2. 로그인
     *      a. ID
     *      b. password
     *
     *  3. 게시판 작성
     *      a. Title
     *      b. Content
     *      c. Writer
     *      d. CreateDate
     *      e. reply
     *  4. 댓글
     *      a. Writer
     *      b. CreateDate
     *      c. Content
     *      d. Board
     *
     */

