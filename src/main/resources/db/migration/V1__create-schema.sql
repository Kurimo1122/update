CREATE TABLE user (
  id INT NOT NULL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email VARCHAR(50),
  password VARCHAR(100)
);

CREATE TABLE role (
  id INT NOT NULL PRIMARY KEY,
  name VARCHAR(100)
);
