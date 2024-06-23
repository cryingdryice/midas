package com.site.midas.member;

import jakarta.persistence.*;
import lombok.*;

@Entity	// DTO -> Entity화
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	// 자동 id 생성
    private Long id; // 멤버 번호

    @Column
    private String username; // 사용자 이름

    @Column(nullable = false) // 비밀번호
    private String password;
}
