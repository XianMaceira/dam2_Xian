
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS `aldComputerService` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `aldComputerService`;


DROP TABLE IF EXISTS `clients`;
CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `telephone` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `clients` (`id`, `name`, `telephone`) VALUES
(1, 'John Smith', '555-1234'),
(2, 'Mary Johnson', '555-5678'),
(3, 'Carlos Rodriguez', '555-9012'),
(4, 'Laura Martin', '555-3456'),
(5, 'Alexander Lopez', '555-7890'),
(6, 'Anna Sanchez', '555-2345'),
(7, 'Louis Ramirez', '555-6789'),
(8, 'Martha Diaz', '555-0123'),
(9, 'James Vargas', '555-4567'),
(10, 'Paula Torres', '555-8901');

CREATE TABLE `computers` (
  `id` int(11) NOT NULL,
  `serial_number` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `computers` (`id`,`serial_number`, `brand`, `model`, `client_id`) VALUES
(1,'ABC123', 'Dell', 'Inspiron 5000', 1),
(2,'DEF456', 'HP', 'Pavilion x360', 1),
(3,'GHI789', 'Lenovo', 'ThinkPad X1 Carbon', 2),
(4,'JKL012', 'Acer', 'Aspire 5', 2),
(5,'MNO345', 'Apple', 'MacBook Air', 3),
(6,'PQR678', 'Asus', 'ROG Strix G', 3),
(7,'STU901', 'Microsoft', 'Surface Pro 7', 4),
(8,'VWX234', 'Samsung', 'Galaxy Book', 4),
(9,'YZA567', 'Sony', 'VAIO S', 5),
(10,'BCD890', 'Toshiba', 'Satellite Pro', 5),
(11,'EFG123', 'LG', 'Gram 14', 6),
(12,'HIJ456', 'Alienware', 'Area-51m', 6),
(13,'KLM789', 'MSI', 'GS66 Stealth', 7),
(14,'NOP012', 'Razer', 'Blade 15', 7),
(15,'QRS345', 'Huawei', 'MateBook D', 8),
(16,'TUV678', 'Fujitsu', 'Lifebook U939X', 8),
(17,'WXY901', 'Google', 'Pixelbook Go', 9),
(18,'ZAB234', 'Xiaomi', 'Mi Notebook Pro', 10),
(19,'CDE567', 'Gateway', 'Creator Series', 10),
(20,'FGH890', 'Panasonic', 'Toughbook CF-54', 10);

CREATE TABLE `repairs` (
  `id` int(11) NOT NULL,
  `computer_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `description` text NOT NULL,
  `observations` text,
  `date_requested` date NOT NULL,
  `completed` boolean NOT NULL DEFAULT false,
  `date_completed` date,
  `price` decimal(10,2)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Reparaciones para computadoras (25 realizadas, 5 pendientes)
INSERT INTO `repairs` (`id`,`computer_id`, `service_id`, `description`, `observations`, `date_requested`, `completed`, `date_completed`, `price`) VALUES
(1, 1, '4', 'Faulty RAM replacement', 'Customer reported frequent crashes', '2023-01-10', true, '2023-01-15', 120.00),
(2, 1, '1', 'Operating system patch installation', 'Routine update for security', '2023-02-05', true, '2023-02-10', 50.00),
(3, 2, '3', 'Memory expansion', 'Customer requested additional RAM', '2023-03-20', true, '2023-03-25', 80.00),
(4, 2, '4', 'Power supply replacement', 'Computer not turning on', '2023-04-15', true, '2023-04-20', 90.00),
(5, 3, '2', 'Fresh installation of Windows 10', 'Customer wanted a clean OS install', '2023-05-12', true, '2023-05-17', 60.00),
(6, 3, '4', 'Motherboard replacement', 'Component failure after a power surge', '2023-06-08', true, '2023-06-13', 150.00),
(7, 4, '1', 'Application updates', 'Ensuring all software is up to date', '2023-07-01', true, '2023-07-06', 40.00),
(8, 4, '3', 'Installation of SSD', 'Upgrading storage for improved performance', '2023-08-18', true, '2023-08-23', 100.00),
(9, 5, '4', 'Graphics card replacement', 'Customer experienced video artifacting', '2023-09-14', true, '2023-09-19', 130.00),
(10, 6, '1', 'Antivirus definition updates', 'Enhancing security software', '2023-10-03', true, '2023-10-08', 45.00),
(11, 7, '4', 'Cooling fan replacement', 'Computer overheating issues', '2023-11-20', true, '2023-11-25', 75.00),
(12, 7, '2', 'Linux distribution installation', 'Customer wanted to switch to Linux', '2023-12-05', true, '2023-12-10', 55.00),
(13, 7, '4', 'Replacement of faulty hard drive', 'Disk errors reported by the system', '2024-01-22', true, '2024-01-27', 110.00),
(14, 7, '1', 'Browser and application updates', 'Ensuring compatibility and security', '2024-02-14', true, '2024-02-19', 30.00),
(15, 8, '3', 'Installation of additional storage', 'Expanding storage capacity', '2024-03-10', true, '2024-03-15', 85.00),
(16, 9, '4', 'Power button replacement', 'Customer reported non-responsive power button', '2024-04-01', true, '2024-04-06', 95.00),
(17, 10, '1', 'Operating system feature update', 'Customer wanted the latest OS features', '2024-05-18', true, '2024-05-23', 35.00),
(18, 11, '3', 'GPU upgrade for gaming', 'Customer desired improved graphics performance', '2024-06-15', true, '2024-06-20', 120.00),
(19, 12, '4', 'Replacement of damaged screen', 'Cracked screen due to accidental drop', '2024-07-10', true, '2024-07-15', 70.00),
(20, 13, '1', 'Driver updates for peripherals', 'Ensuring all device drivers are up to date', '2024-08-28', true, '2024-09-02', 25.00),
(21, 14, '4', 'Power jack repair', 'Power connection issues reported by the customer', '2024-09-20', true, '2024-09-25', 80.00),
(22, 15, '2', 'macOS reinstallation', 'Customer wanted a clean macOS install', '2024-10-15', true, '2024-10-20', 50.00),
(23, 16, '4', 'Replacement of malfunctioning keyboard', 'Keys not registering properly', '2024-11-05', true, '2024-11-10', 65.00),
(24, 17, '1', 'Security patch installation', 'Critical security update for the operating system', '2024-12-22', true, '2024-12-27', 40.00),
(25, 18,'3', 'Installation of faster processor', 'Improving overall system performance', '2025-01-18', true, '2025-01-23', 110.00),
-- 5 Reparaciones Pendientes
(26, 19, '4', 'WiFi card replacement', 'WiFi connectivity issues reported by the customer', '2025-02-10', false, NULL, NULL),
(27, 20, '1', 'Application-specific updates', 'Updating specific software requested by the customer', '2025-03-05', false, NULL, NULL),
(28, 1, '3', 'Addition of external graphics card', 'Enhancing graphics performance for gaming', '2025-04-01', false, NULL, NULL),
(29, 2, '4', 'Replacement of damaged ports', 'Ports not functioning properly', '2025-05-20', false, NULL, NULL),
(30, 3, '1', 'Firmware updates for peripherals', 'Ensuring firmware is up to date for connected devices', '2025-06-15', false, NULL, NULL);

CREATE TABLE `services` (
  `id` int(11) NOT NULL,
  `service_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `services` (`id`,`service_type`) VALUES
(1,'Software Update'),
(2,'Operating System Reinstallation'),
(3,'Hardware Upgrade'),
(4,'Hardware Repair');


ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `computers`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `repairs`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `services`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `computers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `repairs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `computers`
  ADD CONSTRAINT `CLIENT_ID_FK` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON UPDATE CASCADE;

ALTER TABLE `repairs`
  ADD CONSTRAINT `COMPUTER_ID_FK` FOREIGN KEY (`computer_id`) REFERENCES `computers` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `SERVICE_ID_FK` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`) ON UPDATE CASCADE;


