package com.example.board.controller.api.user;

import com.example.board.domain.user.User;
import com.example.board.dto.user.UserLoginRequest;
import com.example.board.dto.user.UserSaveDto;
import com.example.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveDto userSaveDto) {
        return userService.save(userSaveDto);
    }

    @PostMapping("/api/v1/user/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest userLoginRequest, HttpSession session) {
        User loginUser = userService.login(userLoginRequest);

        if (loginUser == null) {
            return ResponseEntity.notFound().build();
        }

        session.setAttribute("loginUser", loginUser);

        return ResponseEntity.ok("로그인 성공");
    }
}
