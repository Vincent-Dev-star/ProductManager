package fr.myschool.productmanager.servlet;

import fr.myschool.productmanager.entity.Category;
import fr.myschool.productmanager.entity.Product;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/auth/basicInsert")
@SuppressWarnings("serial")
public class BasicInsertServlet extends HttpServlet {

	EntityManagerFactory emf;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");

		Category category = new Category(3L, "Start");

		Product productOurs = new Product(3L, "ours2", "jouetenor", 125F, category.getId());

		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();

		try {
			t.begin();

			em.persist(productOurs);
			t.commit();
		} finally {
			if (t.isActive()) {
				t.rollback();
			}
			em.close();
		}

	}
}
