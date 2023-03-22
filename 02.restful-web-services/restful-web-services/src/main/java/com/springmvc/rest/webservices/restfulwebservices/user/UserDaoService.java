package com.springmvc.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoService {
	//JPA/Hibernate -> DB
	//UserDaoServices > Static List
	
	//public List<User> findAll(){
	public static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Mukul",LocalDate.now().minusYears(22)));
		users.add(new User(3,"Eve",LocalDate.now().minusYears(25)));
		users.add(new User(4,"Jim",LocalDate.now().minusYears(20)));
	}
	

	public List<User> findAll(){
		return users;
	}
	//public User save(User user){	
	//public User findOne(int id){
}
