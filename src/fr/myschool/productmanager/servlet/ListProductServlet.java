package fr.myschool.productmanager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.myschool.productmanager.dao.OldProductDao;

@WebServlet(urlPatterns = "/listProduct")
@SuppressWarnings("serial")
public class ListProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("listProduct", OldProductDao.getAllProducts());

		req.getRequestDispatcher("listProduct.jsp").forward(req, resp);

		// PrintWriter out = resp.getWriter();

		// out.println("ServletResponse: " +ProductDao.getAllProducts());
	}
}
