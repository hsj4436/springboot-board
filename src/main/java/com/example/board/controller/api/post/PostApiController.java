package com.example.board.controller.api.post;

import com.example.board.config.auth.PrincipalDetail;
import com.example.board.dto.post.PostSaveRequestDto;
import com.example.board.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/post/add")
    public Long save(@RequestBody PostSaveRequestDto postSaveRequestDto,
                     @AuthenticationPrincipal PrincipalDetail principalDetail) {

        return postService.save(postSaveRequestDto, principalDetail.getUser());
    }
}
