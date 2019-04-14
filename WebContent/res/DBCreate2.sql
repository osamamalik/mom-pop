DROP TABLE Reviews;
DROP TABLE OrderDetails;
DROP TABLE Orders;
DROP TABLE Cart;
DROP TABLE Books;
DROP TABLE Address;
DROP TABLE Users;

CREATE TABLE Books (
	bid INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	title VARCHAR(250) NOT NULL,
	author VARCHAR(120) NOT NULL,
	price DOUBLE NOT NULL,
	description VARCHAR(2500) NOT NULL,
	publishYear INT NOT NULL,
	rating DOUBLE NOT NULL,
	category VARCHAR(32) CHECK (category IN ('Biography', 'Fantasy', 'Fiction', 'Food', 'Graphic Novels', 'History', 'Childrens', 'Mystery', 'Non-Fiction', 'Science Fiction', 'Young Adult')),
	url VARCHAR(10000) NOT NULL,
	PRIMARY KEY(bid)
);

CREATE TABLE Users (
	username	VARCHAR(30) NOT NULL,
	fname		VARCHAR(30) NOT NULL,
	lname		VARCHAR(30) NOT NULL,
	email		VARCHAR(30) NOT NULL,
	password	VARCHAR(50) NOT NULL,
	PRIMARY KEY(username)
);

INSERT INTO Users VALUES ('osama', 'Osama', 'Malik', 'omalik91@gmail.com', 'abc123');
INSERT INTO Users VALUES ('ray', 'Raymond', 'Barakat', 'raymondsbarakat@gmail.com', 'abc123');
INSERT INTO Users VALUES ('baris', 'Baris', 'Bagcilar', 'bbagcilar@gmail.com', 'abc123');
INSERT INTO Users VALUES ('admin', 'admin', 'admin', 'admin@gmail.com', 'admin');

CREATE TABLE Address (
	aid INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	username	VARCHAR(30) NOT NULL,
	address_type VARCHAR(8) CHECK (address_type IN ('shipping', 'billing')),
	line1 VARCHAR(100) NOT NULL,
	line2 VARCHAR(100),
	country VARCHAR(20) NOT NULL,
	province VARCHAR(20) NOT NULL,
	city VARCHAR(30) NOT NULL,
	zip VARCHAR(20) NOT NULL,
	phone VARCHAR(20),
	PRIMARY KEY(aid),
	CONSTRAINT address_username_ref FOREIGN KEY (username) REFERENCES Users (username)
);


INSERT INTO Address (username, address_type, line1, line2, country, province, city, zip, phone) VALUES ('osama', 'shipping', '1 shipping lanes', 'unit #1', 'Canada', 'ON', 'Toronto', 'M11P11', '111-11-11');
INSERT INTO Address (username, address_type, line1, line2, country, province, city, zip, phone) VALUES ('osama', 'billing', '1 billing lanes', 'unit #1', 'Canada', 'ON', 'Toronto', 'M11P11', '111-11-11');
INSERT INTO Address (username, address_type, line1, line2, country, province, city, zip, phone) VALUES ('ray', 'shipping', '2 shipping lanes', 'unit #2', 'Canada', 'ON', 'Toronto', 'M22P22', '222-11-11');
INSERT INTO Address (username, address_type, line1, line2, country, province, city, zip, phone) VALUES ('ray', 'billing', '2 billing lanes', 'unit #2', 'Canada', 'ON', 'Toronto', 'M22P22', '222-11-11');
INSERT INTO Address (username, address_type, line1, line2, country, province, city, zip, phone) VALUES ('baris', 'shipping', '3 shipping lanes', 'unit #3', 'Canada', 'ON', 'Toronto', 'M33P33', '333-11-11');
INSERT INTO Address (username, address_type, line1, line2, country, province, city, zip, phone) VALUES ('baris', 'billing', '3 billing lanes', 'unit #3', 'Canada', 'ON', 'Toronto', 'M33P33', '333-11-11');

CREATE TABLE Cart (
	cid INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	username VARCHAR(30) NOT NULL,
	bid INT NOT NULL,
	quantity INT NOT NULL,
	PRIMARY KEY (cid),
	CONSTRAINT cart_bid_ref FOREIGN KEY (bid) REFERENCES Books (bid)
);


CREATE TABLE Reviews (
	rid INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	username VARCHAR(30) NOT NULL,
	bid INT NOT NULL,
	review VARCHAR(2500) NOT NULL,
	rating INT NOT NULL,
	PRIMARY KEY (rid),
	CONSTRAINT reviews_bid_ref FOREIGN KEY (bid) REFERENCES Books (bid),
	CONSTRAINT reviews_username_ref FOREIGN KEY (username) REFERENCES Users (username)
);


CREATE TABLE Orders (
	oid INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	odate DATE NOT NULL,
	username VARCHAR(30) NOT NULL,
	PRIMARY KEY (oid),
	CONSTRAINT orders_username_ref FOREIGN KEY (username) REFERENCES Users (username)
);

CREATE TABLE OrderDetails (
	odid INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	oid INT NOT NULL,
	bid INT NOT NULL,
	quantity INT NOT NULL,
	shippingAid INT NOT NULL,
	billingAid INT NOT NULL,
	PRIMARY KEY (odid),
	CONSTRAINT orderdetails_oid_ref FOREIGN KEY (oid) REFERENCES Orders (oid),
	CONSTRAINT orderdetails_bid_ref FOREIGN KEY (bid) REFERENCES Books (bid),
	CONSTRAINT orderdetails_shippingAddressid_ref FOREIGN KEY (shippingAid) REFERENCES Address (aid),
	CONSTRAINT orderdetails_billingAddressid_ref FOREIGN KEY (billingAid) REFERENCES Address (aid)

);


INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Steve Jobs',
'Walter Isaacson',
30.25,
'From the author of the bestselling biographies of Benjamin Franklin and Albert Einstein, this is the exclusive, New York Times bestselling biography of Apple co-founder Steve Jobs.
Based on more than forty interviews with Jobs conducted over two years—as well as interviews with more than a hundred family members, friends, adversaries, competitors, and colleagues—Walter Isaacson has written a riveting story of the roller-coaster life and searingly intense personality of a creative entrepreneur whose passion for perfection and ferocious drive revolutionized six industries: personal computers, animated movies, music, phones, tablet computing, and digital publishing.
At a time when America is seeking ways to sustain its innovative edge, and when societies around the world are trying to build digital-age economies, Jobs stands as the ultimate icon of inventiveness and applied imagination. He knew that the best way to create value in the twenty-first century was to connect creativity with technology. He built a company where leaps of the imagination were combined with remarkable feats of engineering.',
2011,
4.12,
'Biography',
'https://images.gr-assets.com/books/1511288482l/11084145.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Diary of a Young Girl',
'Anne Frank',
8.09,
'Anne Frank''s extraordinary diary, written in the Amsterdam attic where she and her family hid from the Nazis for two years, has become a world classic and a timeless testament to the human spirit. Now, in a new edition enriched by many passages originally withheld by her father, we meet an Anne more real, more human, and more vital than ever. Here she is first and foremost a teenage girl—stubbornly honest, touchingly vulnerable, in love with life. She imparts her deeply secret world of soul-searching and hungering for affection, rebellious clashes with her mother, romance and newly discovered sexuality, and wry, candid observations of her companions. Facing hunger, fear of discovery and death, and the petty frustrations of such confined quarters, Anne writes with adult wisdom and views beyond her years. Her story is that of every teenager, lived out in conditions few teenagers have ever known.',
1993,
4.12,
'Biography',
'https://images.gr-assets.com/books/1537075718l/48855.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Unbroken: A World War II Story of Survival, Resilience and Redemption',
'Laura Hillenbrand',
20.99,
'In her long-awaited new book, Laura Hillenbrand writes with the same rich and vivid narrative voice she displayed in Seabiscuit. Telling an unforgettable story of a man''s journey into extremity, Unbroken is a testament to the resilience of the human mind, body, and spirit.
On a May afternoon in 1943, an Army Air Forces bomber crashed into the Pacific Ocean and disappeared, leaving only a spray of debris and a slick of oil, gasoline, and blood. Then, on the ocean surface, a face appeared. It was that of a young lieutenant, the plane''s bombardier, who was struggling to a life raft and pulling himself aboard. So began one of the most extraordinary odysseys of the Second World War.
The lieutenant’s name was Louis Zamperini. In boyhood, he''d been a cunning and incorrigible delinquent, breaking into houses, brawling, and fleeing his home to ride the rails. As a teenager, he had channeled his defiance into running, discovering a prodigious talent that had carried him to the Berlin Olympics and within sight of the four-minute mile. But when war had come, the athlete had become an airman, embarking on a journey that led to his doomed flight, a tiny raft, and a drift into the unknown.
Ahead of Zamperini lay thousands of miles of open ocean, leaping sharks, a foundering raft, thirst and starvation, enemy aircraft, and, beyond, a trial even greater. Driven to the limits of endurance, Zamperini would answer desperation with ingenuity; suffering with hope, resolve, and humor; brutality with rebellion. His fate, whether triumph or tragedy, would be suspended on the fraying wire of his will.',
2010,
4.38,
'Biography',
'https://images.gr-assets.com/books/1327861115l/8664353.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'John Adams',
'David McCullough',
16.86,
'The enthralling, often surprising story of John Adams, one of the most important and fascinating Americans who ever lived.
In this powerful, epic biography, David McCullough unfolds the adventurous life-journey of John Adams, the brilliant, fiercely independent, often irascible, always honest Yankee patriot - "the colossus of independence," as Thomas Jefferson called him - who spared nothing in his zeal for the American Revolution- who rose to become the second President of the United States and saved the country from blundering into an unnecessary war- who was learned beyond all but a few and regarded by some as "out of his senses"- and whose marriage to the wise and valiant Abigail Adams is one of the moving love stories in American history. 
Like his masterly, Pulitzer Prize-winning biography Truman, David McCullough''s John Adams has the sweep and vitality of a great novel. It is both a riveting portrait of an abundantly human man and a vivid evocation of his time, much of it drawn from an outstanding collection of Adams family letters and diaries. In particular, the more than one thousand surviving letters between John and Abigail Adams, nearly half of which have never been published, provide extraordinary access to their private lives and make it possible to know John Adams as no other major American of his founding era.',
2001,
4.06,
'Biography',
'https://images.gr-assets.com/books/1478144278l/2203.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Bossypants',
'Tina Fey',
18.87,
'Before Liz Lemon, before "Weekend Update," before "Sarah Palin," Tina Fey was just a young girl with a dream: a recurring stress dream that she was being chased through a local airport by her middle-school gym teacher. She also had a dream that one day she would be a comedian on TV.
She has seen both these dreams come true.
At last, Tina Fey''s story can be told. From her youthful days as a vicious nerd to her tour of duty on Saturday Night Live; from her passionately halfhearted pursuit of physical beauty to her life as a mother eating things off the floor; from her one-sided college romance to her nearly fatal honeymoon—from the beginning of this paragraph to this final sentence.
Tina Fey reveals all, and proves what we''ve all suspected: you''re no one until someone calls you bossy.',
2011,
3.95,
'Biography',
'https://images.gr-assets.com/books/1481509554l/9418327.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Alexander Hamilton',
'Ron Chernow',
23.40,
'Pulitzer Prize-winning author Ron Chernow presents a landmark biography of Alexander Hamilton, the Founding Father who galvanized, inspired, scandalized, and shaped the newborn nation.
In the first full-length biography of Alexander Hamilton in decades, Ron Chernow tells the riveting story of a man who overcame all odds to shape, inspire, and scandalize the newborn America. According to historian Joseph Ellis, Alexander Hamilton is “a robust full-length portrait, in my view the best ever written, of the most brilliant, charismatic and dangerous founder of them all.�?',
2005,
4.24,
'Biography',
'https://images.gr-assets.com/books/1436131915l/16130.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Einstein: His Life and Universe',
'Walter Isaacson',
10.30,
'Einstein was a rebel and nonconformist from boyhood days, and these character traits drove both his life and his science. In this narrative, Walter Isaacson explains how his mind worked and the mysteries of the universe that he discovered.',
2007,
4.10,
'Biography',
'https://images.gr-assets.com/books/1328011405l/10884.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future',
'Ashlee Vance',
27.54,
'Elon Musk, the entrepreneur and innovator behind SpaceX, Tesla, and SolarCity, sold one of his internet companies, PayPal, for $1.5 billion. Ashlee Vance captures the full spectacle and arc of the genius''s life and work, from his tumultuous upbringing in South Africa and flight to the United States to his dramatic technical innovations and entrepreneurial pursuits. Vance uses Musk''s story to explore one of the pressing questions of our age: can the nation of inventors and creators who led the modern world for a century still compete in an age of fierce global competition? He argues that Musk is an amalgam of legendary inventors and industrialists including Thomas Edison, Henry Ford, Howard Hughes, and Steve Jobs. More than any other entrepreneur today, Musk has dedicated his energies and his own vast fortune to inventing a future that is as rich and far-reaching as the visionaries of the golden age of science-fiction fantasy',
2015,
4.23,
'Biography',
'https://images.gr-assets.com/books/1518291452l/25541028.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Into the Wild',
'Jon Krakauer',
18.00,
'In April 1992 a young man from a well-to-do family hitchhiked to Alaska and walked alone into the wilderness north of Mt. McKinley. His name was Christopher Johnson McCandless. He had given $25,000 in savings to charity, abandoned his car and most of his possessions, burned all the cash in his wallet, and invented a new life for himself. Four months later, a party of moose hunters found his decomposed body. How McCandless came to die is the unforgettable story of Into the Wild.
Immediately after graduating from college in 1991, McCandless had roamed through the West and Southwest on a vision quest like those made by his heroes Jack London and John Muir. In the Mojave Desert he abandoned his car, stripped it of its license plates, and burned all of his cash. He would give himself a new name, Alexander Supertramp, and, unencumbered by money and belongings, he would be free to wallow in the raw, unfiltered experiences that nature presented. Craving a blank spot on the map, McCandless simply threw away the maps. Leaving behind his desperate parents and sister, he vanished into the wild.',
1997,
3.97,
'Biography',
'https://images.gr-assets.com/books/1403173986l/1845.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Autobiography of Malcolm X',
'Malcolm X',
9.89,
'Through a life of passion and struggle, Malcolm X became one of the most influential figures of the 20th Century. In this riveting account, he tells of his journey from a prison cell to Mecca, describing his transition from hoodlum to Muslim minister. Here, the man who called himself "the angriest Black man in America" relates how his conversion to true Islam helped him confront his rage and recognize the brotherhood of all mankind. 
An established classic of modern America, "The Autobiography of Malcolm X" was hailed by the New York Times as "Extraordinary. A brilliant, painful, important book." Still extraordinary, still important, this electrifying story has transformed Malcom X''s life into his legacy. The strength of his words, the power of his ideas continue to resonate more than a generation after they first appeared.',
1965,
4.30,
'Biography',
'https://images.gr-assets.com/books/1434682864l/92057.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Benjamin Franklin: An American Life',
'Walter Isaacson',
27.29,
'Benjamin Franklin is the Founding Father who winks at us. An ambitious urban entrepreneur who rose up the social ladder, from leather-aproned shopkeeper to dining with kings, he seems made of flesh rather than of marble. In bestselling author Walter Isaacson''s vivid and witty full-scale biography, we discover why Franklin seems to turn to us from history''s stage with eyes that twinkle from behind his new-fangled spectacles. By bringing Franklin to life, Isaacson shows how he helped to define both his own time and ours.
He was, during his 84-year life, America''s best scientist, inventor, diplomat, writer, and business strategist, and he was also one of its most practical—though not most profound—political thinkers. He proved by flying a kite that lightning was electricity, and he invented a rod to tame it. He sought practical ways to make stoves less smoky and commonwealths less corrupt. He organized neighborhood constabularies and international alliances, local lending libraries and national legislatures. He combined two types of lenses to create bifocals and two concepts of representation to foster the nation''s federal compromise. He was the only man who shaped all the founding documents of America: the Albany Plan of Union, the Declaration of Independence, the treaty of alliance with France, the peace treaty with England, and the Constitution. And he helped invent America''s unique style of homespun humor, democratic values, and philosophical pragmatism.',
2003,
3.98,
'Biography',
'https://images.gr-assets.com/books/1397772877l/10883.jpg');


INSERT INTO Cart (username, bid, quantity) VALUES('osama', 1, 1);
INSERT INTO Cart (username, bid, quantity) VALUES('osama', 2, 2);
INSERT INTO Cart (username, bid, quantity) VALUES('osama', 3, 3);
INSERT INTO Cart (username, bid, quantity) VALUES('ray', 4, 1);
INSERT INTO Cart (username, bid, quantity) VALUES('ray', 5, 2);
INSERT INTO Cart (username, bid, quantity) VALUES('ray', 6, 3);
INSERT INTO Cart (username, bid, quantity) VALUES('baris', 7, 1);
INSERT INTO Cart (username, bid, quantity) VALUES('baris', 8, 2);
INSERT INTO Cart (username, bid, quantity) VALUES('baris', 9, 3);

INSERT INTO Reviews (username, bid, review, rating) VALUES(
'osama',
1,
'I must admit that I do not like Apple and was never a fan of Jobs but when I saw that his biography was on a must read list online, I decided to open my heart to this book. When I started reading it, I was a little close-minded to Steve Jobs story but as I advanced his personality grew on me and I actually started laughing and caring about who he was as a person, almost as if he were a friend...this book made me care about Steve job''s life and legacy because it gave me a different perspective on him. I was aware that he was deceased when I began exploring his biography but as I finished I could not help but cry for I knew that he was not part of the world anymore...but one of the last sentences of the book....truly made me laugh and this helped with the sadness.

I believe this book should be read by anyone really, to learn from it in many ways and experience the good sides of Steve Jobs instead of just the bad things that were constantly said about him. He is someone who had a big impact on the 21st century and brought our society into a more advanced technological world. Thank you, Steve Jobs, and for all you contributed to our world, your legacy will live on forever!',
4.5
);
