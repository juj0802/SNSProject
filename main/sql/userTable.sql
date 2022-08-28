use mysns;

CREATE TABLE `userInfo` (
  `id` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `regDt` datetime DEFAULT CURRENT_TIMESTAMP,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);