package in.ineuron.controller;

import java.io.IOException;
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
import in.ineuron.service.IBookService;
import in.ineuron.service.IStudentservice;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentservice studentService;
	@Autowired
	private IBookService bookService;

	@PostMapping("/loginvalidate")
	public String loginvalidate(Map<String, Object> model, @RequestParam("student_email") String email,
			@RequestParam("student_password") String password, HttpSession session) {
		boolean status = studentService.getLoginValidation(email, password);
		if (status) {
			Long ID = studentService.getStudentIdbyemail(email);
			Integer id = ID.intValue();
			session.setAttribute("id", id);
			return "redirect:/student/studentview";
		} else {
			return "redirect:/std_login.jsp";
		}
	}

	@PostMapping("/signup")
	public String getLoginvalidation(Map<String, Object> model, @RequestParam("student_email") String email,
			@RequestParam("student_password") String password, @RequestParam("student_name") String studentname)
			throws IOException {
		Student student = new Student();
		student.setStudentEmail(email);
		student.setStudentPassword(password);
		student.setStudent_name(studentname);
		studentService.saveStudent(student);

		return "redirect:/std_login.jsp";

	}

	@GetMapping("/studentview")
	public String studentbooklist(Map<String, Object> model, HttpSession session) {
		List<Book> books = bookService.getBooks();
		Integer studentid = (Integer) session.getAttribute("id");
		Student student = studentService.getStudent(studentid);
		model.put("student", student);
		model.put("books", books);
		return "studentView";
	}
}
