package fr.codevallee.formation.tp;

import static spark.Spark.get;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.codevallee.formation.tp.modele.Commande;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class Router implements SparkApplication {

	public void init() {

		// final Logger logger = LoggerFactory.getLogger(Router.class);

		// création des formulaies nécessaires à la recherche dans la table Commande de la BD restaurant
		get("/maj", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "maj.ftl");
		}, getFreeMarkerEngine());

		
		//ajout d'un nouvel élément dans la table Commande, avec les saisies des formulaires
		get("/resultat", (request, response) -> {

			Map<String, Object> attributes = new HashMap<>();

			// Exemple 1 (à déplacer dans une classe statique !):
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			// J'ajoute une commande :

			String nom = request.queryParams("nom");
			String date = "2017-08-24";
			double total = Double.parseDouble(request.queryParams("total"));
			int numTable = Integer.parseInt(request.queryParams("numTable"));

			Commande upCommande = new Commande();

			upCommande.setNom(nom);
			upCommande.setDate(date);
			upCommande.setTotal(total);
			upCommande.setNumTable(numTable);

			entityManager.getTransaction().begin();
			entityManager.persist(upCommande);
			entityManager.getTransaction().commit();
			entityManager.close();

			// attributes.put("nom", query.getResultList());
			attributes.put("nom", nom);
			attributes.put("date", date);
			attributes.put("total", total);
			attributes.put("numTable", numTable);

			return new ModelAndView(attributes, "resultat.ftl");
		}, getFreeMarkerEngine());

		
		// affichage de la table commande
		get("/home", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			Commande commande = new Commande();
			int i = 1;
			List<Commande> tabSqlCommande = new ArrayList<Commande>();
			do {
				commande = entityManager.find(Commande.class, i);
				if (commande != null){
					tabSqlCommande.add(commande);
				}
				
				i++;
			} while (commande != null);
			entityManager.close();
			attributes.put("tabSqlCommande", tabSqlCommande);

			return new ModelAndView(attributes, "home.ftl");
		}, getFreeMarkerEngine());
		
		
		// test annotation OneToOne, OneToMany avec les classes Commune, Maire et Elu
		get("/commune", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			{
				
				
				// création et sauvegarde de plusieurs instances / Entités de la classe / de la table commune et maire,
//				for (int i = 1; i<4; i++){
//					Commune commune = new Commune();
//					Maire maire = new Maire();
//					commune.setNom("Commune " + i);
//					maire.setNom("Maire " + i);
//					commune.setMaire(maire);
//					maire.setCommune(commune);
//					
//					entityManager.getTransaction().begin();
//					entityManager.persist(commune);
//					entityManager.persist(maire);
//					entityManager.getTransaction().commit();
//				}
				
				// recherche d'une entité par rapport à son id (type long) et suppression de celle-ci dans la table commune
				// tests en cascade avec des entités maire et commune
//				Commune commune = entityManager.find(Commune.class, 3L);
//				//Maire maire = entityManager.find(Maire.class, 12L);
//				entityManager.getTransaction().begin();
//				entityManager.remove(maire);
//				entityManager.getTransaction().commit();
				
				
				// recherche d'une entité par rapport à son id (type long) et maj d'un attribut/ valeur de la table
				Maire maire = entityManager.find(Maire.class, 14L);
				entityManager.getTransaction().begin();
				maire.setNom("Martin");
				entityManager.getTransaction().commit();
				
				
				// création et sauvegarde d'instances / Entités de la classe / de la table commune et maire,
				// tests en cascade avec des entités maire et commune
//				Commune commune = new Commune();
//				Maire maire = new Maire();
				
				//commune.setNom("ICI");
			//	commune.setNom("LaBas");
//				commune.setMaire(maire);
//				maire.setCommune(commune);
				
//				entityManager.getTransaction().begin();
//				entityManager.persist(commune);
//				entityManager.getTransaction().commit();
				
			}
			
			
			
			TypedQuery<Maire> query = entityManager.createQuery("from Maire", Maire.class);
			query.getResultList();
			attributes.put("objets", query.getResultList());


			
			return new ModelAndView(attributes, "commune.ftl");
		}, getFreeMarkerEngine());

	}

	private FreeMarkerEngine getFreeMarkerEngine() {
		FreeMarkerEngine engine = new FreeMarkerEngine();
		Configuration configuration = new Configuration(new Version(2, 3, 23));
		configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
		configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "");
		engine.setConfiguration(configuration);
		return engine;
	}

}