package fr.codevallee.formation.tp;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.codevallee.formation.tp.modele.Adresse;
import fr.codevallee.formation.tp.modele.Article;
import fr.codevallee.formation.tp.modele.ArticleDescription;
import fr.codevallee.formation.tp.modele.Client;
import fr.codevallee.formation.tp.modele.Facture;
import fr.codevallee.formation.tp.modele.LigneFacture;
import fr.codevallee.formation.tp.modele.Statut;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;



public class Router implements SparkApplication {

	public void init() {

		get("/maj", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			ArticleDescription description1 = new ArticleDescription("Marteau massif en or");
			ArticleDescription description2 = new ArticleDescription("Scie coupante en argent");
			ArticleDescription description3 = new ArticleDescription("tourevis tournant");
			ArticleDescription description4 = new ArticleDescription("vis perforrante fileté");
			ArticleDescription description5 = new ArticleDescription("une peluche");
			
			entityManager.getTransaction().begin();
			entityManager.persist(description1);
			entityManager.persist(description2);
			entityManager.persist(description3);
			entityManager.persist(description4);
			entityManager.persist(description5);
			entityManager.getTransaction().commit();
			
			Article article1= new Article("Marteau A", 300, description1);
			Article article2= new Article("Scie 1", 100, description2);
			Article article3= new Article("Scie 2", 150, description2);
			Article article4= new Article("Tourevis A", 50, description3);
			Article article5= new Article("Tourevis B", 60, description3);
			Article article6= new Article("Tourevis C", 70, description3);
			Article article7= new Article("Tourevis C", 70, description4);
			Article article8= new Article("Nounours", 25, description5);
			Article article9= new Article("dauphin", 40, description5);
			
			entityManager.getTransaction().begin();
			entityManager.persist(article1);
			entityManager.persist(article2);
			entityManager.persist(article3);
			entityManager.persist(article4);
			entityManager.persist(article5);
			entityManager.persist(article6);
			entityManager.persist(article7);
			entityManager.persist(article8);
			entityManager.persist(article9);
			entityManager.getTransaction().commit();
			
			Adresse adresse1 = new Adresse("rue Anatole France", 63200, "RIOM");
			Adresse adresse2 = new Adresse("rue Henri Legay", 69069, "VILLEURBANNE");
			Adresse adresse3 = new Adresse("rue Tolstoi", 69069, "VILLEURBANNE");
			Adresse adresse4 = new Adresse("rue Apollinaire", 63970, "AYDAT");
			Adresse adresse5 = new Adresse("rue Risoli", 42000, "Saint-Etienne");
			
			entityManager.getTransaction().begin();
			entityManager.persist(adresse1);
			entityManager.persist(adresse2);
			entityManager.persist(adresse3);
			entityManager.persist(adresse4);
			entityManager.persist(adresse5);
			entityManager.getTransaction().commit();
			
			Set<Adresse> tabAdresse = new HashSet<Adresse>();
			tabAdresse.add(adresse1);
			Client client1 = new Client("AAAAA", "Pierre", adresse1, tabAdresse, null);
			tabAdresse.add(adresse2);
			Client client2 = new Client("BBBBB", "Paul", adresse2, tabAdresse, null);
			tabAdresse.add(adresse3);
			Client client3 = new Client("BBBBB", "Jacque", adresse3, tabAdresse, null);
			tabAdresse.add(adresse4);
			Client client4 = new Client("BBBBB", "Jacque", adresse3, tabAdresse, null);
			tabAdresse.add(adresse5);
			Client client5 = new Client("BBBBB", "Marie", adresse5, tabAdresse, null);
			
			entityManager.getTransaction().begin();
			entityManager.persist(client1);
			entityManager.persist(client2);
			entityManager.persist(client3);
			entityManager.persist(client4);
			entityManager.persist(client5);
			entityManager.getTransaction().commit();
			
			LigneFacture ligne1 = new LigneFacture(1, article1);
			LigneFacture ligne2 = new LigneFacture(2, article2);
			LigneFacture ligne3 = new LigneFacture(3, article3);
			LigneFacture ligne4 = new LigneFacture(4, article4);
			LigneFacture ligne5 = new LigneFacture(5, article5);
			LigneFacture ligne6 = new LigneFacture(4, article6);
			LigneFacture ligne7 = new LigneFacture(3, article7);
			LigneFacture ligne8 = new LigneFacture(2, article8);
			LigneFacture ligne9 = new LigneFacture(1, article9);
			
			entityManager.getTransaction().begin();
			entityManager.persist(ligne1);
			entityManager.persist(ligne2);
			entityManager.persist(ligne3);
			entityManager.persist(ligne4);
			entityManager.persist(ligne5);
			entityManager.persist(ligne6);
			entityManager.persist(ligne7);
			entityManager.persist(ligne8);
			entityManager.persist(ligne9);
			entityManager.getTransaction().commit();
			
			Set<LigneFacture> tabFacture1 = new HashSet<LigneFacture>();
			tabFacture1.add(ligne1);
			tabFacture1.add(ligne3);
			tabFacture1.add(ligne6);
			
			Set<LigneFacture> tabFacture2 = new HashSet<LigneFacture>();
			tabFacture1.add(ligne4);
			tabFacture1.add(ligne8);
			tabFacture1.add(ligne6);
			tabFacture1.add(ligne2);
			
			Set<LigneFacture> tabFacture3 = new HashSet<LigneFacture>();
			tabFacture1.add(ligne1);
			tabFacture1.add(ligne3);
			
			Set<LigneFacture> tabFacture4 = new HashSet<LigneFacture>();
			tabFacture1.add(ligne1);
			tabFacture1.add(ligne2);
			tabFacture1.add(ligne3);
			tabFacture1.add(ligne4);
			
			Facture facture1 = new Facture(client1, tabFacture1, "2017-08-30", Statut.PAYE);
			Facture facture2 = new Facture(client2, tabFacture2, "2017-08-15", Statut.PAYE);
			Facture facture3 = new Facture(client3, tabFacture3, "2017-08-10", Statut.NON_PAYE);
			Facture facture4 = new Facture(client3, tabFacture4, "2017-08-03", Statut.PAYE);
			
			entityManager.getTransaction().begin();
			entityManager.persist(facture1);
			entityManager.persist(facture2);
			entityManager.persist(facture3);
			entityManager.persist(facture4);
			entityManager.getTransaction().commit();
			
			Set<Facture> tabClientFacture = new HashSet<Facture>();
			tabClientFacture.add(facture1);
			client1.setFactures(tabClientFacture); 
			tabClientFacture.clear();
			tabClientFacture.add(facture2);
			client2.setFactures(tabClientFacture);
			tabClientFacture.clear();
			tabClientFacture.add(facture3);
			tabClientFacture.add(facture4);
			client2.setFactures(tabClientFacture);
			
			entityManager.getTransaction().begin();
			entityManager.persist(client1);
			entityManager.persist(client2);
			entityManager.persist(client3);
			entityManager.getTransaction().commit();
		
			
//			entityManager.close();
			
			return new ModelAndView(attributes, "maj.ftl");
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