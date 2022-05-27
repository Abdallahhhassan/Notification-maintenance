package users;

import java.sql.Date;

public class Professor extends User {
	String department;
	Date hirringDate;
	String phdtopic;



	public Professor(String name, String department, Date hirringDate, String phDTopic, String email,
					 String phoneNumber) {
		super();
		this.name = name;
		this.department = department;
		this.hirringDate = hirringDate;
		phdtopic = phDTopic;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getHirringDate() {
		return hirringDate;
	}
	public void setHirringDate(Date hirringDate) {
		this.hirringDate = hirringDate;
	}
	public String getPhDTopic() {
		return phdtopic;
	}
	public void setPhDTopic(String phDTopic) {
		phdtopic = phDTopic;
	}



}
