package com.site.midas.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberService {
    
    private final MemberRepository memberRepository; // DB에 접근하기 위한 레파지토리
    private final PasswordEncoder passwordEncoder;

    public Member create(String username, String password) { // member엔티티 생성 메소드
        Member member = new Member();
        member.setUsername(username);

        member.setPassword(passwordEncoder.encode(password));
        this.memberRepository.save(member); // member 저장
        
        return member;
    }

    public Member getMember(String username) {
        Optional<Member> siteUser = this.memberRepository.findByusername(username);
        return siteUser.get();
    }
}
