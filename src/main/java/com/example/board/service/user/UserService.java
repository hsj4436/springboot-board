package com.example.board.service.user;

import com.example.board.domain.user.User;
import com.example.board.dto.user.UserLoginRequest;
import com.example.board.dto.user.UserSaveDto;
import com.example.board.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Long save(UserSaveDto userSaveDto) {
        User user = User.builder()
                .userName(userSaveDto.getUserName())
                .password(passwordEncoder.encode(userSaveDto.getPassword()))
                .email(userSaveDto.getEmail())
                .build();
        return userRepository.save(user).getId();
    }

    @Transactional
    public User login(UserLoginRequest userLoginRequest) {

        return userRepository.findByUserName(userLoginRequest.getUserName())
                .filter(m -> m.getPassword().equals(userLoginRequest.getPassword()))
                .orElse(null);
    }
}
