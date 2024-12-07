DROP TABLE IF EXISTS `blood_bank_management`;

CREATE TABLE `blood_bank_management` (
    `id` INT NOT NULL AUTO_INCREMENT,                -- 主键，假设自增
    `bloodCategory` VARCHAR(255) NOT NULL,           -- 血液类别
    `bloodVolume` INT NOT NULL,                      -- 血液体积（单位：毫升）
    `transactionDate` DATETIME NOT NULL,             -- 交易日期时间
    `expirationDate` DATETIME NOT NULL,              -- 过期日期时间
    `bloodSource` VARCHAR(255) NOT NULL,             -- 血液来源
    `remarks` TEXT,                                  -- 备注
    `addtime` DATETIME NOT NULL,                     -- 添加时间
    `bloodType` VARCHAR(10) NOT NULL,                -- 血型（如 A+、A-）
    PRIMARY KEY (`id`)                               -- 设置 id 为主键
);

INSERT INTO `blood_bank_management` 
    (`id`, `bloodCategory`, `bloodVolume`, `transactionDate`, `expirationDate`, `bloodSource`, `remarks`, `addtime`, `bloodType`)
VALUES
    (1, 'Whole Blood', 100, '2024-12-05 21:24:07', '2024-12-05 23:24:10', 'Volunteer Donation', 'Regular donor', '2024-12-05 21:26:05', 'A+'),
    (2, 'Shit Blood', 450, '2024-12-05 21:40:36', '2024-12-05 21:40:39', 'Volunteer Donation', 'Fucker', '2024-12-05 21:40:57', 'A-');
