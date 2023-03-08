CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  surname VARCHAR(30),
  postcount int
);

INSERT INTO users (name , surname, postcount) VALUE ('gabriele','albero', 7);
