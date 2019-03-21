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
	bid INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	title VARCHAR(60) NOT NULL,
	author VARCHAR(60) NOT NULL,
	price DOUBLE NOT NULL,
	description VARCHAR(150) NOT NULL,
	publishYear INT NOT NULL,
	review DOUBLE NOT NULL,
	category VARCHAR(32) CHECK (category IN ('Biography', 'Business', 'Fantasy', 'Fiction', 'Food', 'Graphic Novels', 'History', 'Kids', 'Mystery', 'Non-Fiction', 'Science Fiction', 'Textbooks', 'Young Adult')),
	url VARCHAR(10000) NOT NULL,
	PRIMARY KEY(bid)
);



INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Little Prince',
'Suprakash Datta',
180,
'first book of datta... absolutely groundbreaking',
1978,
4.8,
'Fiction',
'https://m.media-amazon.com/images/I/61Zi2jjgfIL._AC_UL436_.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Physics',
'Suprakash Datta',
60,
'second book of datta... took him a long time to write this. are you surprised?',
2017,
3.9,
'Science Fiction',
'https://m.media-amazon.com/images/I/61bQ1w7DshL._AC_UL436_.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Mechanics',
'Russell C. Hibbeler',
100,
'explanation of fundemental concepts of mechanics',
2009,
-1,
'Textbooks',
'https://m.media-amazon.com/images/I/51OWo83vZxL._AC_UL436_.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Mechanics2',
'Russell C. Hibbeler',
110,
'explanation of fundemental concepts of mechanics...again!',
2012,
4,
'Textbooks',
'https://m.media-amazon.com/images/I/51c5tpMjjDL._AC_UL436_.jpg');


