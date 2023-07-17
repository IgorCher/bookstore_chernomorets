CREATE TABLE books (
	id BIGSERIAL PRIMARY KEY,
	author VARCHAR(50)NOT NULL,
	name VARCHAR (50) NOT NULL,
	year VARCHAR (4) NOT NULL,
	pages int,
	isbn VARCHAR (13) UNIQUE NOT NULL
);

INSERT INTO books (author, name, year, pages, isbn)
VALUES ('Shakespeare', 'Romeo and Juliet','1911',1510,'1234562890'),
		('Melville', 'Moby Dick','1912',801,'1234567810'),
		('Forster', 'A Room with a View','1912',780,'2234567890'),
		('Eliot', 'Middlemarch','1941',605,'1234567390'),
		('Alcott', 'Little Women','1909',450,'1264567890'),
		('Arnim', 'The Enchanted April','1956',1000,'7234567890'),
		('Montgomery', 'The Blue Castle','1972',342,'8234567890'),
		('Gaskell', 'Cranford','1970',156,'1234567850'),
		('Smollett', 'The Expedition of Humphry Clinker','1984',981,'2334567890'),
		('Dumas', 'Twenty Years After','1957',357, '4123456789'),
		('Austen', 'Pride and Prejudice','1956',578,'5234567890'),
		('Shelley', 'Frankenstein','1919',237,'6234567890'),
		('Price', 'Through the gates of the silver key','1974',901,'7234561890'),
		('Carroll', 'Alices Adventures in Wonderland','1910',456,'8234967890'),
		('Marx', 'The Eighteenth Brumaire of Louis Bonaparte','1960',1313,'9234567890'),
		('Howard', 'Black Canaan','1961',1234,'2134567890'),
		('Lucas', 'Wisdom while you wait','1962',1942,'0134567890'),
		('Tolstoy', 'War and Peace','1935',311,'1234277890'),
		('Stoker', 'Dracula','1934',525,'1234517890'),
		('Wilde', 'The Picture of Dorian Gray','1957',873,'1249567890'),
		('Dickens', 'A Tale of Two Cities','1914',255,'1234500890'),
		('Doyle', 'The Adventures of Sherlock Holmes','1973',678,'1014567890'),
		('Kafka', 'Metamorphosis','1964',1211,'1999567890'),
		('Dostoyevsky', 'The Brothers Karamazov','1920',500,'4442567890'),
		('Homer', 'The Iliad ','925',419,'7784567890');


		