package com.oracle.TeaMall.bean;
/**
 *	PRODUCT_ID		NUMBER
	PRODUCT_BRAND	NVARCHAR2(20 CHAR)
	PRODUCT_NAME	NVARCHAR2(20 CHAR)
	PRODUCT_SXWX	NVARCHAR2(20 CHAR)
	PRODUCT_DATE	DATE
	PRODUCT_WEIGHT	NUMBER
	PRODUCT_SERIES	NVARCHAR2(20 CHAR)
	PRODUCT_PACKAGE	NVARCHAR2(20 CHAR)
	PRODUCT_MALL_PRICE	NUMBER(38,0)
	PRODUCT_NUM	NUMBER(38,0)
	PRODUCT_IMAGE	NVARCHAR2(20 CHAR)
	PRODUCT_PRICE	NUMBER(38,0)
 * @author Administrator
 *
 */
public class Tea {
	private int product_Id;//主键
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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + product_Id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tea other = (Tea) obj;
		if (product_Id != other.product_Id)
			return false;
		return true;
	}


	public Tea(int product_Id, String product_Brand, String product_Name, String product_Sxwx, String product_Date,
			int product_Weight, String product_Series, String product_Package, int mall_Price, int product_Num,
			String product_Image, int cost_Price) {
		super();
		this.product_Id = product_Id;
		this.product_Brand = product_Brand;
		this.product_Name = product_Name;
		this.product_Sxwx = product_Sxwx;
		this.product_Date = product_Date;
		this.product_Weight = product_Weight;
		this.product_Series = product_Series;
		this.product_Package = product_Package;
		this.mall_Price = mall_Price;
		this.product_Num = product_Num;
		this.product_Image = product_Image;
		this.cost_Price = cost_Price;
	}


	public Tea() {
		super();
	}

	public Tea(int product_Id) {
		super();
		this.product_Id = product_Id;
	}

	public int getProduct_Id() {
		return product_Id;
	}


	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}


	public String getProduct_Brand() {
		return product_Brand;
	}


	public void setProduct_Brand(String product_Brand) {
		this.product_Brand = product_Brand;
	}


	public String getProduct_Name() {
		return product_Name;
	}


	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}


	public String getProduct_Sxwx() {
		return product_Sxwx;
	}


	public void setProduct_Sxwx(String product_Sxwx) {
		this.product_Sxwx = product_Sxwx;
	}


	public String getProduct_Date() {
		return product_Date;
	}


	public void setProduct_Date(String product_Date) {
		this.product_Date = product_Date;
	}


	public int getProduct_Weight() {
		return product_Weight;
	}


	public void setProduct_Weight(int product_Weight) {
		this.product_Weight = product_Weight;
	}


	public String getProduct_Series() {
		return product_Series;
	}


	public void setProduct_Series(String product_Series) {
		this.product_Series = product_Series;
	}


	public String getProduct_Package() {
		return product_Package;
	}


	public void setProduct_Package(String product_Package) {
		this.product_Package = product_Package;
	}


	public int getMall_Price() {
		return mall_Price;
	}


	public void setMall_Price(int mall_Price) {
		this.mall_Price = mall_Price;
	}


	public int getProduct_Num() {
		return product_Num;
	}


	public void setProduct_Num(int product_Num) {
		this.product_Num = product_Num;
	}


	public String getProduct_Image() {
		return product_Image;
	}


	public void setProduct_Image(String product_Image) {
		this.product_Image = product_Image;
	}


	public int getCost_Price() {
		return cost_Price;
	}


	public void setCost_Price(int cost_Price) {
		this.cost_Price = cost_Price;
	}


	@Override
	public String toString() {
		return "Tea [product_Id=" + product_Id + ", product_Brand=" + product_Brand + ", product_Name=" + product_Name
				+ ", product_Sxwx=" + product_Sxwx + ", product_Date=" + product_Date + ", product_Weight="
				+ product_Weight + ", product_Series=" + product_Series + ", product_Package=" + product_Package
				+ ", mall_Price=" + mall_Price + ", product_Num=" + product_Num + ", product_Image=" + product_Image
				+ ", cost_Price=" + cost_Price + "]";
	}
	
	
	
	
}
