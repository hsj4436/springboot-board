package com.example.board.dto.post;

import com.example.board.domain.post.Post;
import com.example.board.domain.reply.Reply;
import com.example.board.domain.user.User;
import com.example.board.dto.user.UserResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private Long id;

    private String title;

    private String content;

    private Long count;

    private UserResponseDto user;

    private List<Reply> reply;

    private Timestamp createDate;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.count = post.getCount();
        this.user = new UserResponseDto(post.getUser());
        this.reply = post.getReply();
        this.createDate = post.getCreateDate();
    }

}
