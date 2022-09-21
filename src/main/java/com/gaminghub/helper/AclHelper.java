package com.gaminghub.helper;

import com.gaminghub.entity.Acl;
import com.gaminghub.entity.Role;
import com.gaminghub.entity.User;
import com.gaminghub.service.AclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.gaminghub.entity.Role.*;

/**
 * @author rumi.dipto
 * @since 9/21/22
 */
@Component
public class AclHelper {

    @Autowired
    private AclService aclService;

    public void setRoleAndCreateAclForUser(User user) {
        Set<Role> roleSet = new HashSet<>();

        switch (user.getUserType()) {
            case USER_TYPE_ADMIN:
                roleSet.addAll(Arrays.asList(values()));
                break;
            case USER_TYPE_MANAGEMENT:
                roleSet.addAll(Arrays.asList(ROLE_GAME_CREATE, ROLE_GAME_UPDATE));
                break;
            case USER_TYPE_SALES_EXECUTIVE:
                roleSet.addAll(Arrays.asList(ROLE_GAME_CREATE, ROLE_GAME_UPDATE));
                break;
            case USER_TYPE_CUSTOMER:
                roleSet.add(ROLE_USER_UPDATE);
                break;
        }

        roleSet.stream().forEach(role -> {
            Acl acl = new Acl(user, role);

            aclService.save(acl);
        });
    }
}
