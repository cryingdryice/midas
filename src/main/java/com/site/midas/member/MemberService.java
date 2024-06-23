package com.site.midas.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MemberService {
    
    private final MemberRepository memberRepository; // DB에 접근하기 위한 레파지토리

    public Member create(String username, String password) { // member엔티티 생성 메소드
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        this.memberRepository.save(member); // member 저장
        
        return member;
    }
}
