package com.example.board.repository.user;

import com.example.board.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO
// 자동으로 Bean으로 등록되며, @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Long> {

}
