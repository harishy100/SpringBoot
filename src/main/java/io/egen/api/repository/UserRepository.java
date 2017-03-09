package io.egen.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import io.egen.api.entity.User;
public interface UserRepository extends Repository<User, String> {
	public User save(User usr);
	public List<User> findByEmail(String email);
	
}
