package fr.myschool.productmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.myschool.productmanager.dao.OldProductDao;

@SuppressWarnings("serial")
@WebServlet(urlPatterns =("/auth/removeProduct"))
public class RemoveProductServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));		
		
		if(id != null)
		{
			OldProductDao.removeProduct(id);
		}
		
		resp.sendRedirect("/ProductManager/listProduct.jsp");
	}
}
