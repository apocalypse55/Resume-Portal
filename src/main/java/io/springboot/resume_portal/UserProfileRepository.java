package io.springboot.resume_portal;



import io.springboot.resume_portal.models.User;
import io.springboot.resume_portal.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    Optional<UserProfile> findByUserName(String userName);
}