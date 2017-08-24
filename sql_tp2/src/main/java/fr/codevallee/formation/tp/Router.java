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