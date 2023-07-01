package in.ineuron.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Book;
import in.ineuron.model.Student;
import in.ineuron.service.IAdminService;
import in.ineuron.service.IBookService;
import in.ineuron.service.IStudentservice;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	private IBookService bookService;
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IStudentservice studentservice;

	@GetMapping("/adminview")
	public String list(Map<String, Object> model) {
		List<Book> books = bookService.getBooks();
		model.put("books", books);
		return "adminView";
	}

	@PostMapping("/loginvalidate")
	public String loginvalidate(Map<String, Object> model, @RequestParam("admin_email") String email,
			@RequestParam("admin_password") String password) {
		boolean status = adminService.getLoginValidation(email, password);
		if (status) {
			return "redirect:/admin/adminview";
		} else {
			return "admin_login";
		}
	}

	@GetMapping("/showForm")
	public String showform(Map<String, Object> model) {
		Book book = new Book();
		model.put("book", book);
		return "addBook";
	}

	@GetMapping("/deletebook")
	public String deletebook(Map<String, Object> model, @RequestParam("bookId") Integer bookId) {
		bookService.delete(bookId);
		return "redirect:/admin/adminview";
	}

	@GetMapping("/showupdateform")
	public String showupdateform(Map<String, Object> model, @RequestParam("bookId") Integer bookId) {
		Book book = bookService.getBookById(bookId);
		model.put("book", book);
		return "updatebook";

	}

	@GetMapping("/studentlist")
	public String studentlist(Map<String, Object> model) {
		List<Student> std = studentservice.getStudents();
		List<Student> students = calculateFines(std);
		model.put("students", students);
		return "adminstudentview";
	}

	@GetMapping("/showissueform")
	public String showissueform(Map<String, Object> model, @RequestParam("bookId") Integer bookId) {
		Book book = bookService.getBookById(bookId);
		model.put("book", book);
		return "issuebook";
	}

	@GetMapping("/issuebook")
	public String issuebook(Map<String, Object> model, @RequestParam("book_id") Integer bookId,
			@RequestParam("studentId") Integer studentid) {
		boolean status = studentservice.issuebook(bookId, studentid);
		if (status)
			return "redirect:/admin/studentlist";
		else
			return "redirect:/admin/studentlist";
	}

	@GetMapping("/deletestudent")
	public String deletestudent(Map<String, Object> model, @RequestParam("studentId") Integer studentId) {
		studentservice.deleteStudent(studentId);
		return "redirect:/admin/studentlist";
	}

	@GetMapping("/finereceived")
	public String finereceived(Map<String, Object> model, @RequestParam("studentId") Integer studentId) {
		studentservice.makefinezero(studentId);
		return "redirect:/admin/studentlist";
	}

	public List<Student> calculateFines(List<Student> students) {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		students.forEach(student -> {
			String bookIssuedDateStr = student.getIssued_book_date();
			if (student.getFine_amount() == null)
				student.setFine_amount(0);
			studentservice.saveStudent(student);
			if (bookIssuedDateStr != null) {
				LocalDate bookIssuedDate = LocalDate.parse(bookIssuedDateStr, formatter);
				long daysPassed = ChronoUnit.DAYS.between(bookIssuedDate, currentDate);
				Integer fineAmount = (int) Math.max(0, (daysPassed - 15) * 10);
				student.setFine_amount(fineAmount);
				studentservice.saveStudent(student);
			}
		});

		return students;
	}
}
