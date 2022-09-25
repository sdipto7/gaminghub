package com.gaminghub.service;

import com.gaminghub.entity.Acl;
import com.gaminghub.entity.User;
import com.gaminghub.repository.AclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rumi.dipto
 * @since 9/21/22
 */
@Service
public class AclService {

    @Autowired
    private AclRepository aclRepository;

    public List<Acl> findAllByUser(User user) {
        return aclRepository.findAllByUser(user);
    }

    public void save(Acl acl) {
        aclRepository.save(acl);
    }
}
