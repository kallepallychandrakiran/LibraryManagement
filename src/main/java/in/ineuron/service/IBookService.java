package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Book;

public interface IBookService {

	public List<Book> getBooks();

	public void saveBook(Book book);

	public void delete(Integer bookId);

	public Book getBookById(Integer bookId);

	public List<Book> searchbook(String keyword);

}
