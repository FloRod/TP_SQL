USE immobilier;

/*Question 1 : Affichez le nom des agences*/
SELECT nom
FROM agence;

/*Question 2 : Affichez le numéro de l’agence « Orpi »*/
SELECT idAgence
FROM agence
WHERE nom = "orpi" ;

/*Question 3 : Affichez le premier enregistrement de la table logement*/
SELECT *
FROM logement
LIMIT 1;

/*Question 4 : Affichez le nombre de logements (Alias : Nombre_de_logements)*/
SELECT COUNT(*) AS Nombre_de_logement
FROM logement;

/*Question 5 : Affichez les logements à vendre à moins de 150 000 € dans l’ordre croissant des prix.*/
SELECT *
FROM logement
WHERE categorie = "vente"
  AND prix < 150000
ORDER BY prix;

/*Question 6 : Affichez le nombre de logements à la location (alias : nombre)*/
SELECT COUNT(*) AS nombre
FROM logement
WHERE categorie = "location";

/*Question 7 : Affichez les villes différentes recherchées par les personnes demandeuses d'un logement*/
SELECT DISTINCT ville
FROM demande;

/*Question 8 : Affichez le nombre de biens à vendre par ville*/
SELECT COUNT(*) AS nombre_vente,
       ville
FROM logement
WHERE categorie = "vente"
GROUP BY ville;

/*Question 9 : Quelles sont les id des logements destinés à la location ?*/
SELECT idLogement
FROM logement
WHERE categorie = "location";

/*Question 10 : Quels sont les id des logements entre 20 et 30m² ?*/
SELECT idLogement,
       ville,
       categorie
FROM logement
WHERE superficie BETWEEN 20 AND 30 ;

/*Question 11 : Quel est le prix vendeur (hors commission) du logement le moins cher à vendre ? (Alias : prix minimum)*/
SELECT MIN(prix) AS prix_minimum
FROM logement
WHERE categorie = "vente";

/*Question 12 : Dans quelle ville se trouve les maisons à vendre ?*/
SELECT DISTINCT ville
FROM logement
WHERE genre = "maison"
  AND categorie = "vente";

/*Question 13 : L’agence Orpi souhaite diminuer les frais qu’elle applique sur le logement ayant l'id « 5246 ». Passer les frais de ce logement de 800 à 730€*/
UPDATE logement
SET prix = 730
WHERE idLogement = 5246;
/*vérification : SELECT prix FROM immobilier.logement WHERE idLogement = 5246;*/ 

/*Question 14 : Quels sont les logements gérés par l’agence « laforet »*/
/*solution imbriquée*/
SELECT * 
FROM logement_agence
WHERE idAgence =
    (SELECT idAgence
     FROM agence
     WHERE nom = "laforet" );


SELECT *
FROM logement_agence
WHERE idAgence IN
    (SELECT idAgence
     FROM agence
     WHERE nom = "laforet");

/*solution jointure avec where*/
SELECT * 
FROM logement_agence,
     agence
WHERE logement_agence.idAgence = agence.idAgence
  AND Agence.nom = "laforet";

/*solution jointure avec join*/
SELECT * 
FROM logement_agence
INNER JOIN agence ON logement_agence.idAgence = agence.idAgence
WHERE Agence.nom = "laforet";

/*Question 15 : Affichez le nombre de propriétaires dans la ville de Paris (Alias : Nombre)*/
SELECT COUNT(DISTINCT idPersonne) AS Nombre
FROM logement_personne
INNER JOIN logement ON logement_personne.idLogement = logement.idLogement
WHERE logement.ville = "paris";

/*Question 16 : Affichez les informations des trois premieres personnes souhaitant acheter un logement*/