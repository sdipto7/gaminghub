package com.gaminghub.service;

import com.gaminghub.entity.Acl;
import com.gaminghub.repository.AclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rumi.dipto
 * @since 9/21/22
 */
@Service
public class AclService {

    @Autowired
    private AclRepository aclRepository;

    public void save(Acl acl) {
        aclRepository.save(acl);
    }
}
