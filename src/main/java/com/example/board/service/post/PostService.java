package com.example.board.service.post;

import com.example.board.domain.post.Post;
import com.example.board.domain.user.User;
import com.example.board.dto.post.PostResponseDto;
import com.example.board.dto.post.PostSaveRequestDto;
import com.example.board.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public PostResponseDto getPost(Long id) {
        return postRepository.findById(id)
                .map(PostResponseDto::new)
                .orElseThrow(() -> new IllegalArgumentException("해당 post를 찾을 수 없습니다."));
    }
}
