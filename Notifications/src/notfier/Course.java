package notfier;
import java.util.ArrayList;

import gateways.EmailGateway;
import messages.TaskAddedEmailMessage;
import users.Professor;
import users.Student;
import users.TA;

public class Course implements Subject {

	String name;
	String code;
	ArrayList<String> announcements;
	ArrayList<String> exams;
	ArrayList<String> grades;

	ArrayList<Professor> professorsForEmailNotification;
	ArrayList<Professor> professorsForSmsNotification;

	ArrayList<TA> taForEmailNotification;
	ArrayList<TA> taForSmsNotification;

	ArrayList<Student> studentsForEmailNotification;
	ArrayList<Student> studentsForSMSNotification;

	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;

		announcements = new ArrayList<>();
		exams = new ArrayList<>();
		grades = new ArrayList<>();

		professorsForEmailNotification = new ArrayList<>();
		professorsForSmsNotification = new ArrayList<>();

		taForEmailNotification = new ArrayList<>();
		taForSmsNotification = new ArrayList<>();

		studentsForEmailNotification = new ArrayList<>();
		studentsForSMSNotification = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public void subscribeProfessorForEmailNotification(Professor professor) {
		professorsForEmailNotification.add(professor);
	}
	@Override
	public void subscribeProfessorForSMSNotification(Professor professor) {
		professorsForSmsNotification.add(professor);
	}
	@Override
	public void subscribeTAForEmailNotification(TA ta) {
		taForEmailNotification.add(ta);
	}
	@Override
	public void subscribeTAForSMSNotification(TA ta) {
		taForSmsNotification.add(ta);
	}
	@Override
	public void subscribeStudentForEmailNotification(Student student) {
		studentsForEmailNotification.add(student);
	}
	@Override
	public void subscribeStudentForSMSNotification(Student student) {
		studentsForSMSNotification.add(student);
	}

	public void addAssignment(String assignName, String assignBody) {
		announcements.add(assignName);
		String[]  placeholders = new String[] {assignName, assignBody};
		// do some logic here

		notifyallUsers(placeholders);
	}

	// AddExam, PostGrades, PostAnnouncement  will be the same
	@Override
	public void notifyallUsers(String [] placeholders) {
		// notify users by email
		TaskAddedEmailMessage msg = new TaskAddedEmailMessage();
		String [] notification = msg.prepareMessage(placeholders);

		// open connection for Email gateway and do some configurations to the object

		EmailGateway emailGateway = new EmailGateway();


		for (Professor professor : professorsForEmailNotification) {
			professor.update(notification);
			emailGateway.sendMessage(notification, professor.getEmail());
		}

		for (TA ta : taForEmailNotification) {
			ta.update(notification);
			emailGateway.sendMessage(notification, ta.getEmail());
		}

		for (Student student : studentsForSMSNotification) {
			student.update(notification);
			emailGateway.sendMessage(notification, student.getEmail());
		}
	}

	@Override
	public void removeUser() {
		// remove user
	}




}