CREATE TABLE teacher(
id INT NOT NULL ,
`name` VARCHAR(20) DEFAULT NULL,
PRIMARY KEY(`id`)
)ENGINE = INNODB DEFAULT CHARSET = utf8

INSERT INTO teacher (id,`name`) VALUES ('1','杜老师')

CREATE TABLE student(
id INT not  NULL,
`name` VARCHAR(20) DEFAULT NULL,
`tid` INT(20) DEFAULT null,
PRIMARY KEY(`id`),
KEY `fktid`(`tid`),
CONSTRAINT `fktid` FOREIGN KEY(`tid`) REFERENCES `teacher` (`id`)

)ENGINE = INNODB DEFAULT CHARSET=utf8

INSERT INTO student (id,`name`,tid) VALUES ('1','小明','1');
INSERT INTO student (id,`name`,tid) VALUES ('2','小红','1');
INSERT INTO student (id,`name`,tid) VALUES ('3','小王','1');
INSERT INTO student (id,`name`,tid) VALUES ('4','小李','1');
INSERT INTO student (id,`name`,tid) VALUES ('5','小刚','1');
