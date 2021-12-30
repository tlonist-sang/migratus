CREATE TABLE `posts` (
                         `id` int unsigned NOT NULL AUTO_INCREMENT,
                         `content` text,
                         `user_id` int unsigned,
                         PRIMARY KEY (`id`),
                         foreign key (`user_id`) REFERENCES users_test(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=505485 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;