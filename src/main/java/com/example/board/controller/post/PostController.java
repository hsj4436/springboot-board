package com.example.board.controller.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("/post/write")
    public String postsWrite() {
        return "post/writeForm";
    }
}
