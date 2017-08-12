package com.xiami.model;

public class Goods {

	private String id;//编号
	private String name;//名称
	private double price;//单价
	private int count;//数量
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof Goods){
			Goods anotherGoods = (Goods)obj;
			return this.id.equals(anotherGoods.id) && this.name.equals(anotherGoods.name);
		}
		return false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
