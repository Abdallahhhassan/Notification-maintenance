package notfier;

import users.Professor;
import users.Student;
import users.TA;


public interface Subject {
    public void subscribeProfessorForEmailNotification(Professor professor);
    public void subscribeProfessorForSMSNotification(Professor professor);
    public void subscribeTAForEmailNotification(TA ta);
    public void subscribeTAForSMSNotification(TA ta);
    public void subscribeStudentForEmailNotification(Student student);
    public void subscribeStudentForSMSNotification(Student student);
    public void notifyallUsers(String [] placeholders);
    public void removeUser();
}
