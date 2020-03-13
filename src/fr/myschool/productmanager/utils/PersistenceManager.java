package fr.myschool.productmanager.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEmf() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
		}
		return emf;

	}

	public static void closeEmf() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}

}
