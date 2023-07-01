package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import in.ineuron.model.Book;

public interface IBookDAO extends CrudRepository<Book, Integer> {

	@Query("SELECT b FROM Book b WHERE b.book_title LIKE %:keyword% OR b.book_author LIKE %:keyword% OR b.book_category LIKE %:keyword%")
	List<Book> findByKeyword(@Param("keyword") String keyword);

}
