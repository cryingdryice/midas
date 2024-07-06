package com.site.midas.sorting;

import com.site.midas.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class SortingService {
    private final SortingRepository sortingRepository;

    public List<Sorting> getList(){
        return this.sortingRepository.findAll();
    }

    public Sorting getSorting(Integer id) {
        Optional<Sorting> sorting = this.sortingRepository.findById(id);
        return sorting.get();
    }

    public void create(String subject, String content, Member member) {
        Sorting s = new Sorting();
        s.setSubject(subject);
        s.setContent(content);
        s.setCreateDate(LocalDateTime.now());
        s.setAuthor(member);
        this.sortingRepository.save(s);
    }
}
