package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.sid.entities.User;

import org.springframework.stereotype.Repository;
@Transactional
@Repository
public class UserDaoImpl implements IuserDao{
	final static Logger logger = Logger.getLogger(UserDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {

		String hql="FROM User ";
	return (List<User>)	entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
		
	}

	@Override
	public void updateUser(User user) {
		User userDb = getUserById(user.getId());
		userDb.setFirstName(user.getFirstName());
		userDb.setLastName(user.getLastName());
		entityManager.flush();
		
	}

	@Override
	public void deleteUser(int id) {
		entityManager.remove(getUserById(id));		
	}

	@Override
	public boolean existNameLastName(String name, String lastName) {
		String existQuery ="SELECT * FROM User as u WHERE u.fistName = ? AND u.lastName = ? ";
	int count=0;
	count=	entityManager.createQuery(existQuery).setParameter(1, name).setParameter(2, lastName).getResultList().size();
		return count>0?true:false;
	}

}
