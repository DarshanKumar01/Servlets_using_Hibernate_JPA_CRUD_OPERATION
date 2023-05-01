package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import dao.*;

@Entity
public class StudentDto {

	@Override
	public String toString() {
		return "StudentDto [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", phno=" + phno + "]";
	}

	@Id
	private int sid;
	private String sname;
	private String gender;
	private long phno;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

}
