CREATE TABLE gaming_hub.gh_user
(
    id           INT          NOT NULL AUTO_INCREMENT,
    created      DATETIME     NOT NULL,
    updated      DATETIME,
    version      INT          NOT NULL,
    first_name   VARCHAR(100) NOT NULL,
    last_name    VARCHAR(100) NOT NULL,
    username     VARCHAR(100) NOT NULL,
    password     VARCHAR(100) NOT NULL,
    address      VARCHAR(100) NOT NULL,
    type         VARCHAR(100) NOT NULL,
--     access_token VARCHAR(256) NOT NULL,
    access_token VARCHAR(256),
    activated    TINYINT(1) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT gh_user_uk_username UNIQUE (username)
);

CREATE TABLE gaming_hub.gh_acl
(
    id      INT          NOT NULL AUTO_INCREMENT,
    created DATETIME     NOT NULL,
    updated DATETIME,
    version INT          NOT NULL,
    user_id INT          NOT NULL,
    role    VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT gh_acl_fk_user_id FOREIGN KEY (user_id) REFERENCES gaming_hub.gh_user (id)
);

CREATE TABLE gaming_hub.gh_game
(
    id            INT          NOT NULL AUTO_INCREMENT,
    created       DATETIME     NOT NULL,
    updated       DATETIME,
    version       INT          NOT NULL,
    title         VARCHAR(100) NOT NULL,
    description   VARCHAR(100),
    price_daily   DECIMAL(10, 2),
    price_weekly  DECIMAL(10, 2),
    price_monthly DECIMAL(10, 2),
    availability  TINYINT(1),
    PRIMARY KEY (id)
);

CREATE TABLE gaming_hub.gh_order
(
    id          INT      NOT NULL AUTO_INCREMENT,
    created     DATETIME NOT NULL,
    updated     DATETIME,
    version     INT      NOT NULL,
    user_id     INT      NOT NULL,
    game_id     INT      NOT NULL,
    order_date  DATETIME NOT NULL,
    return_date DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT gh_order_fk_user_id FOREIGN KEY (user_id) REFERENCES gaming_hub.gh_user (id),
    CONSTRAINT gh_order_fk_game_id FOREIGN KEY (game_id) REFERENCES gaming_hub.gh_game (id)
);