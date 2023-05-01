package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.StudentDao;

@WebServlet("/singleupdate")
public class Singleupdate extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("sid"));

		long phno = Long.parseLong(req.getParameter("phno"));

		StudentDao dao = new StudentDao();
		String up = dao.singleupdate(id, phno);

	}

}
