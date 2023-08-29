package com.sseung.pilot.seungpilotproject.business.user.repo;

import com.sseung.pilot.seungpilotproject.business.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUserEmail(String userEmail);

    Optional<Users> findByNickName(String nickName);
}
