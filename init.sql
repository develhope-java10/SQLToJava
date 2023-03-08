CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  surname VARCHAR(30),
  postcount int
);

INSERT INTO users (name , surname, postcount) VALUE ('gabriele','albero', 7);
INSERT INTO users (name, surname, postcount) VALUE ('marco', 'fiore', 10);
INSERT INTO users (name, surname, postcount) VALUE ('federica', 'rossi', 15);
INSERT INTO users (name, surname, postcount) VALUE ('marta', 'bianchi', 12);
INSERT INTO users (name, surname, postcount) VALUE ('giovanni', 'verdi', 5);



