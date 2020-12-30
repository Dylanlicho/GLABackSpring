drop database if exists gla;

create database if not exists gla;

use gla;

create table users (
    id int not null auto_increment primary key,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    login varchar(255) not null,
    password varchar(255) not null,
    address varchar(255)
);

create table articles (
    id int not null auto_increment primary key,
    name varchar(255) not null,
    description varchar(255) not null,
    seller int not null,
    startPrice double not null,
    startDate datetime not null,
    endDate datetime not null,
    weight double not null,
    constraint foreign key(seller) references users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- user participate in article
create table participation (
    idUser int not null,
    idArticle int not null,
    price double not null,
    primary key (idUser, idArticle),
    constraint foreign key(idUser) references users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    constraint foreign key(idArticle) references articles(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table categories (
    id int not null auto_increment primary key,
    name varchar(255),
    unique(name)
);

-- article is of category
create table of_category (
    idArticle int not null,
    idCategory int not null,
    primary key (idArticle, idCategory),
    constraint foreign key(idArticle) references articles(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    constraint foreign key(idCategory) references categories(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

INSERT INTO users (firstname, lastname, login, password, address) VALUES('Jean', 'Luc', 'xxDarkJeanLucxx', 'jaimelesfleurs', '10 rue du jardin 54500'),
    ('Didier', 'Gal', 'Michemiche', 'jaimelalogique', '27 rue de l ennuie 26356'),
    ('Kevin', 'Louche', 'Imasodark', 'noIdea', '27 rue de l ennuie 54400'),
    ('test', 'test', 'test', 'test', 'test adress');

INSERT INTO categories(name) VALUES ('meuble'), ('biblo'), ('livre'), ('bijoux'), ('autre');

-- Luc sell 'machin', a 'meuble' and a 'biblo'
INSERT INTO articles (name, description, seller, startPrice, startDate, endDate, weight) VALUES('Imprimante', 'Imprimante XXXX en bon état, jamais utilisée', 1, 12.50, '2020-12-05 14:00:00', '2020-12-25 12:00:00', 2.5);
INSERT INTO of_category (idArticle,idCategory) VALUES (1,1), (1,2);

-- Gal and Kevin participate in the auction 'machin'
INSERT INTO participation (idUser, idArticle, price) VALUES (2, 1, 20.00), (3, 1, 15.00);

-- Luc sell 'truc', a 'livre' and a 'bijoux' and a 'autre'
INSERT INTO articles (name, description, seller, startPrice, startDate, endDate, weight) VALUES('Machine à écrire', 'Machine à écrire ayant appartenu à Asterion le Bon en personne', 1, 120.00, '2020-12-06 10:30:00', '2020-12-15 20:00:00', 10.5);
INSERT INTO of_category (idArticle,idCategory) VALUES (2,3), (2,4), (2,5);

-- Gal and test participate in the auction 'truc'
INSERT INTO participation (idUser, idArticle, price) VALUES (2, 2, 200.00), (4, 2, 150.00);
