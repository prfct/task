CREATE TABLE IF NOT EXISTS flower (
  flower_id INT NOT NULL AUTO_INCREMENT,
  name      VARCHAR(64),
  colour    VARCHAR(64),
  freshness VARCHAR(64),
  steam     INT(11),
  PRIMARY KEY (flower_id)
)
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS tree (
  tree_id INT NOT NULL AUTO_INCREMENT,
  name    VARCHAR(64),
  size    VARCHAR(64),
  PRIMARY KEY (tree_id)
)
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS accessories (
  accessories_id INT NOT NULL AUTO_INCREMENT,
  type           VARCHAR(64),
  PRIMARY KEY (accessories_id)
)
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS bouquet (
  bouquet_id INT NOT NULL AUTO_INCREMENT,
  title      VARCHAR(64),
  price      INT(11),
  PRIMARY KEY (bouquet_id)
)
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS bouquet_flower (
  bouquet_flower_id INT NOT NULL AUTO_INCREMENT,
  bouquet_id        INT,
  CONSTRAINT fk_bouquet_bouquet_flower FOREIGN KEY (bouquet_id) REFERENCES bouquet (bouquet_id),
  flower_id         INT,
  CONSTRAINT fk_flower_bouquet_flower FOREIGN KEY (flower_id) REFERENCES flower (flower_id),
  quantity          INT,
  PRIMARY KEY (bouquet_flower_id)
)
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS bouquet_tree (
  bouquet_tree_id INT NOT NULL AUTO_INCREMENT,
  bouquet_id      INT,
  CONSTRAINT fk_bouquet_bouquet_tree FOREIGN KEY (bouquet_id) REFERENCES bouquet (bouquet_id),
  tree_id         INT,
  CONSTRAINT fk_tree_bouquet_tree FOREIGN KEY (tree_id) REFERENCES tree (tree_id),
  quantity        INT,
  PRIMARY KEY (bouquet_tree_id)
)
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS bouquet_accessories (
  bouquet_accessories_id INT NOT NULL AUTO_INCREMENT,
  bouquet_id             INT,
  CONSTRAINT fk_bouquet_bouquet_accessories FOREIGN KEY (bouquet_id) REFERENCES bouquet (bouquet_id),
  accessories_id         INT,
  CONSTRAINT fk_accessories_bouquet_accessories FOREIGN KEY (accessories_id) REFERENCES accessories (accessories_id),
  PRIMARY KEY (bouquet_accessories_id)
)
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

