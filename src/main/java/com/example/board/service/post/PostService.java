package com.example.board.service.post;

import com.example.board.domain.post.Post;
import com.example.board.domain.user.User;
import com.example.board.dto.post.PostSaveRequestDto;
import com.example.board.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto postSaveRequestDto, User user) {
        Post post = Post.builder()
                .user(user)
                .title(postSaveRequestDto.getTitle())
                .content(postSaveRequestDto.getContent())
                .build();

        return postRepository.save(post).getId();
    }
}
