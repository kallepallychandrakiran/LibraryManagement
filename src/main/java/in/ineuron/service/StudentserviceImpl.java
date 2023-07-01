package in.ineuron.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDAO;
import in.ineuron.model.Student;

@Service
public class StudentserviceImpl implements IStudentservice {

	@Autowired
	private IStudentDAO repo;

	@Override
	public Long getStudentIdbyemail(String studentemail) {
		return repo.findByStudentEmail(studentemail);
	}

	@Override
	public List<Student> getStudents() {
		return (List<Student>) repo.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		repo.save(student);
	}

	@Override
	public void makefinezero(Integer studentid) {
		Optional<Student> optional = repo.findById(studentid);
		Student student = optional.get();
		System.out.println(student);
		student.setFine_amount(0);
		student.setIssued_book_date(null);
		student.setIssued_book1(null);
		student.setIssued_book2(null);
		student.setIssued_book3(null);
		saveStudent(student);
		Optional<Student> std = repo.findById(studentid);
		Student std1 = std.get();
		System.out.println(std1);
	}

	@Override
	public Student getStudent(Integer student_id) {
		Optional<Student> optional = repo.findById(student_id);
		return optional.get();
	}

	@Override
	public void deleteStudent(Integer student_id) {
		Optional<Student> optionalStudent = repo.findById(student_id);
		Student student = optionalStudent.get();
		Integer fineAmount = student.getFine_amount();
		if (fineAmount == null || fineAmount == (Integer) 0) {
			repo.deleteById(student_id);
		}
	}

	@Override
	public boolean getLoginValidation(String email, String password) {
		return repo.existsByStudentEmailAndStudentPassword(email, password);
	}

	@Override
	public boolean issuebook(Integer bookId, Integer studentid) {
		Optional<Student> optional = repo.findById(studentid);
		Student student = optional.get();
		if (student.getIssued_book1() != null && student.getIssued_book2() != null
				&& student.getIssued_book3() != null) {
			return false;
		}

		if (student.getIssued_book1() == null) {
			student.setIssued_book1(bookId.toString());
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String datestr2 = currentDateTime.format(formatter);
			String datestr1 = student.getIssued_book_date();
			if (datestr1 != null) {
				LocalDate date1 = LocalDate.parse(datestr1, formatter);
				LocalDate date2 = LocalDate.parse(datestr2, formatter);
				LocalDate earlierDate = date1.isBefore(date2) ? date1 : date2;
				String date = earlierDate.format(formatter);
				student.setIssued_book_date(date);
				repo.save(student);
				return true;
			}
			if (datestr1 == null) {
				student.setIssued_book_date(datestr2);
				repo.save(student);
				return true;
			}
		}
		if (student.getIssued_book2() == null && student.getIssued_book1() != null
				&& student.getIssued_book3() == null) {
			student.setIssued_book2(bookId.toString());
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String datestr2 = currentDateTime.format(formatter);
			String datestr1 = student.getIssued_book_date();
			LocalDate date1 = LocalDate.parse(datestr1, formatter);
			LocalDate date2 = LocalDate.parse(datestr2, formatter);
			LocalDate earlierDate = date1.isBefore(date2) ? date1 : date2;
			String date = earlierDate.format(formatter);
			student.setIssued_book_date(date);
			repo.save(student);
			return true;

		}
		if (student.getIssued_book1() != null && student.getIssued_book2() != null) {
			student.setIssued_book3(bookId.toString());
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String datestr2 = currentDateTime.format(formatter);
			String datestr1 = student.getIssued_book_date();
			LocalDate date1 = LocalDate.parse(datestr1, formatter);
			LocalDate date2 = LocalDate.parse(datestr2, formatter);
			LocalDate earlierDate = date1.isBefore(date2) ? date1 : date2;
			String date = earlierDate.format(formatter);
			student.setIssued_book_date(date);
			repo.save(student);
			return true;

		} else {
			return false;
		}

	}

}
