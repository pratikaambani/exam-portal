package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.users.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
	/**
	 * 
	 * @param email
	 * @return
	 */
	User findByEmail(String email);

}
