DROP TABLE Users;

CREATE TABLE Users (
	username	VARCHAR(30) NOT NULL,
	email		VARCHAR(30) NOT NULL,
	password	VARCHAR(50) NOT NULL,
	PRIMARY KEY(username)
);

INSERT INTO Users VALUES ('osama', 'omalik91@gmail.com', 'abc123');
INSERT INTO Users VALUES ('ray', 'raymondsbarakat@gmail.com', 'abc123');
INSERT INTO Users VALUES ('baris', 'bbagcilar@gmail.com', 'abc123');

DROP TABLE Books;

CREATE TABLE Books (
	bid VARCHAR(20) NOT NULL,
	title VARCHAR(60) NOT NULL,
	author VARCHAR(60) NOT NULL,
	price INT NOT NULL,
	category VARCHAR(32) CHECK (category IN ('Science', 'Fiction', 'Engineering')),
	url VARCHAR(100) NOT NULL,
	PRIMARY KEY(bid)
);

INSERT INTO Books VALUES ('b001', 'Little Prince', 'datta', 20, 'Fiction', 'a');
INSERT INTO Books VALUES ('b002','Physics', 'datta', 201, 'Science', 'a');
INSERT INTO Books VALUES ('b003','Mechanics', 'datta', 100,'Engineering', 'a');
INSERT INTO Books VALUES ('b004','Mechanics', 'datta', 110,'Engineering', 'b');


