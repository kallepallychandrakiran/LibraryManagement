package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IBookDAO;
import in.ineuron.model.Book;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	IBookDAO repo;

	@Override
	public List<Book> getBooks() {

		return (List<Book>) repo.findAll();
	}

	@Override
	public void saveBook(Book book) {
		repo.save(book);

	}

	@Override
	public void delete(Integer bookId) {
		repo.deleteById(bookId);

	}

	@Override
	public Book getBookById(Integer bookId) {
		Optional<Book> optional = repo.findById(bookId);
		return optional.get();
	}

	@Override
	public List<Book> searchbook(String keyword) {
		List<Book> bookList = repo.findByKeyword(keyword);
		return bookList;
	}

}
