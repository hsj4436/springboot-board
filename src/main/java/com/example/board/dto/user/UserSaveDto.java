package com.example.board.dto.user;

import com.example.board.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveDto {

    private String userName;
    private String password;
    private String email;


    public User toEntity() {
        return User.builder()
                .userName(userName)
                .password(password)
                .email(email)
                .build();
    }
}
