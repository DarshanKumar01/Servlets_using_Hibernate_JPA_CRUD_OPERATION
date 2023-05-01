package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.StudentDao;
import dto.*;

@WebServlet("/insert")
public class StudentController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("sid");
		int id1 = Integer.parseInt(id);

		String name = req.getParameter("sname");

		String gender = req.getParameter("gender");

		long phno = Long.parseLong(req.getParameter("phno"));

		System.out.println(id1);
		System.out.println(name);
		System.out.println(gender);
		System.out.println(phno);

		StudentDto sd = new StudentDto();
		sd.setSid(id1);
		sd.setSname(name);
		sd.setGender(gender);
		sd.setPhno(phno);

		StudentDao studentdao = new StudentDao();
		studentdao.create(sd);

		res.getWriter().println("Entered information is :");
		res.getWriter().println(id1);
		res.getWriter().println(name);
		res.getWriter().println(gender);
		res.getWriter().println(phno);

	}

}
