package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.StudentDao;
import dto.StudentDto;

@WebServlet("/fetch12")
public class Fetch extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("sid"));

		StudentDao dao = new StudentDao();
		StudentDto d1 = dao.fetchByid(id);
		res.getWriter().print(d1);
	}

}
