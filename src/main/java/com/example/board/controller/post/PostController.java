package com.example.board.controller.post;

import com.example.board.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping("/post/write")
    public String writePost() {
        return "post/writeForm";
    }

    @GetMapping("/post/{postId}")
    public String showPost(@PathVariable Long postId, Model model) {
        model.addAttribute("post", postService.getPost(postId));
        return "post/showPost";
    }

    @GetMapping("/post/{postId}/updateForm")
    public String updatePost(@PathVariable Long postId, Model model) {
        model.addAttribute("post", postService.getPost(postId));
        return "/post/updateForm";
    }
}
