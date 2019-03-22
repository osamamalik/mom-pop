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
	title VARCHAR(250) NOT NULL,
	author VARCHAR(120) NOT NULL,
	price DOUBLE NOT NULL,
	description VARCHAR(2500) NOT NULL,
	publishYear INT NOT NULL,
	review DOUBLE NOT NULL,
	category VARCHAR(32) CHECK (category IN ('Biography', 'Business', 'Fantasy', 'Fiction', 'Food', 'Graphic Novels', 'History', 'Kids', 'Mystery', 'Non-Fiction', 'Science Fiction', 'Textbooks', 'Young Adult')),
	url VARCHAR(10000) NOT NULL,
	PRIMARY KEY(bid)
);

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
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

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'The Diary of a Young Girl',
'Anne Frank',
8.09,
'Anne Frank''s extraordinary diary, written in the Amsterdam attic where she and her family hid from the Nazis for two years, has become a world classic and a timeless testament to the human spirit. Now, in a new edition enriched by many passages originally withheld by her father, we meet an Anne more real, more human, and more vital than ever. Here she is first and foremost a teenage girl—stubbornly honest, touchingly vulnerable, in love with life. She imparts her deeply secret world of soul-searching and hungering for affection, rebellious clashes with her mother, romance and newly discovered sexuality, and wry, candid observations of her companions. Facing hunger, fear of discovery and death, and the petty frustrations of such confined quarters, Anne writes with adult wisdom and views beyond her years. Her story is that of every teenager, lived out in conditions few teenagers have ever known.',
1993,
4.12,
'Biography',
'https://images.gr-assets.com/books/1537075718l/48855.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
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

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'John Adams',
'David McCullough',
16.86,
'The enthralling, often surprising story of John Adams, one of the most important and fascinating Americans who ever lived.

In this powerful, epic biography, David McCullough unfolds the adventurous life-journey of John Adams, the brilliant, fiercely independent, often irascible, always honest Yankee patriot -- "the colossus of independence," as Thomas Jefferson called him - who spared nothing in his zeal for the American Revolution- who rose to become the second President of the United States and saved the country from blundering into an unnecessary war- who was learned beyond all but a few and regarded by some as "out of his senses"- and whose marriage to the wise and valiant Abigail Adams is one of the moving love stories in American history. 

Like his masterly, Pulitzer Prize-winning biography Truman, David McCullough''s John Adams has the sweep and vitality of a great novel. It is both a riveting portrait of an abundantly human man and a vivid evocation of his time, much of it drawn from an outstanding collection of Adams family letters and diaries. In particular, the more than one thousand surviving letters between John and Abigail Adams, nearly half of which have never been published, provide extraordinary access to their private lives and make it possible to know John Adams as no other major American of his founding era.',
2001,
4.06,
'Biography',
'https://www.goodreads.com/book/show/2203.John_Adams');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
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

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Alexander Hamilton',
'Ron Chernow',
23.40,
'Pulitzer Prize-winning author Ron Chernow presents a landmark biography of Alexander Hamilton, the Founding Father who galvanized, inspired, scandalized, and shaped the newborn nation.

In the first full-length biography of Alexander Hamilton in decades, Ron Chernow tells the riveting story of a man who overcame all odds to shape, inspire, and scandalize the newborn America. According to historian Joseph Ellis, Alexander Hamilton is “a robust full-length portrait, in my view the best ever written, of the most brilliant, charismatic and dangerous founder of them all.”',
2005,
4.24,
'Biography',
'https://images.gr-assets.com/books/1436131915l/16130.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Einstein: His Life and Universe',
'Walter Isaacson',
10.30,
'Einstein was a rebel and nonconformist from boyhood days, and these character traits drove both his life and his science. In this narrative, Walter Isaacson explains how his mind worked and the mysteries of the universe that he discovered.',
2007,
4.10,
'Biography',
'https://images.gr-assets.com/books/1328011405l/10884.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future',
'Ashlee Vance',
27.54,
'Elon Musk, the entrepreneur and innovator behind SpaceX, Tesla, and SolarCity, sold one of his internet companies, PayPal, for $1.5 billion. Ashlee Vance captures the full spectacle and arc of the genius''s life and work, from his tumultuous upbringing in South Africa and flight to the United States to his dramatic technical innovations and entrepreneurial pursuits. Vance uses Musk''s story to explore one of the pressing questions of our age: can the nation of inventors and creators who led the modern world for a century still compete in an age of fierce global competition? He argues that Musk is an amalgam of legendary inventors and industrialists including Thomas Edison, Henry Ford, Howard Hughes, and Steve Jobs. More than any other entrepreneur today, Musk has dedicated his energies and his own vast fortune to inventing a future that is as rich and far-reaching as the visionaries of the golden age of science-fiction fantasy',
2015,
4.23,
'Biography',
'https://images.gr-assets.com/books/1518291452l/25541028.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Into the Wild',
'Jon Krakauer',
18.00,
'In April 1992 a young man from a well-to-do family hitchhiked to Alaska and walked alone into the wilderness north of Mt. McKinley. His name was Christopher Johnson McCandless. He had given $25,000 in savings to charity, abandoned his car and most of his possessions, burned all the cash in his wallet, and invented a new life for himself. Four months later, a party of moose hunters found his decomposed body. How McCandless came to die is the unforgettable story of Into the Wild.

Immediately after graduating from college in 1991, McCandless had roamed through the West and Southwest on a vision quest like those made by his heroes Jack London and John Muir. In the Mojave Desert he abandoned his car, stripped it of its license plates, and burned all of his cash. He would give himself a new name, Alexander Supertramp, and, unencumbered by money and belongings, he would be free to wallow in the raw, unfiltered experiences that nature presented. Craving a blank spot on the map, McCandless simply threw away the maps. Leaving behind his desperate parents and sister, he vanished into the wild.',
1997,
3.97,
'Biography',
'https://images.gr-assets.com/books/1403173986l/1845.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'The Autobiography of Malcolm X',
'Malcolm X',
9.89,
'Through a life of passion and struggle, Malcolm X became one of the most influential figures of the 20th Century. In this riveting account, he tells of his journey from a prison cell to Mecca, describing his transition from hoodlum to Muslim minister. Here, the man who called himself "the angriest Black man in America" relates how his conversion to true Islam helped him confront his rage and recognize the brotherhood of all mankind. 
An established classic of modern America, "The Autobiography of Malcolm X" was hailed by the New York Times as "Extraordinary. A brilliant, painful, important book." Still extraordinary, still important, this electrifying story has transformed Malcom X''s life into his legacy. The strength of his words, the power of his ideas continue to resonate more than a generation after they first appeared.',
1965,
4.30,
'Biography',
'https://images.gr-assets.com/books/1434682864l/92057.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Benjamin Franklin: An American Life',
'Walter Isaacson',
27.29,
'Benjamin Franklin is the Founding Father who winks at us. An ambitious urban entrepreneur who rose up the social ladder, from leather-aproned shopkeeper to dining with kings, he seems made of flesh rather than of marble. In bestselling author Walter Isaacson''s vivid and witty full-scale biography, we discover why Franklin seems to turn to us from history''s stage with eyes that twinkle from behind his new-fangled spectacles. By bringing Franklin to life, Isaacson shows how he helped to define both his own time and ours.

He was, during his 84-year life, America''s best scientist, inventor, diplomat, writer, and business strategist, and he was also one of its most practical—though not most profound—political thinkers. He proved by flying a kite that lightning was electricity, and he invented a rod to tame it. He sought practical ways to make stoves less smoky and commonwealths less corrupt. He organized neighborhood constabularies and international alliances, local lending libraries and national legislatures. He combined two types of lenses to create bifocals and two concepts of representation to foster the nation''s federal compromise. He was the only man who shaped all the founding documents of America: the Albany Plan of Union, the Declaration of Independence, the treaty of alliance with France, the peace treaty with England, and the Constitution. And he helped invent America''s unique style of homespun humor, democratic values, and philosophical pragmatism.',
2003,
3.98,
'Biography',
'https://images.gr-assets.com/books/1397772877l/10883.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Black Leopard, Red Wolf',
'Marlon James',
27.29,
'Tracker is known far and wide for his skills as a hunter: "He has a nose," people say. Engaged to track down a mysterious boy who disappeared three years earlier, Tracker breaks his own rule of always working alone when he finds himself part of a group that comes together to search for the boy. The band is a hodgepodge, full of unusual characters with secrets of their own, including a shape-shifting man-animal known as Leopard.

As Tracker follows the boy''s scent—from one ancient city to another; into dense forests and across deep rivers—he and the band are set upon by creatures intent on destroying them. As he struggles to survive, Tracker starts to wonder: Who, really, is this boy? Why has he been missing for so long? Why do so many people want to keep Tracker from finding him? And perhaps the most important questions of all: Who is telling the truth, and who is lying?

Drawing from African history and mythology and his own rich imagination, Marlon James has written a saga of breathtaking adventure that''s also an ambitious, involving read. Defying categorization and full of unforgettable characters, Black Leopard, Red Wolf is both surprising and profound as it explores the fundamentals of truths, the limits of power, the excesses of ambition, and our need to understand them all.',
2019,
3.70,
'Fantasy',
'https://images.gr-assets.com/books/1538656386l/40524312.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
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

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Harry Potter and the Chamber of Secrets',
'J.K. Rowling',
31.14,
'The Dursleys were so mean and hideous that summer that all Harry Potter wanted was to get back to the Hogwarts School for Witchcraft and Wizardry. But just as he''s packing his bags, Harry receives a warning from a strange, impish creature named Dobby who says that if Harry Potter returns to Hogwarts, disaster will strike',
1998,
4.41,
'Fantasy',
'https://images-na.ssl-images-amazon.com/images/I/51OihdkhSBL._SX329_BO1,204,203,200_.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Harry Potter and the Prisoner of Azkaban',
'J.K. Rowling',
1.40,
'Harry Potter''s third year at Hogwarts is full of new dangers. A convicted murderer, Sirius Black, has broken out of Azkaban prison, and it seems he''s after Harry. Now Hogwarts is being patrolled by the dementors, the Azkaban guards who are hunting Sirius. But Harry can''t imagine that Sirius or, for that matter, the evil Lord Voldemort could be more frightening than the dementors themselves, who have the terrible power to fill anyone they come across with aching loneliness and despair. Meanwhile, life continues as usual at Hogwarts. A top-of-the-line broom takes Harry''s success at Quidditch, the sport of the Wizarding world, to new heights. A cute fourth-year student catches his eye. And he becomes close with the new Defense of the Dark Arts teacher, who was a childhood friend of his father. Yet despite the relative safety of life at Hogwarts and the best efforts of the dementors, the threat of Sirius Black grows ever closer. But if Harry has learned anything from his education in wizardry, it is that things are often not what they seem. Tragic revelations, heartwarming surprises, and high-stakes magical adventures await the boy wizard in this funny and poignant third installment of the beloved series.',
1999,
4.55,
'Fantasy',
'https://images.gr-assets.com/books/1499277281l/5.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Harry Potter and the Goblet of Fire',
'J.K. Rowling',
17.53,
'Harry Potter is midway through his training as a wizard and his coming of age. Harry wants to get away from the pernicious Dursleys and go to the International Quidditch Cup. He wants to find out about the mysterious event that''s supposed to take place at Hogwarts this year, an event involving two other rival schools of magic, and a competition that hasn''t happened for a hundred years. He wants to be a normal, fourteen-year-old wizard. But unfortunately for Harry Potter, he''s not normal - even by wizarding standards. And in his case, different can be deadly.',
2000,
4.55,
'Fantasy',
'https://images.gr-assets.com/books/1361482611l/6.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Harry Potter and the Order of the Phoenix',
'J.K. Rowling',
18.45,
'There is a door at the end of a silent corridor. And it’s haunting Harry Pottter’s dreams. Why else would he be waking in the middle of the night, screaming in terror?

Harry has a lot on his mind for this, his fifth year at Hogwarts: a Defense Against the Dark Arts teacher with a personality like poisoned honey- a big surprise on the Gryffindor Quidditch team; and the looming terror of the Ordinary Wizarding Level exams. But all these things pale next to the growing threat of He-Who-Must-Not-Be-Named---a threat that neither the magical government nor the authorities at Hogwarts can stop.

As the grasp of darkness tightens, Harry must discover the true depth and strength of his friends, the importance of boundless loyalty, and the shocking price of unbearable sacrifice.

His fate depends on them all.',
2003,
4.48,
'Fantasy',
'https://images.gr-assets.com/books/1546910265l/2.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Harry Potter and the Half-Blood Prince',
'J.K. Rowling',
14.91,
'When Harry Potter and the Half-Blood Prince opens, the war against Voldemort has begun. The Wizarding world has split down the middle, and as the casualties mount, the effects even spill over onto the Muggles. Dumbledore is away from Hogwarts for long periods, and the Order of the Phoenix has suffered grievous losses. And yet, as in all wars, life goes on.

Harry, Ron, and Hermione, having passed their O.W.L. level exams, start on their specialist N.E.W.T. courses. Sixth-year students learn to Apparate, losing a few eyebrows in the process. Teenagers flirt and fight and fall in love. Harry becomes captain of the Gryffindor Quidditch team, while Draco Malfoy pursues his own dark ends. And classes are as fascinating and confounding as ever, as Harry receives some extraordinary help in Potions from the mysterious Half-Blood Prince.

Most importantly, Dumbledore and Harry work together to uncover the full and complex story of a boy once named Tom Riddle—the boy who became Lord Voldemort. Like Harry, he was the son of one Muggle-born and one Wizarding parent, raised unloved, and a speaker of Parseltongue. But the similarities end there, as the teenaged Riddle became deeply interested in the Dark objects known as Horcruxes: objects in which a wizard can hide part of his soul, if he dares splinter that soul through murder.

Harry must use all the tools at his disposal to draw a final secret out of one of Riddle’s teachers, the sly Potions professor Horace Slughorn. Finally Harry and Dumbledore hold the key to the Dark Lord’s weaknesses... until a shocking reversal exposes Dumbledore’s own vulnerabilities, and casts Harry’s—and Hogwarts’s—future in shadow.',
2005,
4.56,
'Fantasy',
'https://images.gr-assets.com/books/1361039191l/1.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Harry Potter and the Deathly Hallows',
'J.K. Rowling',
33.52,
'Harry Potter is leaving Privet Drive for the last time. But as he climbs into the sidecar of Hagrid’s motorbike and they take to the skies, he knows Lord Voldemort and the Death Eaters will not be far behind.

The protective charm that has kept him safe until now is broken. But the Dark Lord is breathing fear into everything he loves. And he knows he can’t keep hiding.

To stop Voldemort, Harry knows he must find the remaining Horcruxes and destroy them.

He will have to face his enemy in one final battle.',
2007,
4.63,
'Fantasy',
'https://images.gr-assets.com/books/1474171184l/136251.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'A Game of Thrones',
'George R.R. Martin',
4.98,
'Here is the first volume in George R. R. Martin’s magnificent cycle of novels that includes A Clash of Kings and A Storm of Swords. As a whole, this series comprises a genuine masterpiece of modern fantasy, bringing together the best the genre has to offer. Magic, mystery, intrigue, romance, and adventure fill these pages and transport us to a world unlike any we have ever experienced. Already hailed as a classic, George R. R. Martin’s stunning series is destined to stand as one of the great achievements of imaginative fiction.

A GAME OF THRONES

Long ago, in a time forgotten, a preternatural event threw the seasons out of balance. In a land where summers can last decades and winters a lifetime, trouble is brewing. The cold is returning, and in the frozen wastes to the north of Winterfell, sinister and supernatural forces are massing beyond the kingdom’s protective Wall. At the center of the conflict lie the Starks of Winterfell, a family as harsh and unyielding as the land they were born to. Sweeping from a land of brutal cold to a distant summertime kingdom of epicurean plenty, here is a tale of lords and ladies, soldiers and sorcerers, assassins and bastards, who come together in a time of grim omens.

Here an enigmatic band of warriors bear swords of no human metal- a tribe of fierce wildlings carry men off into madness; a cruel young dragon prince barters his sister to win back his throne; and a determined woman undertakes the most treacherous of journeys. Amid plots and counterplots, tragedy and betrayal, victory and terror, the fate of the Starks, their allies, and their enemies hangs perilously in the balance, as each endeavors to win that deadliest of conflicts: the game of thrones.',
1996,
4.45,
'Fantasy',
'https://images.gr-assets.com/books/1436732693l/13496.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'A Clash of Kings',
'George R.R. Martin',
19.36,
'A comet the color of blood and flame cuts across the sky. Two great leaders—Lord Eddard Stark and Robert Baratheon—who hold sway over an age of enforced peace are dead, victims of royal treachery. Now, from the ancient citadel of Dragonstone to the forbidding shores of Winterfell, chaos reigns. Six factions struggle for control of a divided land and the Iron Throne of the Seven Kingdoms, preparing to stake their claims through tempest, turmoil, and war. 

It is a tale in which brother plots against brother and the dead rise to walk in the night. Here a princess masquerades as an orphan boy- a knight of the mind prepares a poison for a treacherous sorceress; and wild men descend from the Mountains of the Moon to ravage the countryside. Against a backdrop of incest and fratricide, alchemy and murder, victory may go to the men and women possessed of the coldest steel...and the coldest hearts. For when kings clash, the whole land trembles.

Here is the second volume in George R.R. Martin magnificent cycle of novels that includes A Game of Thrones and A Storm of Swords. As a whole, this series comprises a genuine masterpiece of modern fantasy, bringing together the best the genre has to offer. Magic, mystery, intrigue, romance, and adventure fill these pages and transport us to a world unlike any we have ever experienced. Already hailed as a classic, George R.R. Martin stunning series is destined to stand as one of the great achievements of imaginative fiction.',
1998,
4.41,
'Fantasy',
'https://images.gr-assets.com/books/1358254974l/10572.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'A Storm of Swords',
'George R.R. Martin',
8.36,
'Here is the third volume in George R.R. Martin''s magnificent cycle of novels that includes A Game of Thrones and A Clash of Kings. Together, this series comprises a genuine masterpiece of modern fantasy, destined to stand as one of the great achievements of imaginative fiction.

Of the five contenders for power, one is dead, another in disfavor, and still the wars rage as alliances are made and broken. Joffrey sits on the Iron Throne, the uneasy ruler of the Seven Kingdoms. His most bitter rival, Lord Stannis, stands defeated and disgraced, victim of the sorceress who holds him in her thrall. Young Robb still rules the North from the fortress of Riverrun. Meanwhile, making her way across a blood-drenched continent is the exiled queen, Daenerys, mistress of the only three dragons still left in the world. And as opposing forces manoeuver for the final showdown, an army of barbaric wildlings arrives from the outermost limits of civilization, accompanied by a horde of mythical Others—a supernatural army of the living dead whose animated corpses are unstoppable. As the future of the land hangs in the balance, no one will rest until the Seven Kingdoms have exploded in a veritable storm of swords...',
2000,
4.54,
'Fantasy',
'https://images.gr-assets.com/books/1396958446l/13253102.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
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

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'A Dance with Dragons',
'George R.R. Martin',
8.22,
'In the aftermath of a colossal battle, the future of the Seven Kingdoms hangs in the balance—beset by newly emerging threats from every direction. In the east, Daenerys Targaryen, the last scion of House Targaryen, rules with her three dragons as queen of a city built on dust and death. But Daenerys has thousands of enemies, and many have set out to find her. As they gather, one young man embarks upon his own quest for the queen, with an entirely different goal in mind.

Fleeing from Westeros with a price on his head, Tyrion Lannister, too, is making his way to Daenerys. But his newest allies in this quest are not the rag-tag band they seem, and at their heart lies one who could undo Daenerys’s claim to Westeros forever.

Meanwhile, to the north lies the mammoth Wall of ice and stone—a structure only as strong as those guarding it. There, Jon Snow, 998th Lord Commander of the Night’s Watch, will face his greatest challenge. For he has powerful foes not only within the Watch but also beyond, in the land of the creatures of ice.

From all corners, bitter conflicts reignite, intimate betrayals are perpetrated, and a grand cast of outlaws and priests, soldiers and skinchangers, nobles and slaves, will face seemingly insurmountable obstacles. Some will fail, others will grow in the strength of darkness. But in a time of rising restlessness, the tides of destiny and politics will lead inevitably to the greatest dance of all.',
2011,
4.32,
'Fantasy',
'https://images.gr-assets.com/books/1327885335l/10664113.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
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

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
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

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Dark Matter',
'Blake Crouch',
29.70,
'“Are you happy with your life?” 

Those are the last words Jason Dessen hears before the masked abductor knocks him unconscious. 

Before he awakens to find himself strapped to a gurney, surrounded by strangers in hazmat suits. 

Before a man Jason’s never met smiles down at him and says, “Welcome back, my friend.” 

In this world he’s woken up to, Jason’s life is not the one he knows. His wife is not his wife. His son was never born. And Jason is not an ordinary college physics professor, but a celebrated genius who has achieved something remarkable. Something impossible.

Is it this world or the other that’s the dream? And even if the home he remembers is real, how can Jason possibly make it back to the family he loves? The answers lie in a journey more wondrous and horrifying than anything he could’ve imagined—one that will force him to confront the darkest parts of himself even as he battles a terrifying, seemingly unbeatable foe.

From the author of the bestselling Wayward Pines trilogy, Dark Matter is a brilliantly plotted tale that is at once sweeping and intimate, mind-bendingly strange and profoundly human—a relentlessly surprising science-fiction thriller about choices, paths not taken, and how far we’ll go to claim the lives we dream of.',
2016,
4.10,
'Science Fiction',
'https://images.gr-assets.com/books/1472119680l/27833670.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'The Martian',
'Andy Weir',
25.80,
'Six days ago, astronaut Mark Watney became one of the first people to walk on Mars. 

Now, he’s sure he’ll be the first person to die there.

After a dust storm nearly kills him and forces his crew to evacuate while thinking him dead, Mark finds himself stranded and completely alone with no way to even signal Earth that he’s alive—and even if he could get word out, his supplies would be gone long before a rescue could arrive. 

Chances are, though, he won’t have time to starve to death. The damaged machinery, unforgiving environment, or plain-old “human error” are much more likely to kill him first. 

But Mark isn’t ready to give up yet. Drawing on his ingenuity, his engineering skills — and a relentless, dogged refusal to quit — he steadfastly confronts one seemingly insurmountable obstacle after the next. Will his resourcefulness be enough to overcome the impossible odds against him?',
2012,
4.40,
'Science Fiction',
'https://images.gr-assets.com/books/1413706054l/18007564.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Ready Player One',
'Ernest Cline',
26.70,
'In the year 2045, reality is an ugly place. The only time teenage Wade Watts really feels alive is when he''s jacked into the virtual utopia known as the OASIS. Wade''s devoted his life to studying the puzzles hidden within this world''s digital confines, puzzles that are based on their creator''s obsession with the pop culture of decades past and that promise massive power and fortune to whoever can unlock them. When Wade stumbles upon the first clue, he finds himself beset by players willing to kill to take this ultimate prize. The race is on, and if Wade''s going to survive, he''ll have to win—and confront the real world he''s always been so desperate to escape.',
2011,
1.87,
'Science Fiction',
'https://images.gr-assets.com/books/1500930947l/9969571.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Ender''s Game',
'Orson Scott Card',
8.99,
'Andrew ''Ender'' Wiggin thinks he is playing computer simulated war games; he is, in fact, engaged in something far more desperate. The result of genetic experimentation, Ender may be the military genius Earth desperately needs in a war against an alien enemy seeking to destroy all human life. The only way to find out is to throw Ender into ever harsher training, to chip away and find the diamond inside, or destroy him utterly. Ender Wiggin is six years old when it begins. He will grow up fast.

But Ender is not the only result of the experiment. The war with the Buggers has been raging for a hundred years, and the quest for the perfect general has been underway almost as long. Ender''s two older siblings, Peter and Valentine, are every bit as unusual as he is, but in very different ways. While Peter was too uncontrollably violent, Valentine very nearly lacks the capability for violence altogether. Neither was found suitable for the military''s purpose. But they are driven by their jealousy of Ender, and by their inbred drive for power. Peter seeks to control the political process, to become a ruler. Valentine''s abilities turn more toward the subtle control of the beliefs of commoner and elite alike, through powerfully convincing essays. Hiding their youth and identities behind the anonymity of the computer networks, these two begin working together to shape the destiny of Earth-an Earth that has no future at all if their brother Ender fails.',
1985,
4.30,
'Science Fiction',
'https://images.gr-assets.com/books/1408303130l/375802.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'The Man in the High Castle',
'Philip K. Dick',
2.65,
'It''s America in 1962. Slavery is legal once again. The few Jews who still survive hide under assumed names. In San Francisco, the I Ching is as common as the Yellow Pages. All because some twenty years earlier the United States lost a war—and is now occupied by Nazi Germany and Japan.

This harrowing, Hugo Award-winning novel is the work that established Philip K. Dick as an innovator in science fiction while breaking the barrier between science fiction and the serious novel of ideas. In it Dick offers a haunting vision of history as a nightmare from which it may just be possible to wake.',
1962,
2.42,
'Science Fiction',
'https://images.gr-assets.com/books/1448756803l/216363.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Artemis',
'Andy Weir',
24.88,
'Jazz Bashara is a criminal.

Well, sort of. Life on Artemis, the first and only city on the moon, is tough if you''re not a rich tourist or an eccentric billionaire. So smuggling in the occasional harmless bit of contraband barely counts, right? Not when you''ve got debts to pay and your job as a porter barely covers the rent.

Everything changes when Jazz sees the chance to commit the perfect crime, with a reward too lucrative to turn down. But pulling off the impossible is just the start of her problems, as she learns that she''s stepped square into a conspiracy for control of Artemis itself—and that now, her only chance at survival lies in a gambit even riskier than the first.',
2017,
3.34,
'Science Fiction',
'https://images.gr-assets.com/books/1494273579l/34928122.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'Never Let Me Go',
'Kazuo Ishiguro',
18.70,
'From the Booker Prize-winning author of The Remains of the Day and When We Were Orphans, comes an unforgettable edge-of-your-seat mystery that is at once heartbreakingly tender and morally courageous about what it means to be human.

Hailsham seems like a pleasant English boarding school, far from the influences of the city. Its students are well tended and supported, trained in art and literature, and become just the sort of people the world wants them to be. But, curiously, they are taught nothing of the outside world and are allowed little contact with it.

Within the grounds of Hailsham, Kathy grows from schoolgirl to young woman, but it’s only when she and her friends Ruth and Tommy leave the safe grounds of the school (as they always knew they would) that they realize the full truth of what Hailsham is.

Never Let Me Go breaks through the boundaries of the literary novel. It is a gripping mystery, a beautiful love story, and also a scathing critique of human arrogance and a moral examination of how we treat the vulnerable and different in our society. In exploring the themes of memory and the impact of the past, Ishiguro takes on the idea of a possible future to create his most moving and powerful book to date.',
2005,
3.81,
'Science Fiction',
'https://images.gr-assets.com/books/1353048590l/6334.jpg');

INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'The Road',
'Cormac McCarthy',
26.99,
'A searing, postapocalyptic novel destined to become Cormac McCarthy’s masterpiece.

A father and his son walk alone through burned America. Nothing moves in the ravaged landscape save the ash on the wind. It is cold enough to crack stones, and when the snow falls it is gray. The sky is dark. Their destination is the coast, although they don’t know what, if anything, awaits them there. They have nothing- just a pistol to defend themselves against the lawless bands that stalk the road, the clothes they are wearing, a cart of scavenged food—and each other.

The Road is the profoundly moving story of a journey. It boldly imagines a future in which no hope remains, but in which the father and his son, “each the other’s world entire,” are sustained by love. Awesome in the totality of its vision, it is an unflinching meditation on the worst and the best that we are capable of: ultimate destructiveness, desperate tenacity, and the tenderness that keeps two people alive in the face of total devastation.',
2006,
3.96,
'Science Fiction',
'https://images.gr-assets.com/books/1439197219l/6288.jpg');

/*INSERT INTO Books (title, author, price, description, publishYear, review, category, url) VALUES(
'',
'',
price,
'',
year,
rating,
'Science Fiction',
'');*/

