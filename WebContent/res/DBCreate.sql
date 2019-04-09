DROP TABLE Reviews;
DROP TABLE OrderDetails;
DROP TABLE Orders;
DROP TABLE Cart;
DROP TABLE Users;
DROP TABLE Books;

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

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Steve Jobs',
'Walter Isaacson',
30.25,
'From the author of the bestselling biographies of Benjamin Franklin and Albert Einstein, this is the exclusive, New York Times bestselling biography of Apple co-founder Steve Jobs.

Based on more than forty interviews with Jobs conducted over two yearsÃ¢â‚¬â€�as well as interviews with more than a hundred family members, friends, adversaries, competitors, and colleaguesÃ¢â‚¬â€�Walter Isaacson has written a riveting story of the roller-coaster life and searingly intense personality of a creative entrepreneur whose passion for perfection and ferocious drive revolutionized six industries: personal computers, animated movies, music, phones, tablet computing, and digital publishing.

At a time when America is seeking ways to sustain its innovative edge, and when societies around the world are trying to build digital-age economies, Jobs stands as the ultimate icon of inventiveness and applied imagination. He knew that the best way to create value in the twenty-first century was to connect creativity with technology. He built a company where leaps of the imagination were combined with remarkable feats of engineering.',
2011,
4.12,
'Biography',
'https://images.gr-assets.com/books/1511288482l/11084145.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Diary of a Young Girl',
'Anne Frank',
8.09,
'Anne Frank''s extraordinary diary, written in the Amsterdam attic where she and her family hid from the Nazis for two years, has become a world classic and a timeless testament to the human spirit. Now, in a new edition enriched by many passages originally withheld by her father, we meet an Anne more real, more human, and more vital than ever. Here she is first and foremost a teenage girlÃ¢â‚¬â€�stubbornly honest, touchingly vulnerable, in love with life. She imparts her deeply secret world of soul-searching and hungering for affection, rebellious clashes with her mother, romance and newly discovered sexuality, and wry, candid observations of her companions. Facing hunger, fear of discovery and death, and the petty frustrations of such confined quarters, Anne writes with adult wisdom and views beyond her years. Her story is that of every teenager, lived out in conditions few teenagers have ever known.',
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
The lieutenantÃ¢â‚¬â„¢s name was Louis Zamperini. In boyhood, he''d been a cunning and incorrigible delinquent, breaking into houses, brawling, and fleeing his home to ride the rails. As a teenager, he had channeled his defiance into running, discovering a prodigious talent that had carried him to the Berlin Olympics and within sight of the four-minute mile. But when war had come, the athlete had become an airman, embarking on a journey that led to his doomed flight, a tiny raft, and a drift into the unknown.

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

At last, Tina Fey''s story can be told. From her youthful days as a vicious nerd to her tour of duty on Saturday Night Live; from her passionately halfhearted pursuit of physical beauty to her life as a mother eating things off the floor; from her one-sided college romance to her nearly fatal honeymoonÃ¢â‚¬â€�from the beginning of this paragraph to this final sentence.

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

In the first full-length biography of Alexander Hamilton in decades, Ron Chernow tells the riveting story of a man who overcame all odds to shape, inspire, and scandalize the newborn America. According to historian Joseph Ellis, Alexander Hamilton is Ã¢â‚¬Å“a robust full-length portrait, in my view the best ever written, of the most brilliant, charismatic and dangerous founder of them all.Ã¢â‚¬ï¿½',
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

He was, during his 84-year life, America''s best scientist, inventor, diplomat, writer, and business strategist, and he was also one of its most practicalÃ¢â‚¬â€�though not most profoundÃ¢â‚¬â€�political thinkers. He proved by flying a kite that lightning was electricity, and he invented a rod to tame it. He sought practical ways to make stoves less smoky and commonwealths less corrupt. He organized neighborhood constabularies and international alliances, local lending libraries and national legislatures. He combined two types of lenses to create bifocals and two concepts of representation to foster the nation''s federal compromise. He was the only man who shaped all the founding documents of America: the Albany Plan of Union, the Declaration of Independence, the treaty of alliance with France, the peace treaty with England, and the Constitution. And he helped invent America''s unique style of homespun humor, democratic values, and philosophical pragmatism.',
2003,
3.98,
'Biography',
'https://images.gr-assets.com/books/1397772877l/10883.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Black Leopard, Red Wolf',
'Marlon James',
27.29,
'Tracker is known far and wide for his skills as a hunter: "He has a nose," people say. Engaged to track down a mysterious boy who disappeared three years earlier, Tracker breaks his own rule of always working alone when he finds himself part of a group that comes together to search for the boy. The band is a hodgepodge, full of unusual characters with secrets of their own, including a shape-shifting man-animal known as Leopard.

As Tracker follows the boy''s scentÃ¢â‚¬â€�from one ancient city to another; into dense forests and across deep riversÃ¢â‚¬â€�he and the band are set upon by creatures intent on destroying them. As he struggles to survive, Tracker starts to wonder: Who, really, is this boy? Why has he been missing for so long? Why do so many people want to keep Tracker from finding him? And perhaps the most important questions of all: Who is telling the truth, and who is lying?

Drawing from African history and mythology and his own rich imagination, Marlon James has written a saga of breathtaking adventure that''s also an ambitious, involving read. Defying categorization and full of unforgettable characters, Black Leopard, Red Wolf is both surprising and profound as it explores the fundamentals of truths, the limits of power, the excesses of ambition, and our need to understand them all.',
2019,
3.70,
'Fantasy',
'https://images.gr-assets.com/books/1538656386l/40524312.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Harry Potter and the Sorcerer''s Stone',
'J.K. Rowling',
43.52,
'Harry Potter''s life is miserable. His parents are dead and he''s stuck with his heartless relatives, who force him to live in a tiny closet under the stairs. But his fortune changes when he receives a letter that tells him the truth about himself: he''s a wizard. A mysterious visitor rescues him from his relatives and takes him to his new home, Hogwarts School of Witchcraft and Wizardry.

After a lifetime of bottling up his magical powers, Harry finally feels like a normal kid. But even within the Wizarding community, he is special. He is the boy who lived: the only person to have ever survived a killing curse inflicted by the evil Lord Voldemort, who launched a brutal takeover of the Wizarding world, only to vanish after failing to kill Harry.

Though Harry''s first year at Hogwarts is the best of his life, not everything is perfect. There is a dangerous secret object hidden within the castle walls, and Harry believes it''s his responsibility to prevent it from falling into evil hands. But doing so will bring him into contact with forces more terrifying than he ever could have imagined.

Full of sympathetic characters, wildly imaginative situations, and countless exciting details, the first installment in the series assembles an unforgettable magical world and sets the stage for many high-stakes adventures to come.',
1997,
4.46,
'Fantasy',
'https://images.gr-assets.com/books/1474154022l/3.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Harry Potter and the Chamber of Secrets',
'J.K. Rowling',
31.14,
'The Dursleys were so mean and hideous that summer that all Harry Potter wanted was to get back to the Hogwarts School for Witchcraft and Wizardry. But just as he''s packing his bags, Harry receives a warning from a strange, impish creature named Dobby who says that if Harry Potter returns to Hogwarts, disaster will strike',
1998,
4.41,
'Fantasy',
'https://images-na.ssl-images-amazon.com/images/I/51OihdkhSBL._SX329_BO1,204,203,200_.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Harry Potter and the Prisoner of Azkaban',
'J.K. Rowling',
1.40,
'Harry Potter''s third year at Hogwarts is full of new dangers. A convicted murderer, Sirius Black, has broken out of Azkaban prison, and it seems he''s after Harry. Now Hogwarts is being patrolled by the dementors, the Azkaban guards who are hunting Sirius. But Harry can''t imagine that Sirius or, for that matter, the evil Lord Voldemort could be more frightening than the dementors themselves, who have the terrible power to fill anyone they come across with aching loneliness and despair. Meanwhile, life continues as usual at Hogwarts. A top-of-the-line broom takes Harry''s success at Quidditch, the sport of the Wizarding world, to new heights. A cute fourth-year student catches his eye. And he becomes close with the new Defense of the Dark Arts teacher, who was a childhood friend of his father. Yet despite the relative safety of life at Hogwarts and the best efforts of the dementors, the threat of Sirius Black grows ever closer. But if Harry has learned anything from his education in wizardry, it is that things are often not what they seem. Tragic revelations, heartwarming surprises, and high-stakes magical adventures await the boy wizard in this funny and poignant third installment of the beloved series.',
1999,
4.55,
'Fantasy',
'https://images.gr-assets.com/books/1499277281l/5.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Harry Potter and the Goblet of Fire',
'J.K. Rowling',
17.53,
'Harry Potter is midway through his training as a wizard and his coming of age. Harry wants to get away from the pernicious Dursleys and go to the International Quidditch Cup. He wants to find out about the mysterious event that''s supposed to take place at Hogwarts this year, an event involving two other rival schools of magic, and a competition that hasn''t happened for a hundred years. He wants to be a normal, fourteen-year-old wizard. But unfortunately for Harry Potter, he''s not normal - even by wizarding standards. And in his case, different can be deadly.',
2000,
4.55,
'Fantasy',
'https://images.gr-assets.com/books/1361482611l/6.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Harry Potter and the Order of the Phoenix',
'J.K. Rowling',
18.45,
'There is a door at the end of a silent corridor. And itÃ¢â‚¬â„¢s haunting Harry PottterÃ¢â‚¬â„¢s dreams. Why else would he be waking in the middle of the night, screaming in terror?

Harry has a lot on his mind for this, his fifth year at Hogwarts: a Defense Against the Dark Arts teacher with a personality like poisoned honey- a big surprise on the Gryffindor Quidditch team- and the looming terror of the Ordinary Wizarding Level exams. But all these things pale next to the growing threat of He-Who-Must-Not-Be-Named---a threat that neither the magical government nor the authorities at Hogwarts can stop.

As the grasp of darkness tightens, Harry must discover the true depth and strength of his friends, the importance of boundless loyalty, and the shocking price of unbearable sacrifice.

His fate depends on them all.',
2003,
4.48,
'Fantasy',
'https://images.gr-assets.com/books/1546910265l/2.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Harry Potter and the Half-Blood Prince',
'J.K. Rowling',
14.91,
'When Harry Potter and the Half-Blood Prince opens, the war against Voldemort has begun. The Wizarding world has split down the middle, and as the casualties mount, the effects even spill over onto the Muggles. Dumbledore is away from Hogwarts for long periods, and the Order of the Phoenix has suffered grievous losses. And yet, as in all wars, life goes on.

Harry, Ron, and Hermione, having passed their O.W.L. level exams, start on their specialist N.E.W.T. courses. Sixth-year students learn to Apparate, losing a few eyebrows in the process. Teenagers flirt and fight and fall in love. Harry becomes captain of the Gryffindor Quidditch team, while Draco Malfoy pursues his own dark ends. And classes are as fascinating and confounding as ever, as Harry receives some extraordinary help in Potions from the mysterious Half-Blood Prince.

Most importantly, Dumbledore and Harry work together to uncover the full and complex story of a boy once named Tom RiddleÃ¢â‚¬â€�the boy who became Lord Voldemort. Like Harry, he was the son of one Muggle-born and one Wizarding parent, raised unloved, and a speaker of Parseltongue. But the similarities end there, as the teenaged Riddle became deeply interested in the Dark objects known as Horcruxes: objects in which a wizard can hide part of his soul, if he dares splinter that soul through murder.

Harry must use all the tools at his disposal to draw a final secret out of one of RiddleÃ¢â‚¬â„¢s teachers, the sly Potions professor Horace Slughorn. Finally Harry and Dumbledore hold the key to the Dark LordÃ¢â‚¬â„¢s weaknesses... until a shocking reversal exposes DumbledoreÃ¢â‚¬â„¢s own vulnerabilities, and casts HarryÃ¢â‚¬â„¢sÃ¢â‚¬â€�and HogwartsÃ¢â‚¬â„¢sÃ¢â‚¬â€�future in shadow.',
2005,
4.56,
'Fantasy',
'https://images.gr-assets.com/books/1361039191l/1.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Harry Potter and the Deathly Hallows',
'J.K. Rowling',
33.52,
'Harry Potter is leaving Privet Drive for the last time. But as he climbs into the sidecar of HagridÃ¢â‚¬â„¢s motorbike and they take to the skies, he knows Lord Voldemort and the Death Eaters will not be far behind.

The protective charm that has kept him safe until now is broken. But the Dark Lord is breathing fear into everything he loves. And he knows he canÃ¢â‚¬â„¢t keep hiding.

To stop Voldemort, Harry knows he must find the remaining Horcruxes and destroy them.

He will have to face his enemy in one final battle.',
2007,
4.63,
'Fantasy',
'https://images.gr-assets.com/books/1474171184l/136251.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'A Game of Thrones',
'George R.R. Martin',
4.98,
'Here is the first volume in George R. R. MartinÃ¢â‚¬â„¢s magnificent cycle of novels that includes A Clash of Kings and A Storm of Swords. As a whole, this series comprises a genuine masterpiece of modern fantasy, bringing together the best the genre has to offer. Magic, mystery, intrigue, romance, and adventure fill these pages and transport us to a world unlike any we have ever experienced. Already hailed as a classic, George R. R. MartinÃ¢â‚¬â„¢s stunning series is destined to stand as one of the great achievements of imaginative fiction.

A GAME OF THRONES

Long ago, in a time forgotten, a preternatural event threw the seasons out of balance. In a land where summers can last decades and winters a lifetime, trouble is brewing. The cold is returning, and in the frozen wastes to the north of Winterfell, sinister and supernatural forces are massing beyond the kingdomÃ¢â‚¬â„¢s protective Wall. At the center of the conflict lie the Starks of Winterfell, a family as harsh and unyielding as the land they were born to. Sweeping from a land of brutal cold to a distant summertime kingdom of epicurean plenty, here is a tale of lords and ladies, soldiers and sorcerers, assassins and bastards, who come together in a time of grim omens.

Here an enigmatic band of warriors bear swords of no human metal- a tribe of fierce wildlings carry men off into madness- a cruel young dragon prince barters his sister to win back his throne- and a determined woman undertakes the most treacherous of journeys. Amid plots and counterplots, tragedy and betrayal, victory and terror, the fate of the Starks, their allies, and their enemies hangs perilously in the balance, as each endeavors to win that deadliest of conflicts: the game of thrones.',
1996,
4.45,
'Fantasy',
'https://images.gr-assets.com/books/1436732693l/13496.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'A Clash of Kings',
'George R.R. Martin',
19.36,
'A comet the color of blood and flame cuts across the sky. Two great leadersÃ¢â‚¬â€�Lord Eddard Stark and Robert BaratheonÃ¢â‚¬â€�who hold sway over an age of enforced peace are dead, victims of royal treachery. Now, from the ancient citadel of Dragonstone to the forbidding shores of Winterfell, chaos reigns. Six factions struggle for control of a divided land and the Iron Throne of the Seven Kingdoms, preparing to stake their claims through tempest, turmoil, and war. 

It is a tale in which brother plots against brother and the dead rise to walk in the night. Here a princess masquerades as an orphan boy- a knight of the mind prepares a poison for a treacherous sorceress- and wild men descend from the Mountains of the Moon to ravage the countryside. Against a backdrop of incest and fratricide, alchemy and murder, victory may go to the men and women possessed of the coldest steel...and the coldest hearts. For when kings clash, the whole land trembles.

Here is the second volume in George R.R. Martin magnificent cycle of novels that includes A Game of Thrones and A Storm of Swords. As a whole, this series comprises a genuine masterpiece of modern fantasy, bringing together the best the genre has to offer. Magic, mystery, intrigue, romance, and adventure fill these pages and transport us to a world unlike any we have ever experienced. Already hailed as a classic, George R.R. Martin stunning series is destined to stand as one of the great achievements of imaginative fiction.',
1998,
4.41,
'Fantasy',
'https://images.gr-assets.com/books/1358254974l/10572.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'A Storm of Swords',
'George R.R. Martin',
8.36,
'Here is the third volume in George R.R. Martin''s magnificent cycle of novels that includes A Game of Thrones and A Clash of Kings. Together, this series comprises a genuine masterpiece of modern fantasy, destined to stand as one of the great achievements of imaginative fiction.

Of the five contenders for power, one is dead, another in disfavor, and still the wars rage as alliances are made and broken. Joffrey sits on the Iron Throne, the uneasy ruler of the Seven Kingdoms. His most bitter rival, Lord Stannis, stands defeated and disgraced, victim of the sorceress who holds him in her thrall. Young Robb still rules the North from the fortress of Riverrun. Meanwhile, making her way across a blood-drenched continent is the exiled queen, Daenerys, mistress of the only three dragons still left in the world. And as opposing forces manoeuver for the final showdown, an army of barbaric wildlings arrives from the outermost limits of civilization, accompanied by a horde of mythical OthersÃ¢â‚¬â€�a supernatural army of the living dead whose animated corpses are unstoppable. As the future of the land hangs in the balance, no one will rest until the Seven Kingdoms have exploded in a veritable storm of swords...',
2000,
4.54,
'Fantasy',
'https://images.gr-assets.com/books/1396958446l/13253102.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'A Feast for Crows',
'George R.R. Martin',
8.15,
'Crows will fight over a dead man''s flesh, and kill each other for his eyes.

Bloodthirsty, treacherous and cunning, the Lannisters are in power on the Iron Throne in the name of the boy-king Tommen. The war in the Seven Kingdoms has burned itself out, but in its bitter aftermath new conflicts spark to life.

The Martells of Dorne and the Starks of Winterfell seek vengeance for their dead. Euron Crow''s Eye, as black a pirate as ever raised a sail, returns from the smoking ruins of Valyria to claim the Iron Isles. From the icy north, where Others threaten the Wall, apprentice Maester Samwell Tarly brings a mysterious babe in arms to the Citadel.

Against a backdrop of incest and fratricide, alchemy and murder, victory will go to the men and women possessed of the coldest steel and the coldest hearts.',
2005,
4.12,
'Fantasy',
'https://images.gr-assets.com/books/1429538615l/13497.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'A Dance with Dragons',
'George R.R. Martin',
8.22,
'In the aftermath of a colossal battle, the future of the Seven Kingdoms hangs in the balanceÃ¢â‚¬â€�beset by newly emerging threats from every direction. In the east, Daenerys Targaryen, the last scion of House Targaryen, rules with her three dragons as queen of a city built on dust and death. But Daenerys has thousands of enemies, and many have set out to find her. As they gather, one young man embarks upon his own quest for the queen, with an entirely different goal in mind.

Fleeing from Westeros with a price on his head, Tyrion Lannister, too, is making his way to Daenerys. But his newest allies in this quest are not the rag-tag band they seem, and at their heart lies one who could undo DaenerysÃ¢â‚¬â„¢s claim to Westeros forever.

Meanwhile, to the north lies the mammoth Wall of ice and stoneÃ¢â‚¬â€�a structure only as strong as those guarding it. There, Jon Snow, 998th Lord Commander of the NightÃ¢â‚¬â„¢s Watch, will face his greatest challenge. For he has powerful foes not only within the Watch but also beyond, in the land of the creatures of ice.

From all corners, bitter conflicts reignite, intimate betrayals are perpetrated, and a grand cast of outlaws and priests, soldiers and skinchangers, nobles and slaves, will face seemingly insurmountable obstacles. Some will fail, others will grow in the strength of darkness. But in a time of rising restlessness, the tides of destiny and politics will lead inevitably to the greatest dance of all.',
2011,
4.32,
'Fantasy',
'https://images.gr-assets.com/books/1327885335l/10664113.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'American Gods',
'Neil Gaiman',
21.21,
'Days before his release from prison, Shadow''s wife, Laura, dies in a mysterious car crash. Numbly, he makes his way back home. On the plane, he encounters the enigmatic Mr Wednesday, who claims to be a refugee from a distant war, a former god and the king of America.

Together they embark on a profoundly strange journey across the heart of the USA, whilst all around them a storm of preternatural and epic proportions threatens to break.

Scary, gripping and deeply unsettling, American Gods takes a long, hard look into the soul of America. You''ll be surprised by what - and who - it finds there...',
2001,
2.98,
'Fantasy',
'https://images.gr-assets.com/books/1462924585l/30165203.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The City in the Middle of the Night',
'Charlie Jane Anders',
31.49,
'"If you control our sleep, then you can own our dreams... And from there, it''s easy to control our entire lives." 

Set on a planet that has fully definitive, never-changing zones of day and night, with ensuing extreme climates of endless, frigid darkness and blinding, relentless light, humankind has somehow continued apace -- though the perils outside the built cities are rife with danger as much as the streets below.

But in a world where time means only what the ruling government proclaims, and the levels of light available are artificially imposed to great consequence, lost souls and disappeared bodies are shadow-bound and savage, and as common as grains of sand. And one such pariah, sacrificed to the night, but borne up by time and a mysterious bond with an enigmatic beast, will rise to take on the entire planet - before it can crumble beneath the weight of human existence.',
2019,
3.77,
'Science Fiction',
'https://images.gr-assets.com/books/1532447389l/37534907.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Dark Matter',
'Blake Crouch',
29.70,
'Ã¢â‚¬Å“Are you happy with your life?Ã¢â‚¬ï¿½ 

Those are the last words Jason Dessen hears before the masked abductor knocks him unconscious. 

Before he awakens to find himself strapped to a gurney, surrounded by strangers in hazmat suits. 

Before a man JasonÃ¢â‚¬â„¢s never met smiles down at him and says, Ã¢â‚¬Å“Welcome back, my friend.Ã¢â‚¬ï¿½ 

In this world heÃ¢â‚¬â„¢s woken up to, JasonÃ¢â‚¬â„¢s life is not the one he knows. His wife is not his wife. His son was never born. And Jason is not an ordinary college physics professor, but a celebrated genius who has achieved something remarkable. Something impossible.

Is it this world or the other thatÃ¢â‚¬â„¢s the dream? And even if the home he remembers is real, how can Jason possibly make it back to the family he loves? The answers lie in a journey more wondrous and horrifying than anything he couldÃ¢â‚¬â„¢ve imaginedÃ¢â‚¬â€�one that will force him to confront the darkest parts of himself even as he battles a terrifying, seemingly unbeatable foe.

From the author of the bestselling Wayward Pines trilogy, Dark Matter is a brilliantly plotted tale that is at once sweeping and intimate, mind-bendingly strange and profoundly humanÃ¢â‚¬â€�a relentlessly surprising science-fiction thriller about choices, paths not taken, and how far weÃ¢â‚¬â„¢ll go to claim the lives we dream of.',
2016,
4.10,
'Science Fiction',
'https://images.gr-assets.com/books/1472119680l/27833670.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Martian',
'Andy Weir',
25.80,
'Six days ago, astronaut Mark Watney became one of the first people to walk on Mars. 

Now, heÃ¢â‚¬â„¢s sure heÃ¢â‚¬â„¢ll be the first person to die there.

After a dust storm nearly kills him and forces his crew to evacuate while thinking him dead, Mark finds himself stranded and completely alone with no way to even signal Earth that heÃ¢â‚¬â„¢s aliveÃ¢â‚¬â€�and even if he could get word out, his supplies would be gone long before a rescue could arrive. 

Chances are, though, he wonÃ¢â‚¬â„¢t have time to starve to death. The damaged machinery, unforgiving environment, or plain-old Ã¢â‚¬Å“human errorÃ¢â‚¬ï¿½ are much more likely to kill him first. 

But Mark isnÃ¢â‚¬â„¢t ready to give up yet. Drawing on his ingenuity, his engineering skills Ã¢â‚¬â€� and a relentless, dogged refusal to quit Ã¢â‚¬â€� he steadfastly confronts one seemingly insurmountable obstacle after the next. Will his resourcefulness be enough to overcome the impossible odds against him?',
2012,
4.40,
'Science Fiction',
'https://images.gr-assets.com/books/1413706054l/18007564.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Ready Player One',
'Ernest Cline',
26.70,
'In the year 2045, reality is an ugly place. The only time teenage Wade Watts really feels alive is when he''s jacked into the virtual utopia known as the OASIS. Wade''s devoted his life to studying the puzzles hidden within this world''s digital confines, puzzles that are based on their creator''s obsession with the pop culture of decades past and that promise massive power and fortune to whoever can unlock them. When Wade stumbles upon the first clue, he finds himself beset by players willing to kill to take this ultimate prize. The race is on, and if Wade''s going to survive, he''ll have to winÃ¢â‚¬â€�and confront the real world he''s always been so desperate to escape.',
2011,
1.87,
'Science Fiction',
'https://images.gr-assets.com/books/1500930947l/9969571.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Ender''s Game',
'Orson Scott Card',
8.99,
'Andrew ''Ender'' Wiggin thinks he is playing computer simulated war games; he is, in fact, engaged in something far more desperate. The result of genetic experimentation, Ender may be the military genius Earth desperately needs in a war against an alien enemy seeking to destroy all human life. The only way to find out is to throw Ender into ever harsher training, to chip away and find the diamond inside, or destroy him utterly. Ender Wiggin is six years old when it begins. He will grow up fast.

But Ender is not the only result of the experiment. The war with the Buggers has been raging for a hundred years, and the quest for the perfect general has been underway almost as long. Ender''s two older siblings, Peter and Valentine, are every bit as unusual as he is, but in very different ways. While Peter was too uncontrollably violent, Valentine very nearly lacks the capability for violence altogether. Neither was found suitable for the military''s purpose. But they are driven by their jealousy of Ender, and by their inbred drive for power. Peter seeks to control the political process, to become a ruler. Valentine''s abilities turn more toward the subtle control of the beliefs of commoner and elite alike, through powerfully convincing essays. Hiding their youth and identities behind the anonymity of the computer networks, these two begin working together to shape the destiny of Earth-an Earth that has no future at all if their brother Ender fails.',
1985,
4.30,
'Science Fiction',
'https://images.gr-assets.com/books/1408303130l/375802.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Man in the High Castle',
'Philip K. Dick',
2.65,
'It''s America in 1962. Slavery is legal once again. The few Jews who still survive hide under assumed names. In San Francisco, the I Ching is as common as the Yellow Pages. All because some twenty years earlier the United States lost a warÃ¢â‚¬â€�and is now occupied by Nazi Germany and Japan.

This harrowing, Hugo Award-winning novel is the work that established Philip K. Dick as an innovator in science fiction while breaking the barrier between science fiction and the serious novel of ideas. In it Dick offers a haunting vision of history as a nightmare from which it may just be possible to wake.',
1962,
2.42,
'Science Fiction',
'https://images.gr-assets.com/books/1448756803l/216363.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Artemis',
'Andy Weir',
24.88,
'Jazz Bashara is a criminal.

Well, sort of. Life on Artemis, the first and only city on the moon, is tough if you''re not a rich tourist or an eccentric billionaire. So smuggling in the occasional harmless bit of contraband barely counts, right? Not when you''ve got debts to pay and your job as a porter barely covers the rent.

Everything changes when Jazz sees the chance to commit the perfect crime, with a reward too lucrative to turn down. But pulling off the impossible is just the start of her problems, as she learns that she''s stepped square into a conspiracy for control of Artemis itselfÃ¢â‚¬â€�and that now, her only chance at survival lies in a gambit even riskier than the first.',
2017,
3.34,
'Science Fiction',
'https://images.gr-assets.com/books/1494273579l/34928122.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Never Let Me Go',
'Kazuo Ishiguro',
18.70,
'From the Booker Prize-winning author of The Remains of the Day and When We Were Orphans, comes an unforgettable edge-of-your-seat mystery that is at once heartbreakingly tender and morally courageous about what it means to be human.

Hailsham seems like a pleasant English boarding school, far from the influences of the city. Its students are well tended and supported, trained in art and literature, and become just the sort of people the world wants them to be. But, curiously, they are taught nothing of the outside world and are allowed little contact with it.

Within the grounds of Hailsham, Kathy grows from schoolgirl to young woman, but itÃ¢â‚¬â„¢s only when she and her friends Ruth and Tommy leave the safe grounds of the school (as they always knew they would) that they realize the full truth of what Hailsham is.

Never Let Me Go breaks through the boundaries of the literary novel. It is a gripping mystery, a beautiful love story, and also a scathing critique of human arrogance and a moral examination of how we treat the vulnerable and different in our society. In exploring the themes of memory and the impact of the past, Ishiguro takes on the idea of a possible future to create his most moving and powerful book to date.',
2005,
3.81,
'Science Fiction',
'https://images.gr-assets.com/books/1353048590l/6334.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Road',
'Cormac McCarthy',
26.99,
'A searing, postapocalyptic novel destined to become Cormac McCarthyÃ¢â‚¬â„¢s masterpiece.

A father and his son walk alone through burned America. Nothing moves in the ravaged landscape save the ash on the wind. It is cold enough to crack stones, and when the snow falls it is gray. The sky is dark. Their destination is the coast, although they donÃ¢â‚¬â„¢t know what, if anything, awaits them there. They have nothing- just a pistol to defend themselves against the lawless bands that stalk the road, the clothes they are wearing, a cart of scavenged foodÃ¢â‚¬â€�and each other.

The Road is the profoundly moving story of a journey. It boldly imagines a future in which no hope remains, but in which the father and his son, Ã¢â‚¬Å“each the otherÃ¢â‚¬â„¢s world entire,Ã¢â‚¬ï¿½ are sustained by love. Awesome in the totality of its vision, it is an unflinching meditation on the worst and the best that we are capable of: ultimate destructiveness, desperate tenacity, and the tenderness that keeps two people alive in the face of total devastation.',
2006,
3.96,
'Science Fiction',
'https://images.gr-assets.com/books/1439197219l/6288.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Dead Wake: The Last Crossing of the Lusitania',
'Erik Larson',
14.53,
'On May 1, 1915, with WWI entering its tenth month, a luxury ocean liner as richly appointed as an English country house sailed out of New York, bound for Liverpool, carrying a record number of children and infants. The passengers were surprisingly at ease, even though Germany had declared the seas around Britain to be a war zone. For months, German U-boats had brought terror to the North Atlantic. But the Lusitania was one of the eraÃ¢â‚¬â„¢s great transatlantic Ã¢â‚¬Å“GreyhoundsÃ¢â‚¬ï¿½Ã¢â‚¬â€�the fastest liner then in serviceÃ¢â‚¬â€�and her captain, William Thomas Turner, placed tremendous faith in the gentlemanly strictures of warfare that for a century had kept civilian ships safe from attack. 

Germany, however, was determined to change the rules of the game, and Walther Schwieger, the captain of Unterseeboot-20, was happy to oblige. Meanwhile, an ultra-secret British intelligence unit tracked SchwiegerÃ¢â‚¬â„¢s U-boat, but told no one. As U-20 and the Lusitania made their way toward Liverpool, an array of forces both grand and achingly smallÃ¢â‚¬â€�hubris, a chance fog, a closely guarded secret, and moreÃ¢â‚¬â€�all converged to produce one of the great disasters of history.

It is a story that many of us think we know but donÃ¢â‚¬â„¢t, and Erik Larson tells it thrillingly, switching between hunter and hunted while painting a larger portrait of America at the height of the Progressive Era. Full of glamour and suspense, Dead Wake brings to life a cast of evocative characters, from famed Boston bookseller Charles Lauriat to pioneering female architect Theodate Pope to President Woodrow Wilson, a man lost to grief, dreading the widening war but also captivated by the prospect of new love. 

Gripping and important, Dead Wake captures the sheer drama and emotional power of a disaster whose intimate details and true meaning have long been obscured by history.',
2015,
2.5,
'History',
'https://images.gr-assets.com/books/1454880537l/28686819.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Rise and Fall of the Third Reich: A History of Nazi Germany',
'William L. Shirer',
13.06,
'Hitler boasted that The Third Reich would last a thousand years. It lasted only 12. But those 12 years contained some of the most catastrophic events Western civilization has ever known.
No other powerful empire ever bequeathed such mountains of evidence about its birth and destruction as the Third Reich. When the bitter war was over, and before the Nazis could destroy their files, the Allied demand for unconditional surrender produced an almost hour-by-hour record of the nightmare empire built by Adolph Hitler. This record included the testimony of Nazi leaders and of concentration camp inmates, the diaries of officials, transcripts of secret conferences, army orders, private lettersÃ¢â‚¬â€�all the vast paperwork behind Hitler''s drive to conquer the world.

The famed foreign correspondent and historian William L. Shirer, who had watched and reported on the Nazis since 1925, spent five and a half years sifting through this massive documentation. The result is a monumental study that has been widely acclaimed as the definitive record of one of the most frightening chapters in the history of mankind.

This worldwide bestseller has been acclaimed as the definitive book on Nazi Germany; it is a classic work.

The accounts of how the United States got involved and how Hitler used Mussolini and Japan are astonishing, and the coverage of the war-from Germany''s early successes to her eventual defeat-is must reading',
1960,
4.16,
'History',
'https://images.gr-assets.com/books/1331223772l/767171.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'As a Man Thinketh',
'James Allen',
9.30,
'Just as a gardener cultivates his plot, keeping it free from weeds, and growing the flowers and fruits which he requires, so may a man tend the garden of his mind, weeding out all the wrong, useless, and impure thoughts, and cultivating toward perfection, the flowers and fruits of right, useful, and pure thoughts. By pursuing this process, a man sooner or later discovers that he is the master-gardener of his soul, the director of his life. He also reveals, within himself, the laws
of thought, and understands, with ever-increasing accuracy, how the thought-forces and mindelements operate in the shaping of his
character, circumstances, and destiny',
1902,
1.29,
'Non-Fiction',
'https://images.gr-assets.com/books/1479862643l/33098919.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Way of the Fight',
'Georges St-Pierre',
49.00,
'UFC fighter, Georges Ã¢â‚¬Å“RushÃ¢â‚¬ï¿½ St. Pierre, shares the lessons he learned on his way to the top, in The Way of the Fight, revealing how he overcame bullying and injury to become an internationally celebrated athlete and champion.

The reigning UFC welterweight champion, St. Pierre seemed untouchable until injury derailed him and jeopardized his title and his career. Determined to make his comeback, he embarked on a careful regimen of physical therapy. He also used this healing period to assess his life, where he''s been, what he''s achieved, where he wants to go, and and lessons that helped shape who he is.

In The Way of the Fight, Canadian championship fighter St. Pierre invites fans into the circle of his life, sharing his most closely guarded memories. A compelling memoir that offers an intimate, gritty look at a fighterÃ¢â‚¬â„¢s journey, told through inspiring vignettes, GSP is a moving account of commitment and power, achievement and pain, dedication and conviction from one of the world''s greatest champions.',
2013,
3.98,
'Biography',
'https://images.gr-assets.com/books/1394405620l/17886840.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Call Me By Your Name',
'AndrÃƒÂ© Aciman',
4.18,
'Call Me by Your Name is the story of a sudden and powerful romance that blossoms between an adolescent boy and a summer guest at his parents'' cliff-side mansion on the Italian Riviera. Unprepared for the consequences of their attraction, at first each feigns indifference. But during the restless summer weeks that follow, unrelenting buried currents of obsession and fear, fascination and desire, intensify their passion as they test the charged ground between them. What grows from the depths of their spirits is a romance of scarcely six weeks'' duration and an experience that marks them for a lifetime. For what the two discover on the Riviera and during a sultry evening in Rome is the one thing both already fear they may never truly find again: total intimacy.

The psychological maneuvers that accompany attraction have seldom been more shrewdly captured than in AndrÃƒÂ© Aciman''s frank, unsentimental, heartrending elegy to human passion. Call Me by Your Name is clear-eyed, bare-knuckled, and ultimately unforgettable.',
2007,
2.68,
'Fiction',
'https://images.gr-assets.com/books/1519203520l/36336078.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Thirteen Days in September: Carter, Begin, and Sadat at Camp David',
'Lawrence Wright',
5.64,
'A gripping day-by-day account of the 1978 Camp David conference, when President Jimmy Carter persuaded Israeli prime minister Menachem Begin and Egyptian president Anwar Sadat to sign the first peace treaty in the modern Middle East, one which endures to this day.

With his hallmark insight into the forces at play in the Middle East and his acclaimed journalistic skill, Lawrence Wright takes us through each of the thirteen days of the Camp David conference, illuminating the issues that have made the problems of the region so intractable, as well as exploring the scriptural narratives that continue to frame the conflict. In addition to his in-depth accounts of the lives of the three leaders, Wright draws vivid portraits of other fiery personalities who were present at Camp DavidÃ¢â‚¬â€œÃ¢â‚¬â€œincluding Moshe Dayan, Osama el-Baz, and Zbigniew BrzezinskiÃ¢â‚¬â€œÃ¢â‚¬â€œas they work furiously behind the scenes. Wright also explores the significant role played by Rosalynn Carter. 
What emerges is a riveting view of the making of this unexpected and so far unprecedented peace. Wright exhibits the full extent of CarterÃ¢â‚¬â„¢s persistence in pushing an agreement forward, the extraordinary way in which the participants at the conferenceÃ¢â‚¬â€�many of them lifelong enemiesÃ¢â‚¬â€�attained it, and the profound difficulties inherent in the process and its outcome, not the least of which has been the still unsettled struggle between the Israelis and the Palestinians.

In Thirteen Days in September, Wright gives us a resonant work of history and reportage that provides both a timely revisiting of this important diplomatic triumph and an inside look at how peace is made.',
2014,
4.15,
'History',
'https://images.gr-assets.com/books/1408925868l/21965079.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'A Higher Loyalty: Truth, Lies, and Leadership',
'James Comey',
23.85,
'Former FBI Director James Comey shares his never-before-told experiences from some of the highest-stakes situations of his career in the past two decades of American government, exploring what good, ethical leadership looks like, and how it drives sound decisions. His journey provides an unprecedented entry into the corridors of power, and a remarkable lesson in what makes an effective leader.

Mr. Comey served as Director of the FBI from 2013 to 2017, appointed to the post by President Barack Obama. He previously served as U.S. attorney for the Southern District of New York, and the U.S. deputy attorney general in the administration of President George W. Bush. From prosecuting the Mafia and Martha Stewart to helping change the Bush administration''s policies on torture and electronic surveillance, overseeing the Hillary Clinton e-mail investigation as well as ties between the Trump campaign and Russia, Comey has been involved in some of the most consequential cases and policies of recent history.',
2018,
4.21,
'Biography',
'https://images.gr-assets.com/books/1509630796l/35108805.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Fire and Fury: Inside the Trump White House',
'Michael Wolff',
22.93,
'With extraordinary access to the West Wing, Michael Wolff reveals what happened behind-the-scenes in the first nine months of the most controversial presidency of our time in Fire and Fury: Inside the Trump White House.

Since Donald Trump was sworn in as the 45th President of the United States, the countryÃ¢â‚¬â€¢and the worldÃ¢â‚¬â€¢has witnessed a stormy, outrageous, and absolutely mesmerizing presidential term that reflects the volatility and fierceness of the man elected Commander-in-Chief.

This riveting and explosive account of TrumpÃ¢â‚¬â„¢s administration provides a wealth of new details about the chaos in the Oval Office',
2018,
2.77,
'Non-Fiction',
'https://images.gr-assets.com/books/1514994130l/36595101.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'A Darker Shade of Magic',
'V.E. Schwab',
27.61,
'Kell is one of the last AntariÃ¢â‚¬â€�magicians with a rare, coveted ability to travel between parallel Londons- Red, Grey, White, and, once upon a time, Black. 

Kell was raised in ArnesÃ¢â‚¬â€�Red LondonÃ¢â‚¬â€�and officially serves the Maresh Empire as an ambassador, traveling between the frequent bloody regime changes in White London and the court of George III in the dullest of Londons, the one without any magic left to see.

Unofficially, Kell is a smuggler, servicing people willing to pay for even the smallest glimpses of a world they''ll never see. It''s a defiant hobby with dangerous consequences, which Kell is now seeing firsthand.

After an exchange goes awry, Kell escapes to Grey London and runs into Delilah Bard, a cut-purse with lofty aspirations. She first robs him, then saves him from a deadly enemy, and finally forces Kell to spirit her to another world for a proper adventure.

Now perilous magic is afoot, and treachery lurks at every turn. To save all of the worlds, they''ll first need to stay alive.',
2015,
4.09,
'Fantasy',
'https://images.gr-assets.com/books/1400322851l/22055262.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'A Gathering of Shadows',
'V.E. Schwab',
32.85,
'It has been four months since a mysterious obsidian stone fell into Kell''s possession. Four months since his path crossed with Delilah Bard. Four months since Prince Rhy was wounded, and since the nefarious Dane twins of White London fell, and four months since the stone was cast with Holland''s dying body through the rift--back into Black London.

Now, restless after having given up his smuggling habit, Kell is visited by dreams of ominous magical events, waking only to think of Lila, who disappeared from the docks as she always meant to do. As Red London finalizes preparations for the Element Games--an extravagant international competition of magic meant to entertain and keep healthy the ties between neighboring countries--a certain pirate ship draws closer, carrying old friends back into port.

And while Red London is caught up in the pageantry and thrills of the Games, another London is coming back to life. After all, a shadow that was gone in the night will reappear in the morning. But the balance of magic is ever perilous, and for one city to flourish, another London must fall.',
2016,
1.51,
'Fantasy',
'https://images.gr-assets.com/books/1429627728l/20764879.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'King Leopold''s Ghost',
'Adam Hochschild',
20.80,
'In the 1880s, as the European powers were carving up Africa, King Leopold II of Belgium seized for himself the vast and mostly unexplored territory surrounding the Congo River. Carrying out a genocidal plundering of the Congo, he looted its rubber, brutalized its people, and ultimately slashed its population by ten millionÃ¢â‚¬â€�all the while shrewdly cultivating his reputation as a great humanitarian. Heroic efforts to expose these crimes eventually led to the first great human rights movement of the twentieth century, in which everyone from Mark Twain to the Archbishop of Canterbury participated. King Leopold''s Ghost is the haunting account of a megalomaniac of monstrous proportions, a man as cunning, charming, and cruel as any of the great Shakespearean villains. It is also the deeply moving portrait of those who fought Leopold: a brave handful of missionaries, travelers, and young idealists who went to Africa for work or adventure and unexpectedly found themselves witnesses to a holocaust. Adam Hochschild brings this largely untold story alive with the wit and skill of a Barbara Tuchman. Like her, he knows that history often provides a far richer cast of characters than any novelist could invent. Chief among them is Edmund Morel, a young British shipping agent who went on to lead the international crusade against Leopold. Another hero of this tale, the Irish patriot Roger Casement, ended his life on a London gallows. Two courageous black Americans, George Washington Williams and William Sheppard, risked much to bring evidence of the Congo atrocities to the outside world. Sailing into the middle of the story was a young Congo River steamboat officer named Joseph Conrad. And looming above them all, the duplicitous billionaire King Leopold II. With great power and compassion, King Leopold''s Ghost will brand the tragedy of the CongoÃ¢â‚¬â€�too long forgottenÃ¢â‚¬â€�onto the conscience of the West.',
1998,
4.15,
'History',
'https://images.gr-assets.com/books/1348621563l/347610.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Friends of Eddie Coyle',
'George V. Higgins',
33.78,
'Eddie Coyle works for Jimmy Scalisi, supplying him with guns for a couple of bank jobs. But a cop named Foley is on to Eddie and he''s leaning on him to finger Scalisi, a gang leader with a lot to hide. And then there''s Dillon-a full-time bartender and part-time contract killer--pretending to be Eddie''s friend. Wheeling, dealing, chasing, and stealing-that''s Eddie, and he''s got lots of friends.',
1970,
1.81,
'Fiction',
'https://images.gr-assets.com/books/1171012318l/82121.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Kite Runner',
'Khaled Hosseini',
12.99,
'Ã¢â‚¬Å“It may be unfair, but what happens in a few days, sometimes even a single day, can change the course of a whole lifetime." 

Amir is the son of a wealthy Kabul merchant, a member of the ruling caste of Pashtuns. Hassan, his servant and constant companion, is a Hazara, a despised and impoverished caste. Their uncommon bond is torn by Amir''s choice to abandon his friend amidst the increasing ethnic, religious, and political tensions of the dying years of the Afghan monarchy, wrenching them far apart. But so strong is the bond between the two boys that Amir journeys back to a distant world, to try to right past wrongs against the only true friend he ever had.

The unforgettable, heartbreaking story of the unlikely friendship between a wealthy boy and the son of his fatherÃ¢â‚¬â„¢s servant, The Kite Runner is a beautifully crafted novel set in a country that is in the process of being destroyed. It is about the power of reading, the price of betrayal, and the possibility of redemption; and an exploration of the power of fathers over sonsÃ¢â‚¬â€�their love, their sacrifices, their lies.

A sweeping story of family, love, and friendship told against the devastating backdrop of the history of Afghanistan over the last thirty years, The Kite Runner is an unusual and powerful novel that has become a beloved, one-of-a-kind classic.',
2003,
4.68,
'Fiction',
'https://images.gr-assets.com/books/1546093833l/77203.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Revolution Was Televised: The Cops, Crooks, Slingers and Slayers Who Changed TV Drama Forever',
'Alan Sepinwall',
19.03,
'A mob boss in therapy. An experimental, violent prison unit. The death of an American city, as seen through a complex police investigation. A lawless frontier town trying to talk its way into the United States. A corrupt cop who rules his precinct like a warlord. The survivors of a plane crash trying to make sense of their disturbing new island home. A high school girl by day, monster fighter by night. A spy who never sleeps. A space odyssey inspired by 9/11. An embattled high school football coach. A polished ad exec with a secret. A chemistry teacher turned drug lord.

These are the subjects of 12 shows that started a revolution in TV drama: The Sopranos. Oz. The Wire. Deadwood. The Shield. Lost. Buffy the Vampire Slayer. 24. Battlestar Galactica. Friday Night Lights. Mad Men. Breaking Bad.

These 12 shows, and the many more they made possible, ushered in a new golden age of television Ã¢â‚¬â€� one that made people take the medium more seriously than ever before. Alan Sepinwall became a TV critic right before this creative revolution began, was there to chronicle this incredible moment in pop culture history, and along the way Ã¢â‚¬Å“changed the nature of television criticism,Ã¢â‚¬ï¿½ according to Slate. The Revolution Was Televised is the story of these 12 shows, as told by Sepinwall and the people who made them, including David Chase, David Simon, David Milch, Damon Lindelof and Carlton Cuse, Vince Gilligan and more.',
2012,
3.12,
'Non-Fiction',
'https://images.gr-assets.com/books/1470071246l/31310052.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Rook',
'Daniel O''Malley',
18.51,
'"The body you are wearing used to be mine." So begins the letter Myfanwy Thomas is holding when she awakes in a London park surrounded by bodies all wearing latex gloves. With no recollection of who she is, Myfanwy must follow the instructions her former self left behind to discover her identity and track down the agents who want to destroy her. 

She soon learns that she is a Rook, a high-ranking member of a secret organization called the Chequy that battles the many supernatural forces at work in Britain. She also discovers that she possesses a rare, potentially deadly supernatural ability of her own. 

In her quest to uncover which member of the Chequy betrayed her and why, Myfanwy encounters a person with four bodies, an aristocratic woman who can enter her dreams, a secret training facility where children are transformed into deadly fighters, and a conspiracy more vast than she ever could have imagined.

Filled with characters both fascinating and fantastical, THE ROOK is a richly inventive, suspenseful, and often wry thriller that marks an ambitious debut from a promising young writer.',
2012,
3.98,
'Fantasy',
'https://images.gr-assets.com/books/1392570607l/13528319.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Bastard of Istanbul',
'Elif Shafak',
14.99,
'From one of TurkeyÃ¢â‚¬â„¢s most acclaimed and outspoken writers, a novel about the tangled histories of two families.

In her second novel written in English, Elif Shafak confronts her countryÃ¢â‚¬â„¢s violent past in a vivid and colorful tale set in both Turkey and the United States. At its center is the Ã¢â‚¬Å“bastardÃ¢â‚¬ï¿½ of the title, Asya, a nineteen-year-old woman who loves Johnny Cash and the French Existentialists, and the four sisters of the Kazanci family who all live together in an extended household in Istanbul: Zehila, the zestful, headstrong youngest sister who runs a tattoo parlor and is AsyaÃ¢â‚¬â„¢s mother- Banu, who has newly discovered herself as a clairvoyant; Cevriye, a widowed high school teacher; and Feride, a hypochondriac obsessed with impending disaster. Their one estranged brother lives in Arizona with his wife and her Armenian daughter, Armanoush. When Armanoush secretly flies to Istanbul in search of her identity, she finds the Kazanci sisters and becomes fast friends with Asya. A secret is uncovered that links the two families and ties them to the 1915 Armenian deportations and massacres. Full of vigorous, unforgettable female characters, The Bastard of Istanbul is a bold, powerful tale that will confirm Shafak as a rising star of international fiction.',
2006,
3.81,
'Fiction',
'https://images.gr-assets.com/books/1309282092l/98920.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Complete Maus',
'Art Spiegelman',
21.37,
'Combined for the first time here are Maus I: A Survivor''s Tale and Maus II - the complete story of Vladek Spiegelman and his wife, living and surviving in Hitler''s Europe. By addressing the horror of the Holocaust through cartoons, the author captures the everyday reality of fear and is able to explore the guilt, relief and extraordinary sensation of survival - and how the children of survivors are in their own way affected by the trials of their parents. A contemporary classic of immeasurable significance.',
1986,
3.55,
'Graphic Novels',
'https://images.gr-assets.com/books/1327354180l/15195.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'13 Things Mentally Strong People Don''t Do: Take Back Your Power, Embrace Change, Face Your Fears, and Train Your Brain for Happiness and Success',
'Amy Morin',
34.72,
'Expanding on her viral post that has become an international phenomenon, a psychotherapist offers simple yet effective solutions for increasing mental strength and finding happiness and success in life.

As a licensed clinical social worker, college psychology instructor, and psychotherapist, Amy Morin has seen countless people choose to succeed despite facing enormous challenges. That resilience inspired her to write 13 Things Mentally Strong People Don''t Do, a web post that instantly went viral, and was picked up by the Forbes website.

Morin''s post focused on the concept of mental strength, how mentally strong people avoid negative behaviors-feeling sorry for themselves, resenting other people''s success, and dwelling on the past. Instead, they focus on the positive to help them overcome challenges and become their best.

In this inspirational, affirmative book, Morin expands upon her original message, providing practical strategies to help readers avoid the thirteen common habits that can hold them back from success. Combining compelling anecdotal stories with the latest psychological research, she offers strategies for avoiding destructive thoughts, emotions, and behaviors common to everyone.

Like physical strength, mental strength requires healthy habits, exercise, and hard work. Morin teaches you how to embrace a happier outlook and arms you to emotionally deal with life''s inevitable hardships, setbacks, and heartbreaks--sharing for the first time her own poignant story of tragedy, and how she summoned the mental strength to move on. As she makes clear, mental strength isn''t about acting tough; it''s about feeling empowered to overcome life''s challenges.',
2014,
3.24,
'Non-Fiction',
'https://images.gr-assets.com/books/1421012364l/23215490.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Coraline',
'Neil Gaiman',
8.99,
'When Coraline steps through a door to find another house strangely similar to her own (only better), things seem marvelous.

But there''s another mother there, and another father, and they want her to stay and be their little girl. They want to change her and never let her go.

Coraline will have to fight with all her wits and courage if she is to save herself and return to her ordinary life.',
2002,
4.05,
'Childrens',
'https://images.gr-assets.com/books/1493497528l/589836.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Homegoing',
'Yaa Gyasi',
16.96,
'Effia and Esi: two sisters with two very different destinies. One sold into slavery; one a slave trader''s wife. The consequences of their fate reverberate through the generations that follow. Taking us from the Gold Coast of Africa to the cotton-picking plantations of Mississippi; from the missionary schools of Ghana to the dive bars of Harlem, spanning three continents and seven generations, Yaa Gyasi has written a miraculous novel - the intimate, gripping story of a brilliantly vivid cast of characters and through their lives the very story of America itself.

Epic in its canvas and intimate in its portraits, Homegoing is a searing and profound debut from a masterly new writer.',
2016,
4.42,
'Fiction',
'https://images.gr-assets.com/books/1465020516l/30347641.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Power of Habit: Why We Do What We Do in Life and Business',
'Charles Duhigg',
34.80,
'A young woman walks into a laboratory. Over the past two years, she has transformed almost every aspect of her life. She has quit smoking, run a marathon, and been promoted at work. The patterns inside her brain, neurologists discover, have fundamentally changed.

Marketers at Procter & Gamble study videos of people making their beds. They are desperately trying to figure out how to sell a new product called Febreze, on track to be one of the biggest flops in company history. Suddenly, one of them detects a nearly imperceptible patternÃ¢â‚¬â€�and with a slight shift in advertising, Febreze goes on to earn a billion dollars a year.

An untested CEO takes over one of the largest companies in America. His first order of business is attacking a single pattern among his employeesÃ¢â‚¬â€�how they approach worker safetyÃ¢â‚¬â€�and soon the firm, Alcoa, becomes the top performer in the Dow Jones.

What do all these people have in common? They achieved success by focusing on the patterns that shape every aspect of our lives. 

They succeeded by transforming habits.',
2012,
2.66,
'Non-Fiction',
'https://images.gr-assets.com/books/1545854312l/12609433.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Lawrence in Arabia: War, Deceit, Imperial Folly, and the Making of the Modern Middle East',
'Scott Anderson',
5.30,
'A thrilling and revelatory narrative of one of the most epic and consequential periods in 20th century history Ã¢â‚¬â€œ the Arab Revolt and the secret Ã¢â‚¬Å“great gameÃ¢â‚¬ï¿½ to control the Middle East
       
The Arab Revolt against the Turks in World War One was, in the words of T.E. Lawrence, Ã¢â‚¬Å“a sideshow of a sideshow.Ã¢â‚¬ï¿½  Amidst the slaughter in European trenches, the Western combatants paid scant attention to the Middle Eastern theater.  As a result, the conflict was shaped to a remarkable degree by a small handful of adventurers and low-level officers far removed from the corridors of power.  
 
Curt PrÃƒÂ¼fer was an effete academic attached to the German embassy in Cairo, whose clandestine role was to foment Islamic jihad against British rule.  Aaron Aaronsohn was a renowned agronomist and committed Zionist who gained the trust of the Ottoman governor of Syria. William Yale was the fallen scion of the American aristocracy, who traveled the Ottoman Empire on behalf of Standard Oil, dissembling to the Turks in order gain valuable oil concessions.  At the center of it all was Lawrence.  In early 1914 he was an archaeologist excavating ruins in the sands of Syria- by 1917 he was the most romantic figure of World War One, battling both the enemy and his own government to bring about the vision he had for the Arab people.
 
The intertwined paths of these four men Ã¢â‚¬â€œ the schemes they put in place, the battles they fought, the betrayals they endured and committed Ã¢â‚¬â€œ mirror the grandeur, intrigue and tragedy of the war in the desert.  PrÃƒÂ¼fer became GermanyÃ¢â‚¬â„¢s grand spymaster in the Middle East.  Aaronsohn constructed an elaborate Jewish spy-ring in Palestine, only to have the anti-Semitic and bureaucratically-inept British first ignore and then misuse his organization, at tragic personal cost.  Yale would become the only American intelligence agent in the entire Middle East Ã¢â‚¬â€œ while still secretly on the payroll of Standard Oil.  And the enigmatic Lawrence rode into legend at the head of an Arab army, even as he waged secret war against his own nationÃ¢â‚¬â„¢s imperial ambitions.
 
Based on years of intensive primary document research, LAWRENCE IN ARABIA definitively overturns received wisdom on how the modern Middle East was formed.  Sweeping in its action, keen in its portraiture, acid in its condemnation of the destruction wrought by European colonial plots, this is a book that brilliantly captures the way in which the folly of the past creates the anguish of the present.',
2013,
4.84,
'History',
'https://images.gr-assets.com/books/1363837257l/17262206.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'But What If We''re Wrong? Thinking About the Present As If It Were the Past',
'Chuck Klosterman',
27.25,
'We live in a culture of casual certitude. This has always been the case, no matter how often that certainty has failed. Though no generation believes thereÃ¢â‚¬â„¢s nothing left to learn, every generation unconsciously assumes that what has already been defined and accepted is (probably) pretty close to how reality will be viewed in perpetuity. And then, of course, time passes. Ideas shift. Opinions invert. What once seemed reasonable eventually becomes absurd, replaced by modern perspectives that feel even more irrefutable and secureÃ¢â‚¬â€�until, of course, they donÃ¢â‚¬â„¢t.

But What If WeÃ¢â‚¬â„¢re Wrong? visualizes the contemporary world as it will appear to those who''ll perceive it as the distant past. Chuck Klosterman asks questions that are profound in their simplicity: How certain are we about our understanding of gravity? How certain are we about our understanding of time? What will be the defining memory of rock music, five hundred years from today? How seriously should we view the content of our dreams? How seriously should we view the content of television? Are all sports destined for extinction? Is it possible that the greatest artist of our era is currently unknown (orÃ¢â‚¬â€�weirder stillÃ¢â‚¬â€�widely known, but entirely disrespected)? Is it possible that we Ã¢â‚¬Å“overrateÃ¢â‚¬ï¿½ democracy? And perhaps most disturbing, is it possible that weÃ¢â‚¬â„¢ve reached the end of knowledge?

Kinetically slingshotting through a broad spectrum of objective and subjective problems, But What If WeÃ¢â‚¬â„¢re Wrong? is built on interviews with a variety of creative thinkersÃ¢â‚¬â€�George Saunders, David Byrne, Jonathan Lethem, Kathryn Schulz, Neil deGrasse Tyson, Brian Greene, Junot DÃƒÂ­az, Amanda Petrusich, Ryan Adams, Nick Bostrom, Dan Carlin, and Richard Linklater, among othersÃ¢â‚¬â€�interwoven with the type of high-wire humor and nontraditional analysis only Klosterman would dare to attempt. ItÃ¢â‚¬â„¢s a seemingly impossible achievement: a book about the things we cannot know, explained as if we did. ItÃ¢â‚¬â„¢s about how we live now, once Ã¢â‚¬Å“nowÃ¢â‚¬ï¿½ has become Ã¢â‚¬Å“then.Ã¢â‚¬ï¿½',
2016,
2.65,
'Non-Fiction',
'https://images.gr-assets.com/books/1454284600l/27068734.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Purple Hibiscus',
'Chimamanda Ngozi Adichie',
15.17,
'Fifteen-year-old KambiliÃ¢â‚¬â„¢s world is circumscribed by the high walls and frangipani trees of her family compound. Her wealthy Catholic father, under whose shadow Kambili lives, while generous and politically active in the community, is repressive and fanatically religious at home.

When Nigeria begins to fall apart under a military coup, KambiliÃ¢â‚¬â„¢s father sends her and her brother away to stay with their aunt, a University professor, whose house is noisy and full of laughter. There, Kambili and her brother discover a life and love beyond the confines of their fatherÃ¢â‚¬â„¢s authority. The visit will lift the silence from their world and, in time, give rise to devotion and defiance that reveal themselves in profound and unexpected ways. 

This is a book about the promise of freedom- about the blurred lines between childhood and adulthood; between love and hatred, between the old gods and the new.',
2003,
4.16,
'Fiction',
'https://images.gr-assets.com/books/1527779236l/126381.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Death of Ivan Ilych',
'Leo Tolstoy',
22.45,
'Hailed as one of the world''s supreme masterpieces on the subject of death and dying, The Death of Ivan Ilyich is the story of a worldly careerist, a high court judge who has never given the inevitability of his dying so much as a passing thought. But one day, death announces itself to him, and to his shocked surprise, he is brought face to face with his own mortality. 

How, Tolstoy asks, does an unreflective man confront his one and only moment of truth?

This short novel was an artistic culmination of a profound spiritual crisis in Tolstoy''s life, a nine-year period following the publication of Anna Karenina during which he wrote not a word of fiction.
A thoroughly absorbing, and, at times, terrifying glimpse into the abyss of death, it is also a strong testament to the possibility of finding spiritual salvation.',
1886,
2.12,
'Fiction',
'https://images.gr-assets.com/books/1336967150l/18386.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Angel''s Game',
'Carlos Ruiz ZafÃƒÂ³n',
19.80,
'From the author of the international phenomenon, The Shadow of the Wind, comes The AngelÃ¢â‚¬â„¢s Game, a new page-turner about the perilous nature of obsession, in literature and in love.

Ã¢â‚¬Å“The whole of Barcelona stretched out at my feet and I wanted to believe that, when I opened those windows, its streets would whisper stories to me, secrets I could capture on paper and narrate to whomever cared to listen . . .Ã¢â‚¬ï¿½ 

In an abandoned mansion at the heart of Barcelona, a young man, David MartÃƒÂ­n, makes his living by writing sensationalist novels under a pseudonym. The survivor of a troubled childhood, he has taken refuge in the world of books and spends his nights spinning baroque tales about the cityÃ¢â‚¬â„¢s underworld. But perhaps his dark imaginings are not as strange as they seem, for in a locked room deep within the house lie photographs and letters hinting at the mysterious death of the previous owner. 

Like a slow poison, the history of the place seeps into his bones as he struggles with an impossible love. Close to despair, David receives a letter from a reclusive French editor, Andreas Corelli, who makes him the offer of a lifetime. He is to write a book unlike anything that has ever existedÃ¢â‚¬â€�a book with the power to change hearts and minds. In return, he will receive a fortune, and perhaps more. But as David begins the work, he realizes that there is a connection between his haunting book and the shadows that surround his home.

Once again, ZafÃƒÂ³n takes us into a dark, gothic universe first seen in the Shadow of the Wind and creates a breathtaking adventure of intrigue, romance, and tragedy. Through a dizzingly constructed labyrinth of secrets, the magic of books, passion, and friendship blend into a masterful story.',
2008,
3.90,
'Fiction',
'https://images.gr-assets.com/books/1434302581l/5196764.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'When Breath Becomes Air',
'Paul Kalanithi',
14.99,
'For readers of Atul Gawande, Andrew Solomon, and Anne Lamott, a profoundly moving, exquisitely observed memoir by a young neurosurgeon faced with a terminal cancer diagnosis who attempts to answer the question What makes a life worth living?

At the age of thirty-six, on the verge of completing a decade''s worth of training as a neurosurgeon, Paul Kalanithi was diagnosed with stage IV lung cancer. One day he was a doctor treating the dying, and the next he was a patient struggling to live. And just like that, the future he and his wife had imagined evaporated. When Breath Becomes Air chronicles Kalanithi''s transformation from a naÃƒÂ¯ve medical student "possessed," as he wrote, "by the question of what, given that all organisms die, makes a virtuous and meaningful life" into a neurosurgeon at Stanford working in the brain, the most critical place for human identity, and finally into a patient and new father confronting his own mortality. 

What makes life worth living in the face of death? What do you do when the future, no longer a ladder toward your goals in life, flattens out into a perpetual present? What does it mean to have a child, to nurture a new life as another fades away? These are some of the questions Kalanithi wrestles with in this profoundly moving, exquisitely observed memoir. 

Paul Kalanithi died in March 2015, while working on this book, yet his words live on as a guide and a gift to us all. "I began to realize that coming face to face with my own mortality, in a sense, had changed nothing and everything," he wrote. "Seven words from Samuel Beckett began to repeat in my head: ''I can''t go on. I''ll go on.''" When Breath Becomes Air is an unforgettable, life-affirming reflection on the challenge of facing death and on the relationship between doctor and patient, from a brilliant writer who became both.',
2016,
4.54,
'Non-Fiction',
'https://images.gr-assets.com/books/1492677644l/25899336.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Everything Body Language Book: Succeed in work, love, and life - all without saying a word!',
'Shelly Hagen',
24.86,
'Is my daughter telling me the truth about where she was last night?
How can I show my boss that I am ready for a promotion?
I think that girl likes me, but I''m not sure.

Crossed arms. Eye contact. Fidgeting. These are all the body''s subtle ways of speaking, and they can tell you more than you think. With over half of human communication coming from movement, you need a comprehensive guide to reading and understanding body language. This updated edition features an expanded section on discovering deception and foolproof ways to spot a liar.

With this guide, you''ll learn valuable nonverbal nuances, including how to:
Project professional body language at work
Detect a liar at home, school, or in a relationship
Tell if your date is into you--or planning to leave you
Recognize and control hostile body language you may project
Decipher digital and online body language
From dating to job interviews to finding out if your kid really did eat his veggies, this is the ultimate guide to master the art of nonverbal communication!',
2011,
3.60,
'Non-Fiction',
'https://images.gr-assets.com/books/1348412915l/11476418.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'A Vast Conspiracy: The Real Story of the Sex Scandal That Nearly Brought Down a President',
'Jeffrey Toobin',
14.99,
'In A Vast Conspiracy, the best-selling author of The Run of His Life casts an insightful, unbiased eye over the most extraordinary public saga of our time -- the Clinton sex scandals.  A superlative journalist known for the skillfulness of his investigating and the power of his writing, Jeffrey Toobin tells the unlikely story of the events that began over doughnuts in a Little Rock hotel and ended on the floor of the United States Senate, with only the second vote on Presidential removal in American history.  This is an entirely fresh look at the scandal that very nearly brought down a president.

Packed with news-making disclosures and secret documents published here for the first time, Toobin unravels the three strands of a national scandal - those leading from  Paula Jones, Kenneth Starr, and Monica Lewinsky - that created a legal, personal, and political disaster for Bill Clinton.  A Vast Conspiracy is written with the narrative drive of a sensational (if improbable) legal thriller, and Toobin brilliantly explores the high principle and low comedy that were the hallmarks of the story.  From Tripp to Goldberg, Isikoff to Hyde, the complex and tangled motivations behind the scandal are laid bare.

While misguided, outlandish behavior was played out at the very highest level, Toobin analyzes the facts and the key figures with a level of dignity and insight that this story has not yet received. The Clinton scandals will shape forever how we think about the signature issues of our day -- sex and sexual harassment, privacy and perjury, civil rights, and, yes, cigars.  Toobin''s book will shape forever how we think about the Clinton scandals.',
2000,
3.87,
'Non-Fiction',
'https://images.gr-assets.com/books/1386277947l/19216267.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'In the Garden of Beasts: Love, Terror, and an American Family in Hitler''s Berlin',
'Erik Larson',
17.10,
'The time is 1933, the place, Berlin, when William E. Dodd becomes AmericaÃ¢â‚¬â„¢s first ambassador to HitlerÃ¢â‚¬â„¢s Nazi Germany in a year that proved to be a turning point in history.
    A mild-mannered professor from Chicago, Dodd brings along his wife, son, and flamboyant daughter, Martha. At first Martha is entranced by the parties and pomp, and the handsome young men of the Third Reich with their infectious enthusiasm for restoring Germany to a position of world prominence. Enamored of the Ã¢â‚¬Å“New Germany,Ã¢â‚¬ï¿½ she has one affair after another, including with the suprisingly honorable first chief of the Gestapo, Rudolf Diels. But as evidence of Jewish persecution mounts, confirmed by chilling first-person testimony, her father telegraphs his concerns to a largely indifferent State Department back home. Dodd watches with alarm as Jews are attacked, the press is censored, and drafts of frightening new laws begin to circulate. As that first year unfolds and the shadows deepen, the Dodds experience days full of excitement, intrigue, romanceÃ¢â‚¬â€�and ultimately, horror, when a climactic spasm of violence and murder reveals HitlerÃ¢â‚¬â„¢s true character and ruthless ambition.
    Suffused with the tense atmosphere of the period, and with unforgettable portraits of the bizarre GÃƒÂ¶ring and the expectedly charming--yet wholly sinister--Goebbels, In the Garden of Beasts lends a stunning, eyewitness perspective on events as they unfold in real time, revealing an era of surprising nuance and complexity. The result is a dazzling, addictively readable work that speaks volumes about why the world did not recognize the grave threat posed by Hitler until Berlin, and Europe, were awash in blood and terror.',
2011,
3.83,
'History',
'https://images.gr-assets.com/books/1340831738l/12602377.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Call for the Dead',
'John le CarrÃƒÂ©',
16.83,
'George Smiley had liked the man and now the man was dead. Suicide. But why? An anonymous letter had alleged that Foreign Office man Samuel Fennan had been a member of the Communist Party as a student before the war. Nothing very unusual for his generation.

Smiley had made it clear that the investigation, little more than a routine security check, was over and that the file on Fennan could be closed. Next day, Fennan was dead with a note by his body saying his career was finished and he couldnÃ¢â‚¬â„¢t go on.',
1961,
1.89,
'Mystery',
'https://images.gr-assets.com/books/1353314998l/16158666.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Tarkin',
'James Luceno',
10.79,
'A long time ago in a galaxy far, far away. . . . 
 
Bestselling Star Wars veteran James Luceno gives Tarkin the Star Wars: Darth Plagueis treatment, bringing a legendary character from A New Hope to full, fascinating life.',
2014,
2.12,
'Fiction',
'https://images.gr-assets.com/books/1398456370l/22012250.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Silence',
'ShÃ…Â«saku EndÃ…ï¿½',
13.42,
'Beneath the light of the candle I am sitting with my hands on my knees, staring in front of me. And I keep turning over in my mind the thought that I am at the end of the earth, in a place which you do not know and which your whole lives through you will never visit.

It is 1640 and Father Sebastian Rodrigues, an idealistic Jesuit priest, sets sail for Japan determined to help the brutally oppressed Christians there. He is also desperate to discover the truth about his former mentor, rumoured to have renounced his faith under torture. Rodrigues cannot believe the stories about a man he so revered, but as his journey takes him deeper into Japan and then into the hands of those who would crush his faith, he finds himself forced to make an impossible choice: whether to abandon his flock or his God.

The recipient of the 1966 Tanizaki Prize, Silence is Shusaku Endo''s most highly acclaimed work and has been called one of the twentieth century''s finest novels. As empathetic as it is powerful, it is an astonishing exploration of faith and suffering and an award-winning classic.',
1966,
2.74,
'Fiction',
'https://images.gr-assets.com/books/1503294393l/25200.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Wenjack',
'Joseph Boyden',
10.60,
'An Ojibwe boy runs away from a North Ontario Indian School, not realizing just how far away home is. Along the way he''s followed by Manitous, spirits of the forest who comment on his plight, cajoling, taunting, and ultimately offering him a type of comfort on his difficult journey back to the place he was so brutally removed from.

Written by Scotiabank Giller Prize-winning author Joseph Boyden and beautifully illustrated by acclaimed artist Kent Monkman, Wenjack is a powerful and poignant look into the world of a residential school runaway trying to find his way home.',
2016,
3.28,
'Fiction',
'https://images.gr-assets.com/books/1469406055l/30079906.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Devil in the White City: Murder, Magic, and Madness at the Fair That Changed America',
'Erik Larson',
13.63,
'Bringing Chicago circa 1893 to vivid life, Erik Larson''s spell-binding bestseller intertwines the true tale of two men--the brilliant architect behind the legendary 1893 World''s Fair, striving to secure America''s place in the world; and the cunning serial killer who used the fair to lure his victims to their death. Combining meticulous research with nail-biting storytelling. Erik Larson has crafted a narrative with all the wonder of newly discovered history and the thrills of the best fiction.',
2003,
3.99,
'History',
'https://images.gr-assets.com/books/1388184618l/259028.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Jungle Book',
'Rudyard Kipling',
20.83,
'The Jungle Book key characters are Mowgli, a boy raised by wolves and Sher Khan, biggest tiger in India. As Baloo the sleepy brown bear, Bagheera the cunning black panther, Kaa the python, and his other animal friends teach their beloved Ã¢â‚¬Å“man-cubÃ¢â‚¬ï¿½ the ways of the jungle, Mowgli gains the strength and wisdom he needs for his frightful fight with Shere Khan, the tiger who robbed him of his human family. But there are also the tales of Rikki-tikki-tavi the mongoose and his Ã¢â‚¬Å“great warÃ¢â‚¬ï¿½ against the vicious cobras Nag and Nagaina- of Toomai, who watches the elephants dance; and of Kotick the white seal, who swims in the Bering Sea.',
1893,
2.93,
'Childrens',
'https://images.gr-assets.com/books/1327873594l/77270.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Ali vs. Inoki: The Forgotten Fight That Inspired Mixed Martial Arts and Launched Sports Entertainment',
'Josh Gross',
13.57,
'Ã¢â‚¬Å“Inoki can use his bare fists. He can use karate. This is serious. ThereÃ¢â‚¬â„¢s $10 million involved. I wouldnÃ¢â‚¬â„¢t pull a fraud on the public. This is real. ThereÃ¢â‚¬â„¢s no plan. The blood. The holds. The pain. Everything is going to be real. IÃ¢â‚¬â„¢m not here in this time of my life to come out with some phony action. I want you to know this is real."
Ã¢â‚¬â€�Muhammad Ali, June 14, 1976, The Tonight Show

On June 26, 1976, Muhammad Ali fought in a mixed-rules contest against iconic pro wrestling champion Antonio Inoki for the so-called Ã¢â‚¬Å“martial arts championship of the world.Ã¢â‚¬ï¿½ Broadcast from Tokyo to a potential audience of 1.4 billion in 34 countries, the spectacle foreshadowed and, in many ways, led to the rise of mixed martial arts as a major sport.

The unique contest was controversial and panned by wrestling and boxing supporters alike, but the real action was behind the scenes. Egos, competing interests, and a general sense of apprehension over what would happen in the ring led to hodgepodge rules thrown together at the last minute. Bizarre plans to Ã¢â‚¬Å“saveÃ¢â‚¬ï¿½ Ali if the fight got out of hand were even concocted.

In Ali vs. Inoki, author Josh Gross gets inside AliÃ¢â‚¬â„¢s head leading up to the match by resurrecting pre-fight interviews. Gross also introduces us to Inoki, the most famous face in Japan who was instrumental in shaping modern mixed martial arts.',
2016,
3.69,
'Non-Fiction',
'https://images.gr-assets.com/books/1447716930l/27040540.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Based on a True Story',
'Norm Macdonald',
11.99,
'Wild, dangerous, and flat-out unbelievable, here is the incredible memoir of the actor, gambler, raconteur, SNL veteran, and one of the best stand-up comedians of all time.

As this book''s title suggests, Norm Macdonald tells the story of his life more or less from his origins on a farm in the-back-of-beyond Canada and an epically disastrous appearance on Star Search to his account of auditioning for Lorne Michaels and his memorable run as the anchor of Weekend Update on Saturday Night Live until he was fired because a corporate executive didn''t think he was funny.

But Based on a True Story is much more than a memoir- it''s the hilarious, inspired epic of Norm''s life. In dispatches from a road trip to Las Vegas (part of a plan hatched to regain the fortune he''d lost to sports betting and other vices) with his sidekick and enabler, Adam Eget, Norm recounts the milestone moments, the regrets, the love affairs, the times fortune smiled on his life, and the times it refused to smile. As the clock ticks down, Norm''s debt reaches record heights, and he must find a way to evade the hefty price that''s been placed on his head by one of the most dangerous loan sharks in the country.

As a comedy legend should, Norm peppers these pages with classic jokes and fondly mythologized Hollywood stories. This wildly adventurous, totally original, and absurdly funny saga turns the conventional comic''s memoir on its head and gives the reader an exclusive pass into the mad, glorious mind of Norm Macdonald.',
2016,
3.94,
'Non-Fiction',
'https://images.gr-assets.com/books/1468269907l/28686959.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Time For The Stars',
'Robert A. Heinlein',
22.40,
'This is one of the classic titles originally know as the "Heinlein Juveniles," written in the 1950 and published for the young adult market. It has since been in print for 50 years in paperback, and now returns to hardcover for a new generation. 
Travel to other planets is a reality, and with overpopulation stretching the resources of Earth, the necessity to find habitable worlds is growing ever more urgent. With no time to wait years for communication between slower-than-light spaceships and home, the Long Range Foundation explores an unlikely solution--human telepathy.
Identical twins Tom and Pat are enlisted to be the human radios that will keep the ships in contact with Earth. The only problem is that one of them has to stay behind, and that one will grow old while the other explores the depths of space.Always a master of insight into the human consequences of future technologies, this is one of Heinlein''s triumphs.',
1956,
3.96,
'Science Fiction',
'https://images.gr-assets.com/books/1312056144l/356.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Hunger Games',
'Suzanne Collins',
15.89,
'Could you survive on your own, in the wild, with everyone out to make sure you don''t live to see the morning?

In the ruins of a place once known as North America lies the nation of Panem, a shining Capitol surrounded by twelve outlying districts. The Capitol is harsh and cruel and keeps the districts in line by forcing them all to send one boy and one girl between the ages of twelve and eighteen to participate in the annual Hunger Games, a fight to the death on live TV. Sixteen-year-old Katniss Everdeen, who lives alone with her mother and younger sister, regards it as a death sentence when she is forced to represent her district in the Games. But Katniss has been close to dead before - and survival, for her, is second nature. Without really meaning to, she becomes a contender. But if she is to win, she will have to start making choices that weigh survival against humanity and life against love.

New York Times bestselling author Suzanne Collins delivers equal parts suspense and philosophy, adventure and romance, in this searing novel set in a future with unsettling parallels to our present.',
2008,
4.33,
'Young Adult',
'https://images.gr-assets.com/books/1447303603l/2767052.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Catching Fire',
'Suzanne Collins',
14.59,
'Against all odds, Katniss has won the Hunger Games. She and fellow District 12 tribute Peeta Mellark are miraculously still alive. Katniss should be relieved, happy even. After all, she has returned to her family and her longtime friend, Gale. Yet nothing is the way Katniss wishes it to be. Gale holds her at an icy distance. Peeta has turned his back on her completely. And there are whispers of a rebellion against the Capitol - a rebellion that Katniss and Peeta may have helped create.

Much to her shock, Katniss has fueled an unrest she''s afraid she cannot stop. And what scares her even more is that she''s not entirely convinced she should try. As time draws near for Katniss and Peeta to visit the districts on the Capitol''s cruel Victory Tour, the stakes are higher than ever. If they can''t prove, without a shadow of a doubt, that they are lost in their love for each other, the consequences will be horrifying.

In Catching Fire, the second novel in the Hunger Games trilogy, Suzanne Collins continues the story of Katniss Everdeen, testing her more than ever before...and surprising readers at every turn.',
2009,
4.29,
'Young Adult',
'https://images.gr-assets.com/books/1358273780l/6148028.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Mockingjay',
'Suzanne Collins',
17.61,
'Katniss Everdeen, girl on fire, has survived, even though her home has been destroyed. Gale has escaped. Katniss''s family is safe. Peeta has been captured by the Capitol. District 13 really does exist. There are rebels. There are new leaders. A revolution is unfolding.

It is by design that Katniss was rescued from the arena in the cruel and haunting Quarter Quell, and it is by design that she has long been part of the revolution without knowing it. District 13 has come out of the shadows and is plotting to overthrow the Capitol. Everyone, it seems, has had a hand in the carefully laid plans-except Katniss.

The success of the rebellion hinges on Katniss''s willingness to be a pawn, to accept responsibility for countless lives, and to change the course of the future of Panem. To do this, she must put aside her feelings of anger and distrust. She must become the rebels'' Mockingjay-no matter what the personal cost.',
2010,
4.03,
'Young Adult',
'https://images.gr-assets.com/books/1358275419l/7260188.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Divergent',
'Veronica Roth',
16.75,
'In Beatrice Prior''s dystopian Chicago world, society is divided into five factions, each dedicated to the cultivation of a particular virtueÃ¢â‚¬â€�Candor (the honest), Abnegation (the selfless), Dauntless (the brave), Amity (the peaceful), and Erudite (the intelligent). On an appointed day of every year, all sixteen-year-olds must select the faction to which they will devote the rest of their lives. For Beatrice, the decision is between staying with her family and being who she really isÃ¢â‚¬â€�she can''t have both. So she makes a choice that surprises everyone, including herself.

During the highly competitive initiation that follows, Beatrice renames herself Tris and struggles alongside her fellow initiates to live out the choice they have made. Together they must undergo extreme physical tests of endurance and intense psychological simulations, some with devastating consequences. As initiation transforms them all, Tris must determine who her friends really areÃ¢â‚¬â€�and where, exactly, a romance with a sometimes fascinating, sometimes exasperating boy fits into the life she'' chosen. But Tris also has a secret, one she''s kept hidden from everyone because she''s been warned it can mean death. And as she discovers unrest and growing conflict that threaten to unravel her seemingly perfect society, she also learns that her secret might help her save those she loves... or it might destroy her.',
2011,
3.21,
'Young Adult',
'https://images.gr-assets.com/books/1328559506l/13335037.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Fault in Our Stars',
'John Green',
16.95,
'Despite the tumor-shrinking medical miracle that has bought her a few years, Hazel has never been anything but terminal, her final chapter inscribed upon diagnosis. But when a gorgeous plot twist named Augustus Waters suddenly appears at Cancer Kid Support Group, Hazel''s story is about to be completely rewritten.

Insightful, bold, irreverent, and raw, The Fault in Our Stars is award-winning author John Green''s most ambitious and heartbreaking work yet, brilliantly exploring the funny, thrilling, and tragic business of being alive and in love.',
2012,
3.24,
'Young Adult',
'https://images.gr-assets.com/books/1360206420l/11870085.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Twilight',
'Stephenie Meyer',
19.06,
'About three things I was absolutely positive.

First, Edward was a vampire.

Second, there was a part of himÃ¢â‚¬â€�and I didn''t know how dominant that part might beÃ¢â‚¬â€�that thirsted for my blood.

And third, I was unconditionally and irrevocably in love with him.

In the first book of the Twilight Saga, internationally bestselling author Stephenie Meyer introduces Bella Swan and Edward Cullen, a pair of star-crossed lovers whose forbidden relationship ripens against the backdrop of small-town suspicion and a mysterious coven of vampires. This is a love story with bite.',
2006,
3.58,
'Young Adult',
'https://images.gr-assets.com/books/1361039443l/41865.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'New Moon',
'Stephenie Myer',
14.86,
'I knew we were both in mortal danger. Still, in that instant, I felt well. Whole. I could feel my heart racing in my chest, the blood pulsing hot and fast through my veins again. My lungs filled deep with the sweet scent that came off his skin. It was like there had never been any hole in my chest. I was perfect - not healed, but as if there had never been a wound in the first place. 

For Bella Swan, there is one thing more important than life itself: Edward Cullen. But being in love with a vampire is even more dangerous than Bella could ever have imagined. Edward has already rescued Bella from the clutches of one evil vampire, but now, as their daring relationship threatens all that is near and dear to them, they realize their troubles may be just beginning...',
2006,
3.53,
'Young Adult',
'https://images.gr-assets.com/books/1361039440l/49041.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Insurgent',
'Veronica Roth',
11.99,
'One choice can transform youÃ¢â‚¬â€�or it can destroy you. But every choice has consequences, and as unrest surges in the factions all around her, Tris Prior must continue trying to save those she lovesÃ¢â‚¬â€�and herselfÃ¢â‚¬â€�while grappling with haunting questions of grief and forgiveness, identity and loyalty, politics and love.

Tris''s initiation day should have been marked by celebration and victory with her chosen faction; instead, the day ended with unspeakable horrors. War now looms as conflict between the factions and their ideologies grows. And in times of war, sides must be chosen, secrets will emerge, and choices will become even more irrevocableÃ¢â‚¬â€�and even more powerful. Transformed by her own decisions but also by haunting grief and guilt, radical new discoveries, and shifting relationships, Tris must fully embrace her Divergence, even if she does not know what she may lose by doing so.

New York Times bestselling author Veronica Roth''s much-anticipated second book of the dystopian DIVERGENT series is another intoxicating thrill ride of a story, rich with hallmark twists, heartbreaks, romance, and powerful insights about human nature.',
2012,
3.05,
'Young Adult',
'https://images.gr-assets.com/books/1325667729l/11735983.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Alice''s Adventures in Wonderland',
'Lewis Carroll',
17.96,
'After a tumble down the rabbit hole, Alice finds herself far away from home in the absurd world of Wonderland. As mind-bending as it is delightful, Lewis CarrollÃ¢â‚¬â„¢s 1865 novel is pure magic for young and old alike.',
1865,
4.00,
'Childrens',
'https://images.gr-assets.com/books/1391204048l/6324090.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'The Joy of Cooking',
'Irma S. Rombauer',
7.49,
'Since its original publication, Joy of Cooking has been the most authoritative cookbook in America, the one upon which millions of cooks have confidently relied for more than sixty-five years. It''s the book your grandmother and mother probably learned to cook from, the book you gave your sister when she got married. This, the first revision in more than twenty years, is better than ever. Here''s why: Every chapter has been rethought with an emphasis on freshness, convenience, and health.

All the recipes have been reconceived and tested with an eye to modern taste, and the cooking knowledge imparted with each subject enriched to the point where everyone from a beginning to an experienced cook will feel completely supported.',
1931,
4.13,
'Food',
'https://images.gr-assets.com/books/1433263698l/75205.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Veganomicon: The Ultimate Vegan Cookbook',
'Isa Chandra Moskowitz',
32.50,
'Who knew vegetables could taste so good? Vegan powerhouses Isa Moskowitz and Terry Romero bring a brand new edition of this beloved vegan cookbook to celebrate its 10th anniversary. You''ll find 25 new dishes and updates throughout for more than 250 recipes (everything from basics to desserts), stunning color photos, and tips for making your kitchen a vegan paradise. All the recipes in Veganomicon have been thoroughly kitchen-tested to ensure user-friendliness and amazing results. Veganomicon also includes meals for all occasions and soy-free, gluten-free, and low-fat options, plus quick recipes that make dinner a snap.',
2007,
3.92,
'Food',
'https://images.gr-assets.com/books/1328751476l/1059680.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'How to Cook Everything: Simple Recipes for Great Food',
'Mark Bittman',
13.89,
'Here''s the breakthrough one-stop cooking reference for today''s generation of cooks! Nationally known cooking authority Mark Bittman shows you how to prepare great food for all occasions using simple techniques, fresh ingredients, and basic kitchen equipment. Just as important, How to Cook Everything takes a relaxed, straightforward approach to cooking, so you can enjoy yourself in the kitchen and still achieve outstanding results.',
1998,
4.00,
'Food',
'https://images.gr-assets.com/books/1407047944l/603204.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'And Then There Were None',
'Agatha Christie',
6.98,
'First, there were tenÃ¢â‚¬â€�a curious assortment of strangers summoned as weekend guests to a private island off the coast of Devon. Their host, an eccentric millionaire unknown to all of them, is nowhere to be found. All that the guests have in common is a wicked past they''re unwilling to revealÃ¢â‚¬â€�and a secret that will seal their fate. For each has been marked for murder. One by one they fall prey. Before the weekend is out, there will be none. And only the dead are above suspicion.',
1939,
4.25,
'Mystery',
'https://images.gr-assets.com/books/1391120695l/16299.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Murder on the Orient Express',
'Agatha Christie',
14.95,
'What more can a mystery addict desire than a much-loathed murder victim found aboard the luxurious Orient Express with multiple stab wounds, thirteen likely suspects, an incomparably brilliant detective in Hercule Poirot, and the most ingenious crime ever conceived?',
1934,
4.16,
'Mystery',
'https://images.gr-assets.com/books/1486131451l/853510.jpg');

INSERT INTO Books (title, author, price, description, publishYear, rating, category, url) VALUES(
'Gone Girl',
'Gillian Flynn',
19.80,
'Marriage can be a real killer.

One of the most critically acclaimed suspense writers of our time, New York Times bestseller Gillian Flynn takes that statement to its darkest place in this unputdownable masterpiece about a marriage gone terribly, terribly wrong. The Chicago Tribune proclaimed that her work Ã¢â‚¬Å“draws you in and keeps you reading with the force of a pure but nasty addiction.Ã¢â‚¬ï¿½ Gone GirlÃ¢â‚¬â„¢s toxic mix of sharp-edged wit and deliciously chilling prose creates a nerve-fraying thriller that confounds you at every turn.

On a warm summer morning in North Carthage, Missouri, it is Nick and Amy DunneÃ¢â‚¬â„¢s fifth wedding anniversary. Presents are being wrapped and reservations are being made when NickÃ¢â‚¬â„¢s clever and beautiful wife disappears from their rented McMansion on the Mississippi River. Husband-of-the-Year Nick isnÃ¢â‚¬â„¢t doing himself any favors with cringe-worthy daydreams about the slope and shape of his wifeÃ¢â‚¬â„¢s head, but passages from Amy''s diary reveal the alpha-girl perfectionist could have put anyone dangerously on edge. Under mounting pressure from the police and the mediaÃ¢â‚¬â€�as well as AmyÃ¢â‚¬â„¢s fiercely doting parentsÃ¢â‚¬â€�the town golden boy parades an endless series of lies, deceits, and inappropriate behavior. Nick is oddly evasive, and heÃ¢â‚¬â„¢s definitely bitterÃ¢â‚¬â€�but is he really a killer?

As the cops close in, every couple in town is soon wondering how well they know the one that they love. With his twin sister, Margo, at his side, Nick stands by his innocence. Trouble is, if Nick didnÃ¢â‚¬â„¢t do it, where is that beautiful wife? And what was in that silvery gift box hidden in the back of her bedroom closet?

With her razor-sharp writing and trademark psychological insight, Gillian Flynn delivers a fast-paced, devilishly dark, and ingeniously plotted thriller that confirms her status as one of the hottest writers around.',
2012,
4.06,
'Mystery',
'https://images.gr-assets.com/books/1386574953l/19288043.jpg');

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

INSERT INTO Reviews (username, bid, review, rating) VALUES(
'osama',
1,
'I must admit that I do not like Apple and was never a fan of Jobs but when I saw that his biography was on a must read list online, I decided to open my heart to this book. When I started reading it, I was a little close-minded to Steve Jobs story but as I advanced his personality grew on me and I actually started laughing and caring about who he was as a person, almost as if he were a friend...this book made me care about Steve job''s life and legacy because it gave me a different perspective on him. I was aware that he was deceased when I began exploring his biography but as I finished I could not help but cry for I knew that he was not part of the world anymore...but one of the last sentences of the book....truly made me laugh and this helped with the sadness.

I believe this book should be read by anyone really, to learn from it in many ways and experience the good sides of Steve Jobs instead of just the bad things that were constantly said about him. He is someone who had a big impact on the 21st century and brought our society into a more advanced technological world. Thank you, Steve Jobs, and for all you contributed to our world, your legacy will live on forever!',
4.5
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
	PRIMARY KEY (odid),
	CONSTRAINT orderdetails_oid_ref FOREIGN KEY (oid) REFERENCES Orders (oid),
	CONSTRAINT orderdetails_bid_ref FOREIGN KEY (bid) REFERENCES Books (bid)
);

CREATE TABLE Cart (
	cid INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	username VARCHAR(30) NOT NULL,
	bid INT NOT NULL,
	quantity INT NOT NULL,
	PRIMARY KEY (cid),
	CONSTRAINT cart_bid_ref FOREIGN KEY (bid) REFERENCES Books (bid)
);
