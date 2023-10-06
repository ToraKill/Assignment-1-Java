CREATE DATABASE tutoring;

USE tutoring;

CREATE TABLE video_games (

	game_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    game_title VARCHAR(200) NOT NULL,

	review_score int NOT NULL,

   sale DECIMAL(5,2) NOT NULL,
    
	    game_price DECIMAL(9,2) NOT NULL,

	release_console VARCHAR(200) NOT NULL,
    
    release_rating VARCHAR(2) NOT NULL,

    game_release_date INT NOT NULL,
    
    story_length INT NOT NULL
);
USE video_games;
SELECT * FROM video_games;
USE assignment2

SELECT * FROM video_games WHERE game_price > 19.99