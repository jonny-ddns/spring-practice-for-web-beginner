CREATE USER 'spring4'@'localhost' IDENTIFIED BY 'spring4';

CREATE DATABASE spring4fs CHARACTER SET=utf8;

GRANT ALL PRIVILEGES ON spring4fs.* TO 'spring4'@'localhost';

CREATE TABLE spring4fs.MEMBER(
	id INT AUTO_INCREMENT PRIMARY KEY
	, email VARCHAR(255)
	, password VARCHAR(100)
	, name VARCHAR(100)
	, regdate DATETIME
	, UNIQUE KEY(email)
) ENGINE=InnoDB CHARACTER SET=utf8;