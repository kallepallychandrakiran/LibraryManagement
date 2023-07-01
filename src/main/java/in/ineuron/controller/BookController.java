package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Book;
import in.ineuron.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	IBookService bookService;

	@PostMapping("/saveBook")
	public String savebook(@ModelAttribute("book") Book book, Map<String, Object> model) {
		bookService.saveBook(book);

		return "redirect:/admin/adminview";
	}

	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Map<String, Object> model) {
		List<Book> books = bookService.searchbook(keyword);
		model.put("books", books);
		return "booksearch";

	}

}
