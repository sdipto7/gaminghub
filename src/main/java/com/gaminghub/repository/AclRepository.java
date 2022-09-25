package com.gaminghub.repository;

import com.gaminghub.entity.Acl;
import com.gaminghub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rumi.dipto
 * @since 9/21/22
 */
@Repository
public interface AclRepository extends JpaRepository<Acl, Long> {

    List<Acl> findAllByUser(User user);
}
