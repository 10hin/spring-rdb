CREATE TABLE `user` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(1024) NOT NULL,
    `age` smallint,
    `memo` test,
    CONSTRAINT user_id_pkc PRIMARY KEY (`id`)
);
