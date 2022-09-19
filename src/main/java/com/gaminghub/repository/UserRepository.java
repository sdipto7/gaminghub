package com.gaminghub.repository;

import com.gaminghub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rumi.dipto
 * @since 8/22/22
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
