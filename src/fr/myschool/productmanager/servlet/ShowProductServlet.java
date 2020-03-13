package fr.myschool.productmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.myschool.productmanager.dao.OldProductDao;
import fr.myschool.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {

	private int id = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Product produits = OldProductDao.findProduct(0);
		 * 
		 * req.setAttribute("name", produits.getName()); req.setAttribute("description",
		 * produits.getDescription()); req.setAttribute("price", produits.getPrice());
		 * req.getRequestDispatcher("showProduct.jsp").forward(req, resp);
		 */

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");

		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p.name FROM Product AS p");
		Query query_des = em.createQuery("SELECT p.description FROM Product AS p");
		Query query_price = em.createQuery("SELECT p.price FROM Product AS p");
		Query query_id = em.createQuery("SELECT p.id FROM Product AS p");
		Query query_category = em.createQuery("SELECT c.name FROM Category AS c WHERE c.id=1");

		List<Product> products_id = query_id.getResultList();

		//query_category.setParameter("id", products_id.get(0));

		List<Product> products_name = query.getResultList();
		List<Product> products_des = query_des.getResultList();
		List<Product> products_price = query_price.getResultList();
		List<Product> products_category = query_category.getResultList();

		req.setAttribute("name", products_name.get(id));
		req.setAttribute("description", products_des.get(id));
		req.setAttribute("price", products_price.get(id));
		req.setAttribute("category", products_category.get(id));

		id++;
		req.getRequestDispatcher("showProduct.jsp").forward(req, resp);

		// Long id = Long.parseLong(req.getParameter("id"));

		// PrintWriter out = resp.getWriter();

		// out.println("Your Product is " + ProductDao.findProduct(id));

	}
}
