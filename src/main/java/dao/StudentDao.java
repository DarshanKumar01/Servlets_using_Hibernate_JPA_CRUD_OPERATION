package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import javax.persistence.Persistence;

import com.mysql.cj.Query;

import dto.*;

public class StudentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void create(StudentDto student) {

		et.begin();
		em.persist(student);
		et.commit();

	}

	public String delete(int d1) {

		StudentDto std = em.find(StudentDto.class, d1);

		if (std != null) {
			et.begin();
			em.remove(std);
			et.commit();
			return "Data is deleted";
		}

		else

			return "No data found";

	}

	public String update(int u1, String name, String gender, Long phno) {
		StudentDto std = em.find(StudentDto.class, u1);

		if (std != null) {
			std.setSid(u1);
			std.setSname(name);
			std.setGender(gender);
			std.setPhno(phno);

			et.begin();
			em.merge(std);
			et.commit();
			return "updated";

		} else {
			return "Data not found not updated";

		}

	}

	public String singleupdate(int id, Long phno) {

		StudentDto std = em.find(StudentDto.class, id);
		if (std != null) {
			std.setSid(id);
			std.setPhno(phno);

			et.begin();
			em.merge(std);
			et.commit();
			return "updated";
		} else {
			return "Data not found not updated";

		}

	}

	public String fetch(int id) {

		StudentDto std = em.find(StudentDto.class, id);
		if (std != null) {

			std.setSid(id);
			int s = std.getSid();
			String a = std.getSname();
			String c = std.getGender();
			Long l = std.getPhno();

			System.out.println("Student id" + s);
			System.out.println("Student name" + a);

			et.begin();
			em.contains(std);
			et.commit();

			return " Student name :" + a + "\n" + " Student id :" + s + "\n" + " Student Gender :" + c + "\n"
					+ " Student phno :" + l;
		} else {
			return "DAta is not present in the database";
		}
	}

	// Fetch by id

	public StudentDto fetchByid(int id) {
		StudentDto dto = em.find(StudentDto.class, id);
		return dto;
	}

	// Fetch by id alll

	public javax.persistence.Query fetchall(int id) {
		javax.persistence.Query q = em.createQuery("select data from StudentDto data");
		List<StudentDto> list = q.getResultList();

		return q;
	}

}
