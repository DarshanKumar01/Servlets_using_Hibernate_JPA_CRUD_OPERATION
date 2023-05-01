package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.StudentDao;

@WebServlet("/fetch")
public class Studentfetch extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("sid"));
		System.out.println(id);

		StudentDao dao = new StudentDao();
		String up = dao.fetch(id);

		res.getWriter().print("User entered id is :" + id + "\n");
//		
		res.getWriter().print(up);
	}

}
