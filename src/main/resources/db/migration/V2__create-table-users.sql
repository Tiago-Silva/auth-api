CREATE TABLE `auth_api`.`users` (
    `id` VARCHAR(45) NOT NULL,
    `login` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `role` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);
