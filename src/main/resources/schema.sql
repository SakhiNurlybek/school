DROP TABLE IF  EXISTS student;

CREATE TABLE student
(
    id     SERIAL  PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    surname  VARCHAR(100) NOT NULL,
    age INT NOT NULL
);