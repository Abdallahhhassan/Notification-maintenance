package users;

public class Student extends User {
	int id;


	public Student(String name, int id, String email, String phoneNumber) {
		super();
		this.name = name;
		this.id= id;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




}
