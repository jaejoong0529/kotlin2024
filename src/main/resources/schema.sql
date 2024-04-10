-- JDBC에서 사용하는 테이블들
-- 테이블명을 소문자로 쓰고, 컬럼명에 underscore case를 사용한다.
CREATE TABLE if not exists user (
  id          int         NOT NULL AUTO_INCREMENT,
  username    varchar(50) NOT NULL,
  password    char(60)    NOT NULL,
  first_name  varchar(20) NOT NULL,
  date_joined datetime    NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (id),
  UNIQUE KEY username (username)
);

CREATE TABLE if not exists post (
  id            int          NOT NULL AUTO_INCREMENT,
  title         varchar(255) NOT NULL,
  content       text         NOT NULL,
  user_id       int          NOT NULL,
  first_name    varchar(20)  NOT NULL,
  pub_date      datetime     NOT NULL DEFAULT current_timestamp(),
  last_modified timestamp    NOT NULL DEFAULT current_timestamp() on update current_timestamp(),
  PRIMARY KEY (id),
  FULLTEXT KEY title (title),
  FULLTEXT KEY content (content),
  FOREIGN KEY (user_id) REFERENCES user (id)
);

-- JPA에서 사용하는 테이블들.
-- 테이블명이 대문자로 시작하고, 컬럼명에 camel case를 사용한다.
CREATE TABLE if not exists User (
  id         bigint      NOT NULL AUTO_INCREMENT,
  username   varchar(50) NOT NULL,
  password   char(60)    NOT NULL,
  firstName  varchar(20) NOT NULL,
  dateJoined datetime    NOT NULL DEFAULT current_timestamp,
  lastLogin  datetime    NOT NULL DEFAULT dateJoined,
  PRIMARY KEY (id),
  UNIQUE KEY username (username)
);

CREATE TABLE if not exists Post (
  id           bigint       NOT NULL AUTO_INCREMENT,
  title        varchar(255) NOT NULL,
  content      text         NOT NULL,
  user_id      bigint       NOT NULL, -- User.id를 참조하는 foreign key
  pubDate      datetime     NOT NULL DEFAULT current_timestamp(),
  lastModified timestamp    NOT NULL DEFAULT current_timestamp() on update current_timestamp(),
  PRIMARY KEY (id),
  FOREIGN KEY fk_User (user_id) REFERENCES User (id),
  FULLTEXT KEY title (title),
  FULLTEXT KEY content (content)
);