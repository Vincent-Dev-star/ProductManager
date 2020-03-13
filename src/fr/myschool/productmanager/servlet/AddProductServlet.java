package fr.myschool.productmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.myschool.productmanager.entity.Category;
import fr.myschool.productmanager.entity.Product;
import fr.myschool.productmanager.utils.PersistenceManager;

@WebServlet(urlPatterns = "/auth/addProduct")
@SuppressWarnings("serial")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Long category_id = Long.parseLong(req.getParameter("category_id"));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");

		EntityManager em = emf.createEntityManager();

		// Query query = em.createQuery("SELECT p FROM Category AS p WHERE p.id= 1");

		// query.setParameter("id", category_id);

		// Category category = (Category) query.getResultList();

		Category category = new Category(3L, "jouet");

		Long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		float price = Float.parseFloat(req.getParameter("price"));
		Long category_id = Long.parseLong(req.getParameter("category_id"));

		Product product = new Product(id, name, description, price, category_id);

		// product.setCategory(category);

		EntityTransaction t = em.getTransaction();

		try {
			t.begin();

			em.persist(product);
			t.commit();
		} finally {
			if (t.isActive()) {
				t.rollback();
			}
			em.close();
		}

		/*
		 * Long id = 0L; //Long id = Long.parseLong(req.getParameter("id")); String name
		 * = req.getParameter("name"); String description =
		 * req.getParameter("description"); float price =
		 * Float.parseFloat(req.getParameter("price"));
		 * 
		 * Product product = new Product(id, name, description, price);
		 * 
		 * OldProductDao.addProduct(product);
		 * 
		 * id++;
		 */

		resp.sendRedirect("/ProductManager/showProduct");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
	
		EntityManager em = emf.createEntityManager();
		
		Query query_name = em.createQuery("SELECT p.name FROM Category AS p");
		Query query_id = em.createQuery("SELECT p.id FROM Category AS p");

		List<Category> category_name = query_name.getResultList();
		List<Category> category_id = query_id.getResultList();
		req.setAttribute("category", category_name);
		req.setAttribute("category_id", category_id);

		req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
	}
}
