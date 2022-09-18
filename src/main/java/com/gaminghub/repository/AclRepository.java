package com.gaminghub.repository;

import com.gaminghub.entity.Acl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rumi.dipto
 * @since 9/21/22
 */
@Repository
public interface AclRepository extends JpaRepository<Acl, Long> {
}
