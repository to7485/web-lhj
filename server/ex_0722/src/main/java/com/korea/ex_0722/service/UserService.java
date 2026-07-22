package com.korea.ex_0722.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.ex_0722.dao.UserDAO;
import com.korea.ex_0722.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserDAO userDAO;
	
	public List<UserVO> findAll(){
		return userDAO.findAll();
	}
	
	public UserVO findById(Long id) {
		return userDAO.findById(id);
	}
	
	public int insert(UserVO user) {
		return userDAO.insert(user);
	}
	
	public int update(UserVO user) {
		return userDAO.update(user);
	}
	
	public List<UserVO> delete(Long id) {
		if(userDAO.findById(id) != null) {
			userDAO.delete(id);
			return userDAO.findAll();
		} else {
			return null;
		}
	}
}






