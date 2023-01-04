package com.example.board.service.user;

import com.example.board.dto.user.UserSaveDto;
import com.example.board.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveDto userSaveDto) {
        return userRepository.save(userSaveDto.toEntity()).getId();
    }
}
