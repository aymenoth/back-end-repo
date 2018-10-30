package org.sid.services;

import java.util.List;

import org.sid.dao.IuserDao;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServicesImpl implements IuserServices {

	@Autowired
	IuserDao iuserDao;

	@Override
	public List<User> getAllUsers() {

		return iuserDao.getAllUsers();
	}

	@Override
	public User getUserById(int id) {
		return iuserDao.getUserById(id);
	}

	@Override
	public void addUser(User user) {
		iuserDao.addUser(user);

	}

	@Override
	public void updateUser(User user) {
		iuserDao.updateUser(user);

	}

	@Override
	public void deleteUser(int id) {
		iuserDao.deleteUser(id);
	}

	@Override
	public boolean existNameLastName(String name, String lastName) {
		return iuserDao.existNameLastName(name, lastName);
	}

}
