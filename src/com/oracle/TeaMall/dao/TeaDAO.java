package com.oracle.TeaMall.dao;

import java.util.ArrayList;

import com.oracle.TeaMall.bean.Tea;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public interface TeaDAO {

	/*
	 * 设计一个可以根据用户传入数量来显示相应的茶叶数在页面上
	 */
	public ArrayList<Tea> listTeasByCount(int count);
	
	/*
	 * 定义一个滚动广告区域的推广设定方法
	 */
	public ArrayList<Tea> getAllTeasByTuiGuang();
	
	/*
	 * 定义一个按条件查询的方法
	 * 	private String product_Brand;//品牌---
		private String product_Name;//茶叶名---
		private String product_Sxwx;//色香味形---
		private String product_Series;//明前茶或雨前茶---
	 */
	public ArrayList<Tea> searchTeasByCondition(String Brand,String name,String sxwx,String date,String series);
	
	/*
	 * 定义查看详情的方法
	 */
	public Tea getTeaInfoById(int TeaId);
	
	/*
	 * 定义分页的方法，通过传入页数和页面显示条数来查询出当前页面要显示的数据
	 */
	public ArrayList<Tea> listTeaByPage(int page,int count);
	
	public int getAllCountOfTea();
}
