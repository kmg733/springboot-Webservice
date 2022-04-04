package com.kmg733.org.study.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 소셜 로그인으로 반환되는 값 중 email을 통해 처음 가입하는 사용자인지, 이미 가입한 사용자인지 판단
    Optional<User> findByEmail(String email);
}
