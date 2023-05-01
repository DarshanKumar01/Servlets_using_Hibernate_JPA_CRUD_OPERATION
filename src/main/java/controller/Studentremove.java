package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.StudentDao;

@WebServlet("/remove")
public class Studentremove extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String sid = req.getParameter("sid");
		int sid1 = Integer.parseInt(sid);

		StudentDao dao = new StudentDao();

		String msg = dao.delete(sid1);

		res.getWriter().print(msg);
	}

}
