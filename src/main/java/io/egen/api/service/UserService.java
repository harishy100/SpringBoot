package io.egen.api.service;

import io.egen.api.datatransfer.dataLogin;
import io.egen.api.entity.User;

public interface UserService {
	public User create(User usr);
	public Boolean login(dataLogin login);
}

