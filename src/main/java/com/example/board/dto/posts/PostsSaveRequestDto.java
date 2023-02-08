package com.example.board.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostsSaveRequestDto {

    private String title;

    private String content;

}
