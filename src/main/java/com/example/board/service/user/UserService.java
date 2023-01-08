package com.example.board.service.user;

import com.example.board.domain.user.User;
import com.example.board.dto.user.UserLoginRequest;
import com.example.board.dto.user.UserSaveDto;
import com.example.board.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveDto userSaveDto) {
        return userRepository.save(userSaveDto.toEntity()).getId();
    }

    @Transactional
    public User login(UserLoginRequest userLoginRequest) {

        return userRepository.findByUserName(userLoginRequest.getUserName())
                .filter(m -> m.getPassword().equals(userLoginRequest.getPassword()))
                .orElse(null);
    }
}
