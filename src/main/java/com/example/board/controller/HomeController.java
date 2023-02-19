package com.example.board.controller;

import com.example.board.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final PostService postService;

    @GetMapping("/")
    public String home(Model model, @PageableDefault(size=10, sort="id", direction= Sort.Direction.DESC)Pageable pageable) {
        model.addAttribute("posts", postService.getPosts(pageable));
        return "home";
    }
}
