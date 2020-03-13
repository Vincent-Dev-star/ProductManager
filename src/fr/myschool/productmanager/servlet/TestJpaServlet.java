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

import fr.myschool.productmanager.entity.TestEntity;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/testjpa")
public class TestJpaServlet extends HttpServlet{

	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TestEntity testEntity = new TestEntity("Hello from idk");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			//persist to BD
			em.persist(testEntity);
			t.commit();
		} finally {
			if(t.isActive()) {
				t.rollback();
			}em.close();
		}
		resp.getWriter().println("TestEntity inserted with id " + testEntity.getId());
	}
	
	
	@Override
	public void destroy() {
		if(emf != null && emf.isOpen()){
			emf.close();
		}
	}
}
