package com.site.midas;

import com.site.midas.member.MemberForm;
import com.site.midas.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/") // 해당 경로로 접속시 register.html로 연결
    public String homepage() {
        return "home";
    }

}
