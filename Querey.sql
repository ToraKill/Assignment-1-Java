CREATE DATABASE tutoring;

USE tutoring;

CREATE TABLE video_games (

	game_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    game_title VARCHAR(32) NOT NULL,

    game_genre VARCHAR(32) NOT NULL,

    game_price DECIMAL(9,2) NOT NULL,

    game_release_date DATE NOT NULL

);

INSERT INTO video_games (game_title, game_genre, game_price, game_release_date) # expected order of information. game_id is ommited because it is AUTO_INCREMENT
VALUES 
	('Octopath Traveler','RPG', 83.99, '2018-07-13'), # game_title -> game_genre -> game_price -> game_release_date
    ('Octopath Traveler 2','RPG', 79.99, '2023-02-24'),
	('Fire Emblem Engage','RPG', 79.99, '2023-01-20'),
	('Final Fantasy XIV','MMO', 24.99, '2010-09-30'); # close the statement with a ;

SELECT * FROM video_games; # returns all rows and all columns from video_games