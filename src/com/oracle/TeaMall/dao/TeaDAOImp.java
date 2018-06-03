package com.oracle.TeaMall.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.TeaMall.bean.Tea;


public class TeaDAOImp extends BaseDAOImp implements TeaDAO {

	@Override
	public ArrayList<Tea> listTeasByCount(int count) {
		ArrayList<Tea> teas = new ArrayList<Tea>();//定义一个集合存储茶叶的所有信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  PRODUCT_TABLE where rownum<="+count+" order by  PRODUCT_ID");
			while(rs.next())
			{
				/*
				 * 	private int product_Id;//主键
					private String product_Brand;//品牌---
					private String product_Name;//茶叶名---
					private String product_Sxwx;//色香味形---
					private String product_Date;//生产时间
					private int product_Weight;//茶叶重量
					private String product_Series;//明前茶或雨前茶---
					private String product_Package;//茶叶的包装盒类型
					private int mall_Price;//市场价格
					private int product_Num;//库存数量
					private String product_Image;//图片路径
					private int cost_Price;//成本价
				 */
				Tea  t=new Tea();
				t.setProduct_Id(rs.getInt("PRODUCT_ID"));
				t.setProduct_Brand(rs.getString("PRODUCT_BRAND"));
				t.setProduct_Name(rs.getString("PRODUCT_NAME"));
				t.setProduct_Sxwx(rs.getString("PRODUCT_SXWX"));
				t.setProduct_Date(rs.getString("PRODUCT_DATE"));
				t.setProduct_Weight(rs.getInt("PRODUCT_WEIGHT"));
				t.setProduct_Series(rs.getString("PRODUCT_SERIES"));
				t.setProduct_Package(rs.getString("PRODUCT_PACKAGE"));
				t.setMall_Price(rs.getInt("PRODUCT_MALL_PRICE"));
				t.setProduct_Num(rs.getInt("PRODUCT_NUM"));
				t.setProduct_Image(rs.getString("PRODUCT_IMAGE"));
				t.setCost_Price(rs.getInt("PRODUCT_PRICE"));
				teas.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return  teas;
	}

	@Override
	public ArrayList<Tea> getAllTeasByTuiGuang() {
		ArrayList<Tea> teas = new ArrayList<Tea>();//定义一个集合存储茶叶的所有信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  PRODUCT_TABLE where ADPROMOTION=1 order by  PRODUCT_ID");
			while(rs.next())
			{
				Tea  t=new Tea();
				t.setProduct_Id(rs.getInt("PRODUCT_ID"));
				t.setProduct_Brand(rs.getString("PRODUCT_BRAND"));
				t.setProduct_Name(rs.getString("PRODUCT_NAME"));
				t.setProduct_Sxwx(rs.getString("PRODUCT_SXWX"));
				t.setProduct_Date(rs.getString("PRODUCT_DATE"));
				t.setProduct_Weight(rs.getInt("PRODUCT_WEIGHT"));
				t.setProduct_Series(rs.getString("PRODUCT_SERIES"));
				t.setProduct_Package(rs.getString("PRODUCT_PACKAGE"));
				t.setMall_Price(rs.getInt("PRODUCT_MALL_PRICE"));
				t.setProduct_Num(rs.getInt("PRODUCT_NUM"));
				t.setProduct_Image(rs.getString("PRODUCT_IMAGE"));
				t.setCost_Price(rs.getInt("PRODUCT_PRICE"));
				teas.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return  teas;
	}

	@Override
	public ArrayList<Tea> searchTeasByCondition(String brand,String name,String sxwx,String date,String series) {
		
		String SQL="SELECT * FROM PRODUCT_TABLE WHERE 1=1";
		if(brand!=null)
		{
			SQL+=" AND PRODUCT_BRAND='"+brand+"'";
		}
		if(name!=null)
		{
			SQL+=" AND PRODUCT_NAME='"+name+"'";
		}
		if(sxwx!=null)
		{
			SQL+=" AND PRODUCT_SXWX='"+sxwx+"'";
		}
		if(date!=null)
		{
			SQL+=" AND EXTRACT(YEAR FROM PRODUCT_DATE)='"+date+"'";
		}
		if(series!=null)
		{
			SQL+=" AND PRODUCT_SERIES='"+series+"'";
		}
		
		ArrayList<Tea> teas = new ArrayList<Tea>();//定义一个集合存储茶叶的所有信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery(SQL);
			while(rs.next())
			{
				Tea  t=new Tea();
				t.setProduct_Id(rs.getInt("PRODUCT_ID"));
				t.setProduct_Brand(rs.getString("PRODUCT_BRAND"));
				t.setProduct_Name(rs.getString("PRODUCT_NAME"));
				t.setProduct_Sxwx(rs.getString("PRODUCT_SXWX"));
				t.setProduct_Date(rs.getString("PRODUCT_DATE"));
				t.setProduct_Weight(rs.getInt("PRODUCT_WEIGHT"));
				t.setProduct_Series(rs.getString("PRODUCT_SERIES"));
				t.setProduct_Package(rs.getString("PRODUCT_PACKAGE"));
				t.setMall_Price(rs.getInt("PRODUCT_MALL_PRICE"));
				t.setProduct_Num(rs.getInt("PRODUCT_NUM"));
				t.setProduct_Image(rs.getString("PRODUCT_IMAGE"));
				t.setCost_Price(rs.getInt("PRODUCT_PRICE"));
				teas.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return  teas;
	}

	@Override
	public Tea getTeaInfoById(int TeaId) {
		Tea t = null;
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  PRODUCT_TABLE where PRODUCT_ID="+TeaId);
			if(rs.next())
			{
				t = parsetResultToTea(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return t;
	}

	@Override
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Tea parsetResultToTea(ResultSet rs) {
		Tea t = null;
		try {
			t = new Tea();
			t.setProduct_Id(rs.getInt("PRODUCT_ID"));
			t.setProduct_Brand(rs.getString("PRODUCT_BRAND"));
			t.setProduct_Name(rs.getString("PRODUCT_NAME"));
			t.setProduct_Sxwx(rs.getString("PRODUCT_SXWX"));
			t.setProduct_Date(rs.getString("PRODUCT_DATE"));
			t.setProduct_Weight(rs.getInt("PRODUCT_WEIGHT"));
			t.setProduct_Series(rs.getString("PRODUCT_SERIES"));
			t.setProduct_Package(rs.getString("PRODUCT_PACKAGE"));
			t.setMall_Price(rs.getInt("PRODUCT_MALL_PRICE"));
			t.setProduct_Num(rs.getInt("PRODUCT_NUM"));
			t.setProduct_Image(rs.getString("PRODUCT_IMAGE"));
			t.setCost_Price(rs.getInt("PRODUCT_PRICE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	@Override
	public ArrayList<Tea> listTeaByPage(int page, int count) {
		ArrayList<Tea> teas = new ArrayList<Tea>();// 定义一个集合存储查询出来的所有车辆信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select * from (select rownum rn,a.* from PRODUCT_TABLE a)p where p.rn BETWEEN "+((page-1)*count+1)+" and "+(count*page));
			while (rs.next()) {

				teas.add(parsetResultToTea(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disposeResource(getSta(), rs, getCon());
		return teas;
	}

	@Override
	public int getAllCountOfTea() {
		int  n=0;
		ResultSet  rs=null;
		try {
			  rs=getSta().executeQuery("select count(product_id)  from  product_table");
			  rs.next();
			  n=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
