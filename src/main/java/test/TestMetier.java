package test;

import java.util.List;

import dao.FormationDaoImpl;
import metier.entities.Formation;

public class TestMetier {
	

	
	public static void main(String[] args) {
		FormationDaoImpl pdao= new FormationDaoImpl();
		Formation prod= pdao.save(new Formation("Formation 8 plus",2800,"en personne"));
		System.out.println(prod);
		List<Formation> prods =pdao.formationsParMC("ip");
		for (Formation p : prods)
		System.out.println(p);
		}
}