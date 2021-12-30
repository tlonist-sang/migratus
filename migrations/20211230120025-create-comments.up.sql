create table if NOT EXISTS `comments` (
    id int(11) NOT NULL auto_increment,
    content text,
    post_id int unsigned,
    primary key (id),
    foreign key (post_id) references posts(id)
)ENGINE=InnoDB AUTO_INCREMENT=505485 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
--;;
CREATE INDEX post_id on comments(post_id);