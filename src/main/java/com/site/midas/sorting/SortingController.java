package com.site.midas.sorting;

import com.site.midas.member.Member;
import com.site.midas.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class SortingController {
    private final SortingService sortingService;
    private final MemberService memberService;
    @GetMapping("/sorting/list")
    public String list(Model model) {
        List<Sorting> sortingList = this.sortingService.getList();
        model.addAttribute("sortingList", sortingList);

        return "sorting";
    }
    @GetMapping(value = "/sorting/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Sorting sorting = this.sortingService.getSorting(id);
        model.addAttribute("sorting", sorting);
        return "sorting_detail";
    }

    @GetMapping("/sorting/create")
    public String sortingCreate(SortingForm sortingForm) {
        return "sorting_form";
    }

    @PostMapping("/sorting/create")
    public String sortingCreate(@Valid SortingForm sortingForm, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors()){
            return "sorting_form";
        }
        Member member = this.memberService.getMember(principal.getName());

        this.sortingService.create(sortingForm.getSubject(), sortingForm.getContent(), member);
        return "redirect:/sorting/list"; // 질문 저장후 질문목록으로 이동
    }
}
