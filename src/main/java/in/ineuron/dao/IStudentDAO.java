package in.ineuron.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import in.ineuron.model.Student;

public interface IStudentDAO extends CrudRepository<Student, Integer> {

	boolean existsByStudentEmailAndStudentPassword(String email, String password);

	@Query("SELECT s.id FROM Student s WHERE s.studentEmail = :email")
	Long findByStudentEmail(@Param("email") String email);

}
