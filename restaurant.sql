 drop database restaurant; /*suprresssion de l'ancienne BD restaurant*/

-- création et utilisation de la BD restaurant
CREATE DATABASE IF NOT EXISTS restaurant;
USE restaurant;

-- création des tables de données Commande, Plat et Ingrédients
CREATE TABLE IF NOT EXISTS Commande (
	ID_Commande int NOT NULL primary key auto_increment, 
	nom varchar(100) not null, 
	`date` varchar(100), 
	total float, 
	numTable int
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS Plat (
	ID_Plat int NOT NULL primary key auto_increment, 
	nom varchar(100) not null, 
	tarif float
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS Ingredients (
	ID_Ingredient int NOT NULL primary key auto_increment, 
	nom varchar(100) not null
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1;

-- créationdes tables relationnels Commande_Plat et Plat_Ingrédients
CREATE TABLE IF NOT EXISTS Commande_Plat (
	ID_Commande_Plat int NOT NULL PRIMARY KEY auto_increment,
	ID_Commande int,
	ID_Plat int,
	CONSTRAINT FK_Commande_plat_ID_Commande FOREIGN KEY (ID_Commande) REFERENCES COMMANDE (ID_Commande) ON DELETE RESTRICT,
	CONSTRAINT FK_Commande_plat_ID_Plat FOREIGN KEY (ID_Plat) REFERENCES PLAT (ID_Plat) ON DELETE RESTRICT
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS Plat_Ingredients (
	ID_Plat int,
	ID_Ingredient int,
	CONSTRAINT FK_Plat_Ingredients_ID_Plat FOREIGN KEY (ID_Plat) REFERENCES PLAT (ID_Plat) ON DELETE RESTRICT,
	CONSTRAINT FK_Plat_Ingredients_ID_Ingredient FOREIGN KEY (ID_Ingredient) REFERENCES INGREDIENTS (ID_Ingredient) ON DELETE RESTRICT,
	quantite int
)  ENGINE=InnoDB  DEFAULT CHARSET=latin1;


-- insertion des éléments dans les tables de données Commande, Plat et Ingredients
 INSERT INTO Commande (nom, `date`, total, numTable) 
 VALUES  
 ("BERTRAND", '2017-08-22', 108.3, 8),
 ("DUPONT", '2017-08-22', 85.6, 6),
 ("AMBERT", '2017-08-22', 210.8, 2),
 ("MARCELIN", '2017-04-21', 108.3, 5),
 ("AMBERT", '2017-04-21', 56.0, 2);
 
 INSERT INTO Plat (nom, tarif) 
 VALUES 
 ("Pizza", 12.3),
 ("Rôti", 17.8),
 ("tarte", 7.5),
 ("frites", 6.3);
 
 INSERT INTO Ingredients (nom) 
 VALUES 
 ("farine"),
 ("pomme de terre"),
 ("rôti de porc"),
 ("tomate"),
 ("jambon"),
 ("fromage"),
 ("sucre"),
 ("beurre"),
 ("oignon"),
 ("huile"),
 ("pomme");
 
 -- insertion dans les tables relationnelles Commande_Plat et Plat_Ingredient 
 INSERT INTO Commande_Plat (ID_Commande, ID_Plat)
 VALUES
 (1,2), (1,4),
 (2,1), (2,3),
 (3,1), (3,2), (3,3), (3,4),
 (4,1), (4,2), (4,3),
 (5,4), (5,4);
 
 INSERT INTO Plat_Ingredients (ID_Plat, ID_Ingredient, quantite)
 VALUES
 (1,1,1), (1,4,2), (1,5,1),
 (2,3,1), (2,4,3), (2,8,1), (2,9,2),
 (3,1,1), (3,7,1), (3,11,5),
 (4,2,6), (4,10,1);