package com.gaminghub.util;

import com.gaminghub.entity.Role;

import static com.gaminghub.entity.Role.*;

/**
 * @author rumi.dipto
 * @since 9/23/22
 */
public interface Constant {

    Role[] ADMIN_ROLES = new Role[]{
            ROLE_DASHBOARD_VIEW,
            ROLE_ADMIN_VIEW,
            ROLE_ADMIN_CREATE,
            ROLE_ADMIN_DELETE,
            ROLE_MANAGEMENT_VIEW,
            ROLE_MANAGEMENT_CREATE,
            ROLE_MANAGEMENT_UPDATE,
            ROLE_MANAGEMENT_DELETE,
            ROLE_CUSTOMER_VIEW,
            ROLE_CUSTOMER_DELETE,
            ROLE_GAME_VIEW,
            ROLE_ORDER_VIEW
    };

    Role[] MANAGEMENT_ROLES = new Role[]{
            ROLE_DASHBOARD_VIEW,
            ROLE_ADMIN_VIEW,
            ROLE_MANAGEMENT_VIEW,
            ROLE_CUSTOMER_VIEW,
            ROLE_CUSTOMER_DELETE,
            ROLE_GAME_VIEW,
            ROLE_GAME_CREATE,
            ROLE_GAME_UPDATE,
            ROLE_GAME_DELETE,
            ROLE_ORDER_VIEW
    };

    Role[] CUSTOMER_ROLES = new Role[]{
            ROLE_DASHBOARD_VIEW,
            ROLE_CUSTOMER_CREATE,
            ROLE_GAME_VIEW,
            ROLE_ORDER_VIEW,
            ROLE_ORDER_CREATE,
            ROLE_ORDER_UPDATE,
            ROLE_ORDER_DELETE
    };
}
