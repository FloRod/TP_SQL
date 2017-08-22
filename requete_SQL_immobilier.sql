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
/*requête imbriquée*/
SELECT *
FROM personne
WHERE idPersonne IN
    (SELECT idPersonne
     FROM demande
     WHERE categorie = "vente")
ORDER BY idPersonne
LIMIT 3;

/*requête join*/
SELECT demande.*
FROM personne
INNER JOIN demande ON personne.idPersonne = demande.idPersonne
WHERE categorie = "vente"
ORDER BY idPersonne
LIMIT 3;

/*Question 17 : Affichez le prénom du vendeur pour le logement ayant la référence « 5770 »*/
SELECT prenom
FROM personne
INNER JOIN logement_personne ON personne.idPersonne = logement_personne.idPersonne
WHERE idLogement = 5770;

/*Question 18 : Affichez les prénoms des personnes souhaitant accéder à un logement sur la ville de Lyon*/
SELECT prenom
FROM personne
INNER JOIN demande ON personne.idPersonne = demande.idPersonne
WHERE ville = "lyon";

/*Question 19 : Affichez les prénoms des personnes souhaitant accéder à un logement en location sur la ville de Paris*/
SELECT prenom
FROM personne
INNER JOIN demande ON personne.idPersonne = demande.idPersonne
WHERE ville = "paris"
  AND categorie = "location";

/*Question 20 : Affichez les prénoms des personnes souhaitant acheter un logement de la plus grande à la plus petite superficie*/
SELECT prenom,
       superficie
FROM personne
INNER JOIN demande ON personne.idPersonne = demande.idPersonne
WHERE categorie = "vente"
ORDER BY superficie DESC;

/*Question 21 : Quel sont les prix finaux proposés par les agences pour la maison à la vente ayant la référence « 5091 » ? (Alias : prix frais d'agence
inclus)*/ 
SELECT (frais + prix) AS `prix frais d'agence`
FROM logement
INNER JOIN logement_agence ON logement.idLogement = logement_agence.idLogement
WHERE logement.idLogement = 5091;

/*Question 23 : Si l’ensemble des logements étaient vendus ou loués demain, quel serait le bénéfice généré grâce aux frais d’agence et pour chaque agence
(Alias : benefice, classement : par ordre croissant des gains)*/
SELECT sum(frais) AS benefice,
       nom
FROM logement_agence
INNER JOIN agence ON logement_agence.idAgence = agence.idAgence
GROUP BY agence.idAgence
ORDER BY benefice;

/*Question 24 : Affichez les id des biens en location, les prix, suivis des frais d’agence (classement : dans l’ordre croissant des prix)*/ 



/*Question 25 : Quel est le prénom du propriétaire proposant le logement le moins cher à louer ?*/



/*Question 26 : Affichez le prénom et la ville où se trouve le logement de chaque propriétaire*/



/*Question 27 : Quel est l’agence immobilière s’occupant de la plus grande gestion de logements répertoriés à Paris ? (alias : nombre, classement : trié par
ordre décroissant)*/



/*Question 28 : Affichez le prix et le prénom des vendeurs dont les logements sont proposés à 130000 € ou moins en prix final avec frais appliqués par les
agences (alias : prix final, classement : ordre croissant des prix finaux) :*/


/*Question 29 : Afficher toutes les demandes enregistrées avec la personne à l'origine de la demande (Afficher également les demandes d'anciennes personnes n'existant plus dans notre base de données).*/



/*Question 30 : Afficher toutes les personnes enregistrées avec leur demandes correspondantes (Afficher également les personnes n'ayant pas formulé de demandes).*/
