package controller;

import java.io.IOException;

import javax.persistence.Query;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.StudentDao;

@WebServlet("/fetchall")
public class Featchall extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("sid"));
		System.out.println(id);

		StudentDao dao = new StudentDao();
		Query up1 = dao.fetchall(id);

		res.getWriter().print(up1);

	}

}
