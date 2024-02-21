CREATE TABLE `auth_api`.`users` (
    `id` VARCHAR(300) NOT NULL,
    `login` VARCHAR(45) NOT NULL,
    `password` VARCHAR(300) NOT NULL,
    `role` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);
