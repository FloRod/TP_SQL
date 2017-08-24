package fr.codevallee.formation.tp1;

import static spark.Spark.get;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

public class Router implements SparkApplication {
	
	public void init() {

		get("/exemple1", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			
			Connection connect =  ConnectionJDBC.SeConnecter();
			
			Statement stmt = connect.createStatement();
			String strSelect = "select nom, date, total, num_table from restaurant.Commande";
			ResultSet rset = stmt.executeQuery(strSelect);
			
			List <SortieNav> tabSqlCommande = new ArrayList<SortieNav>();
			
			while (rset.next()) {
				tabSqlCommande.add(new SortieNav(rset.getString("nom"), rset.getString("date"),rset.getDouble("total"), rset.getInt("num_table")));
			}
			attributes.put("tabSqlCommande", tabSqlCommande);
			return new ModelAndView(attributes, "home.ftl");
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