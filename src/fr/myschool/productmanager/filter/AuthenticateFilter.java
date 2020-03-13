package fr.myschool.productmanager.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/auth/*" })
@SuppressWarnings("serial")
public class AuthenticateFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = req.getSession();

		System.out.println("Username recp: " + session.getAttribute("username"));

		if (session.getAttribute("username") == null || session.getAttribute("username").equals("")) {

			System.out.println("You can't pass");
			res.sendRedirect("/ProductManager/login.html");
		} else {
			System.out.println("You can pass");

			chain.doFilter(req, res);
		}

	}
}