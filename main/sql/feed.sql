
CREATE TABLE `feed` (
  `no` int NOT NULL AUTO_INCREMENT,
  `id` varchar(100) DEFAULT NULL,
  `content` varchar(4096) DEFAULT NULL,
  `regDt` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`)
) 