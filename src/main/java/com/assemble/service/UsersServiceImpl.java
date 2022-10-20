package com.assemble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assemble.dao.UsersDAO;
import com.assemble.vo.UsersVO;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO usersDAO;

	@Override
	public UsersVO idCheck(String id) {
		return this.usersDAO.idCheck(id);
	}

	@Override
	public void insertUsers(UsersVO m) {
		this.usersDAO.insertUsers(m);
	}

	@Override
	public UsersVO pwdUsers(UsersVO m) {
		return this.usersDAO.pwdUsers(m);
	}

	@Override
	public void updatePwd(UsersVO m) {
		this.usersDAO.updatePwd(m);
	}

	@Override
	public UsersVO loginCheck(String login_id) {
		return this.usersDAO.loginCheck(login_id);
	} 
}
