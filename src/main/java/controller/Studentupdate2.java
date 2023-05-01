package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.StudentDao;

@WebServlet("/update")
public class Studentupdate2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("sid"));
		String name = req.getParameter("sname");
		String gender = req.getParameter("gender");
		long phno = Long.parseLong(req.getParameter("phno"));

		System.out.println(id);
		System.out.println(name);
		System.out.println(gender);
		System.out.println(phno);

		StudentDao dao = new StudentDao();
		String up = dao.update(id, name, gender, phno);

		res.getWriter().println("Entered information is :");
		res.getWriter().println(id);
		res.getWriter().println(name);
		res.getWriter().println(gender);
		res.getWriter().println(phno);

		res.getWriter().print(up);
	}

}
