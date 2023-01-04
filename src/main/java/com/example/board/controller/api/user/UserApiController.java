package com.example.board.controller.api.user;

import com.example.board.dto.user.UserSaveDto;
import com.example.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveDto userSaveDto) {
        return userService.save(userSaveDto);
    }
}
