package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.model.Admin;

public interface IAdminDAO extends CrudRepository<Admin, Integer> {

	boolean existsByAdminEmailAndAdminPassword(String email, String password);

}
