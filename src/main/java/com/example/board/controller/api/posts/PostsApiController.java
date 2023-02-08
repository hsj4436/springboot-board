package com.example.board.controller.api.posts;

import com.example.board.config.auth.PrincipalDetail;
import com.example.board.dto.posts.PostsSaveRequestDto;
import com.example.board.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts/add")
    public Long save(@RequestBody PostsSaveRequestDto postsSaveRequestDto,
                     @AuthenticationPrincipal PrincipalDetail principalDetail) {

        return postsService.save(postsSaveRequestDto, principalDetail.getUser());
    }
}
