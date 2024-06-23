package com.site.midas.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm
{
    @NotEmpty(message = "이름을 입력해주세요")
    private String username; // 사용자가 입력할 유저이름

    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password; // 사용자가 입력할 비밀번호
}
