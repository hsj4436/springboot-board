package com.example.board.controller.api.post;

import com.example.board.config.auth.PrincipalDetail;
import com.example.board.dto.post.PostSaveRequestDto;
import com.example.board.dto.post.PostUpdateRequestDto;
import com.example.board.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/add")
    public Long save(@RequestBody PostSaveRequestDto postSaveRequestDto,
                     @AuthenticationPrincipal PrincipalDetail principalDetail) {

        return postService.save(postSaveRequestDto, principalDetail.getUser());
    }

    @DeleteMapping("/delete/{postId}")
    public Long delete(@PathVariable Long postId) {
        postService.delete(postId);
        return postId;
    }

    @PutMapping("/update/{postId}")
    public Long update(@PathVariable Long postId,
                       @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        postService.update(postId, postUpdateRequestDto);
        return postId;
    }
}
