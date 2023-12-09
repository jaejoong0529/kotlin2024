CREATE TABLE user (
  userId   int unsigned NOT NULL AUTO_INCREMENT,
  email    varchar(50)  NOT NULL,
  password char(64)     NOT NULL,
  name     varchar(20)  NOT NULL,
  PRIMARY KEY (userId),
  UNIQUE KEY email (email)
);

CREATE TABLE post (
  postId int unsigned NOT NULL AUTO_INCREMENT,
  title     varchar(255) NOT NULL,
  content   text         NOT NULL DEFAULT '',
  userId    int unsigned NOT NULL,
  name      varchar(20)  NOT NULL,
  cdate     datetime     NOT NULL DEFAULT current_timestamp(),
  udate     timestamp    NOT NULL,
  PRIMARY KEY (postId),
  KEY userId (userId),
  FULLTEXT KEY title (title),
  FULLTEXT KEY content (content),
  FOREIGN KEY (userId) REFERENCES user (userId)
);