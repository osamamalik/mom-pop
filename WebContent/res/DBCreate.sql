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