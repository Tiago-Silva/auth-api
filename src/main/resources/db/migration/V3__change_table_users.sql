ALTER TABLE `auth_api`.`users`
DROP COLUMN `role`,
ADD COLUMN `nome` VARCHAR(45) NULL AFTER `password`,
ADD COLUMN `sobre_nome` VARCHAR(45) NULL AFTER `nome`,
ADD COLUMN `account_non_expired` BIT(1) NULL AFTER `sobre_nome`,
ADD COLUMN `account_non_locked` BIT(1) NULL AFTER `account_non_expired`,
ADD COLUMN `credentials_non_expired` VARCHAR(1) NULL AFTER `account_non_locked`,
ADD COLUMN `enabled` BIT(1) NULL AFTER `credentials_non_expired`;
