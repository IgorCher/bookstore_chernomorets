CREATE TABLE IF NOT EXISTS cover_types
    (
            id SERIAL PRIMARY KEY,
            cover_type VARCHAR (256)
        );


CREATE TABLE IF NOT EXISTS books
    (
        id BIGSERIAL PRIMARY KEY,
        author VARCHAR(256) NOT NULL,
        title VARCHAR (256) NOT NULL,
        year VARCHAR (4),
        price NUMERIC (10,2) NOT NULL,
        pages INT,
        isbn CHAR (13) UNIQUE NOT NULL,
        cover_type_id INT REFERENCES cover_types
    );