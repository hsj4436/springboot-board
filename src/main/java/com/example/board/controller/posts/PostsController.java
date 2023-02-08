package com.example.board.controller.posts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {

    @GetMapping("/posts/write")
    public String postsWrite() {
        return "posts/writeForm";
    }
}
