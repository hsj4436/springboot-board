package com.example.board.dto.user;

import com.example.board.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long id;

    private String userName;

    private String email;

    private Timestamp createDate;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.createDate = user.getCreateDate();
    }
}
