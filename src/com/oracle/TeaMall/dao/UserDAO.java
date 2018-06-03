package com.oracle.TeaMall.dao;

import java.util.ArrayList;

import com.oracle.TeaMall.bean.User;

public interface UserDAO extends BaseDAO {
	public User login(String username,String password);
	public  User getUserInfoByUserId(int userid);
	public boolean changePasswd(String usernameByChange,String newPasswd);
	public boolean checkUserExist(String username);
	public ArrayList<User> listUsersByPage(int page,int count);
	public int getAllCountOfUsers();
}
