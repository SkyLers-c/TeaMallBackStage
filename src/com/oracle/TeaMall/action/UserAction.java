package com.oracle.TeaMall.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.oracle.TeaMall.bean.User;
import com.oracle.TeaMall.dao.UserDAOImp;
import com.oracle.TeaMall.util.Responser;

public class UserAction {

	private String username;
	private String password;
	private int page;
	private int count;
	private UserDAOImp dao;
	
	public UserAction() {
		dao= new UserDAOImp();
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 登录方法
	 * @return
	 */
	public String login() {
		if(ServletActionContext.getRequest().getSession().getAttribute("user")!=null) {
			System.out.println("已有用户信息，直接进入首页");
			return index();
		}else {
			User u=dao.login(username, password);
			if(u!=null) {
				ServletActionContext.getRequest().getSession().setAttribute("user", u);
				System.out.println("登陆成功");
				return index();
			}else {
				System.out.println("登录失败");
				ServletActionContext.getRequest().setAttribute("loginMessage", "loginFail");//在登陆失败的情况下，王request里面存一个登陆失败的消息，让前端页面可以判断是否打开提示框
				return "loginFail";
			}
		}
		
	}
	
	
	public String index(){
		User u = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		System.out.println(u);
		if(u!=null) {
			return "visitNormal";
		}else {
			return "visitIllegal";
		}
	}
	
	/**
	 * 退出登录方法
	 */
	public String logOut() {
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "logOutSuccess";
	}
	/**
	 * 用户数据分页方法
	 */
	public void listUserByPage() {
		ArrayList<User> users=dao.listUsersByPage(page, count);
		JSONArray ja=new JSONArray();
		for(User u:users) {
			try {
				JSONObject j=new JSONObject();
				j.put("userid", u.getUserid());
				j.put("username", u.getUsername());
				j.put("password", u.getPassword());
				j.put("sex", u.getSex());
				j.put("phone", u.getPhone());
				j.put("realname", u.getRealname());
				j.put("email", u.getEmail());
				j.put("level",u.getLevel());
				j.put("address", u.getAddress());
				j.put("image", u.getImage());
				j.put("age", u.getAge());
				j.put("zipcode", u.getZipcode());
				
				ja.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), ja.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
