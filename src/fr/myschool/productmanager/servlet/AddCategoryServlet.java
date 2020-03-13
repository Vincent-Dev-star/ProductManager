package fr.myschool.productmanager.servlet;

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

import fr.myschool.productmanager.entity.Category;

@WebServlet(urlPatterns = "/auth/addCategory")
@SuppressWarnings("serial")
public class AddCategoryServlet extends HttpServlet {

	private EntityManagerFactory emf;

	@Override
	public void init() throws ServletException {

		emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
	}

	@Override
	public void destroy() {

		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long id = Long.parseLong(req.getParameter("category_id"));
		String name = req.getParameter("name");

		Category category = new Category(id, name);

		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();

		try {
			t.begin();

			em.persist(category);
			t.commit();
		} finally {
			if (t.isActive()) {
				t.rollback();
			}
			em.close();
		}
		
		resp.sendRedirect("/ProductManager/listProduct");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/auth/addCategory.jsp").forward(req, resp);
	}
}
