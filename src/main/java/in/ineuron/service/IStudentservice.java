package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Student;

public interface IStudentservice {

	public Long getStudentIdbyemail(String studentemail);

	public List<Student> getStudents();

	public void saveStudent(Student student);

	public Student getStudent(Integer student_id);

	public void deleteStudent(Integer student_id);

	public boolean getLoginValidation(String email, String password);

	public boolean issuebook(Integer bookId, Integer studentid);

	public void makefinezero(Integer studentid);

}
