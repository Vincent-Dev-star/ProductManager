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

import fr.myschool.productmanager.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/cheaper")
public class CheaperProductsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");

		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT p.name FROM Product AS p WHERE p.price < 100");

		List<Product> products = query.getResultList();

		req.setAttribute("listProductPrice", products);

		req.getRequestDispatcher("cheaper.jsp").forward(req, resp);
	}
}
