DROP TABLE IF EXISTS bilet;

CREATE TABLE bilet (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  Author VARCHAR(250) NOT NULL
);

INSERT INTO bilet (name, Author) VALUES
  ('book1', 'Author1'),
  ('Book2', 'author2');