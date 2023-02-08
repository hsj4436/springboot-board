package com.example.board.service.posts;

import com.example.board.domain.posts.Posts;
import com.example.board.domain.user.User;
import com.example.board.dto.posts.PostsSaveRequestDto;
import com.example.board.repository.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto, User user) {
        Posts posts = Posts.builder()
                .user(user)
                .title(postsSaveRequestDto.getTitle())
                .content(postsSaveRequestDto.getContent())
                .build();

        return postsRepository.save(posts).getId();
    }
}
