package in.ineuron.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer student_id;
	private String student_name;
	private String studentEmail;
	private String studentPassword;
	private Integer fine_amount;
	private String issued_book1;
	private String issued_book2;
	private String issued_book3;
	private String issued_book_date;

}
