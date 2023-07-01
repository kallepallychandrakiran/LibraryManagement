package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IAdminDAO;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDAO adminrepo;

	@Override
	public boolean getLoginValidation(String email, String password) {

		return adminrepo.existsByAdminEmailAndAdminPassword(email, password);
	}

}
