CREATE TABLE `blood_donation` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,              -- 自增长ID
  `bloodType` VARCHAR(10) NOT NULL,                  -- 血型
  `bloodCategory` VARCHAR(20) NOT NULL,              -- 血液种类
  `bloodBagNumber` INT NOT NULL,                     -- 血袋编号
  `bloodVolume` DECIMAL(5, 2) NOT NULL,              -- 血液体积 (单位：毫升)
  `isQualified` ENUM('Yes', 'No') NOT NULL,          -- 是否合格
  `registrationDate` DATETIME NOT NULL,              -- 登记日期
  `donorID` INT,                                    -- 捐献者ID (外键)
  `staffID` INT                                    -- 工作人员ID (外键)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `blood_donation` (`id`, `bloodType`, `bloodCategory`, `bloodBagNumber`, `bloodVolume`, `isQualified`, `registrationDate`, `donorID`, `staffID`) VALUES (1, '1', '1', 1, '1', '1', '2024-12-06 18:07:59', 0, 0);
INSERT INTO `blood_donation` (`id`, `bloodType`, `bloodCategory`, `bloodBagNumber`, `bloodVolume`, `isQualified`, `registrationDate`, `donorID`, `staffID`) VALUES (2, '2', '2', 2, '2', '2', '2024-12-03 18:08:12', 1, 0);
