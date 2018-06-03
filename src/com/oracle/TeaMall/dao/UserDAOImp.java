package com.oracle.TeaMall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.oracle.TeaMall.bean.User;



public class UserDAOImp extends BaseDAOImp implements UserDAO {

	@Override
	public boolean add(Object o) {
		User user=(User)o;
		boolean result=false;
		Statement sta=null;
		try {
			sta=getSta();
			int count=sta.executeUpdate("INSERT INTO USER_TABLE(USER_ID,USER_USERNAME,USER_PASSWORD,USER_EMAIL) VALUES(SEQ_USER_TABLE_USER_ID.nextval,'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"')");//由于userID列不能为空，所以在这里用一个变量的值来填充，后面为保证userid按顺序增加，将rownum的值赋给它
			result=(count>0)?true:false;
		} catch (Exception e) {
		}
		return result;
	}

	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean update(Object o) {
		User u=(User)o;
		ResultSet rs = null;
		int result=0;
		try {
			result=getSta().executeUpdate("UPDATE USER_TABLE SET USER_USERNAME='"+u.getUsername()+"',USER_SEX="+u.getSex()+",USER_PHONE='"+u.getPhone()+"',USER_REALNAME='"+u.getRealname()+"',USER_EMAIL='"+u.getEmail()+"',USER_LEVEL='"+u.getLevel()+"',USER_ADDRESS='"+u.getAddress()+"',USER_IMAGE='"+u.getImage()+"',USER_AGE="+u.getAge()+",USER_ZIPCODE='"+u.getZipcode()+"' WHERE USER_ID="+u.getUserid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result>0?true:false;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		User  user=null;
		ResultSet rs = null;
		try {
			  rs=getSta().executeQuery("SELECT * FROM USER_TABLE WHERE USER_USERNAME='"+username+"' AND USER_PASSWORD='"+password+"'");
			  if(rs.next()) {
				user=new User();
				user.setUserid(rs.getInt("USER_ID"));
				user.setUsername(rs.getString("USER_USERNAME"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				user.setSex(rs.getInt("USER_SEX"));
				user.setPhone(rs.getString("USER_PHONE"));
				user.setRealname(rs.getString("USER_REALNAME"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setLevel(rs.getString("USER_LEVEL"));
				user.setAddress(rs.getString("USER_ADDRESS"));
				user.setImage(rs.getString("USER_IMAGE"));
				user.setAge(rs.getInt("USER_AGE"));
				user.setZipcode(rs.getString("USER_ZIPCODE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserInfoByUserId(int userid) {
		User  user=null;
		ResultSet rs=null;
		try {
			rs=getSta().executeQuery("select *  from USER_TABLE where user_id="+userid);
			if(rs.next()) 
			{
				user=new User();
				user.setUserid(rs.getInt("USER_ID"));
				user.setUsername(rs.getString("USER_USERNAME"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				user.setSex(rs.getInt("USER_SEX"));
				user.setPhone(rs.getString("USER_PHONE"));
				user.setRealname(rs.getString("USER_REALNAME"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setLevel(rs.getString("USER_LEVEL"));
				user.setAddress(rs.getString("USER_ADDRESS"));
				user.setImage(rs.getString("USER_IMAGE"));
				user.setAge(rs.getInt("USER_AGE"));
				user.setZipcode(rs.getString("USER_ZIPCODE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;	
		}

	@Override
	public boolean changePasswd(String usernameByChange,String newPasswd) {
		String password=newPasswd;
		String username=usernameByChange;
		ResultSet rs = null;
		int result=0;
		try {
			result=getSta().executeUpdate("UPDATE USER_TABLE SET USER_PASSWORD='"+password+"' WHERE USER_USERNAME='"+username+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result>0?true:false;
	}

	@Override
	public boolean checkUserExist(String username) {
		boolean result=false;
		Statement  sta=null;
		ResultSet  rs=null;
		try {
			sta=getSta();
			rs=sta.executeQuery("select count(user_id) from user_table where user_username='"+username+"'");
			rs.next();
			result=(rs.getInt(1)>0)?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(sta, rs);
		return result;
	}

	@Override
	public ArrayList<User> listUsersByPage(int page, int count) {
		ArrayList<User> users=new ArrayList<>();
		Statement sta=null;
		ResultSet rs=null;
		try {
			sta=getSta();
			rs=sta.executeQuery("select * from (select rownum rn,a.* from user_table a)p where p.rn BETWEEN "+((page-1)*count+1)+" and "+(count*page));
			while(rs.next()){
				User user=new User();
				user.setUserid(rs.getInt("USER_ID"));
				user.setUsername(rs.getString("USER_USERNAME"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				user.setSex(rs.getInt("USER_SEX"));
				user.setPhone(rs.getString("USER_PHONE"));
				user.setRealname(rs.getString("USER_REALNAME"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setLevel(rs.getString("USER_LEVEL"));
				user.setAddress(rs.getString("USER_ADDRESS"));
				user.setImage(rs.getString("USER_IMAGE"));
				user.setAge(rs.getInt("USER_AGE"));
				user.setZipcode(rs.getString("USER_ZIPCODE"));
				
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(sta, rs);
		return users;
	}

	@Override
	public int getAllCountOfUsers() {
		int count=0;
		Statement  sta=null;
		ResultSet  rs=null;
		try {
			sta=getSta();
			rs=sta.executeQuery("select  count(user_id)  from  user_table");
			rs.next();
			count=rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(sta, rs);
		return count;
	}

}
