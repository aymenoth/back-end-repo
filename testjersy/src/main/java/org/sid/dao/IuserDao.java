package org.sid.dao;

import java.util.List;

import org.sid.entities.User;

public interface IuserDao {
	public List<User> getAllUsers();
	public User getUserById(int id);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public boolean existNameLastName(String name, String lastName);

}
