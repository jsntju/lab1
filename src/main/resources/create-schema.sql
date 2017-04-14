
-- Creation de la table post
 CREATE TABLE POST (
  ID INT primary key AUTO_INCREMENT,
  CONTENT varchar(140),
  AUTHOR varchar(50)
);


create table users(
      username varchar_ignorecase(50) not null primary key,
      ID INT,
      password varchar_ignorecase(250) not null,
      name varchar_ignorecase(50) NOT NULL,
      lastname varchar_ignorecase(50) NOT NULL,
      adress varchar_ignorecase(50) NOT NULL,
      city varchar_ignorecase(50) NOT NULL,
      mail varchar_ignorecase(250) NOT NULL,
      enabled boolean not null);




  create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null);
      create unique index ix_auth_username on authorities (username,authority);
ALTER TABLE authorities
ADD id INT;


-- Table des likes
create table likeTable (
  ID INT primary key AUTO_INCREMENT,
  IDPost INT,
  IDAuthor varchar(50),
 CONSTRAINT fk_post          -- On donne un nom à notre clé
   FOREIGN KEY (IDPost)             -- Colonne sur laquelle on crée la clé
   REFERENCES POST(ID)  ,     -- Colonne de référence
 CONSTRAINT fk_author          -- On donne un nom à notre clé
   FOREIGN KEY (IDAuthor)             -- Colonne sur laquelle on crée la clé
    REFERENCES users(username)        -- Colonne de référence
);

-- Table des commentaires

create table comments (
  ID INT primary key AUTO_INCREMENT,
  IDPost INT,
  IDAuthor varchar(50),
  CONTENT varchar(140),
  CONSTRAINT fk_postComment          -- On donne un nom à notre clé
  FOREIGN KEY (IDPost)             -- Colonne sur laquelle on crée la clé
  REFERENCES POST(ID)  ,     -- Colonne de référence
  CONSTRAINT fk_authorComment          -- On donne un nom à notre clé
  FOREIGN KEY (IDAuthor)             -- Colonne sur laquelle on crée la clé
  REFERENCES users(username)        -- Colonne de référence
);

