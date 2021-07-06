package kr.com.youhost.cfp.querydsl.repository;

import kr.com.youhost.cfp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findByUserName(String userName);
}
