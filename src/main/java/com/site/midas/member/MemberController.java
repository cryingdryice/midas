package com.site.midas.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService; // 멤버관련 기능을 사용하기 위한 서비스
    @GetMapping("/members/create") // 해당 경로로 접속시 register.html로 연결
    public String createMemberForm(MemberForm memberForm) {
        return "join";
    }

    @PostMapping("/members/create") // 해당 경로에서 폼이 제출되면 실행
    public String createMember(@Valid MemberForm memberForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { // 내용이 비어있으면 오류
            return "join";
        }
        
        // memberFrom에서 얻어온 정보로 member엔티티 생성(db에 저장)
        memberService.create(memberForm.getUsername(), memberForm.getPassword());

        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String login() {
        return "login";
    }


}
