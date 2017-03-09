package io.egen.api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.repository.*;
import io.egen.api.service.UserService;
import io.egen.api.exceptions.BadRequestException;
import io.egen.api.datatransfer.dataLogin;
import io.egen.api.entity.*;
import io.egen.api.repository.*;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserRepository repository;
	@Override
	public User create(User usr) {

		List<User> usr1= repository.findByEmail(usr.getEmail());
		if(usr1.size()==1){
			throw new BadRequestException("User aready exists");
		}
		return repository.save(usr);
	}
	@Override
	public Boolean login(dataLogin login) {
		List<User> usr=repository.findByEmail(login.email);
			if(usr.size()==1){
				if(usr.get(0).getPassword().equals(login.password)){
					return true;
				}
				else{
					return false;
				}
			}
		return false;
	}
	
}

