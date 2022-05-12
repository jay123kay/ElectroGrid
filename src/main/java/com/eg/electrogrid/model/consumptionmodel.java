package com.eg.electrogrid.model;

public class consumptionmodel {
	private String no;
	private String district;
	private String location;
	private String weekly;
	private String monthly;
	
	public consumptionmodel() {
		
	}
	
	public consumptionmodel(String no, String district, String location, String weekly, String monthly) {
		super();
		this.no = no;
		this.district = district;
		this.location = location;
		this.weekly = weekly;
		this.monthly = monthly;
		
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWeekly() {
		return weekly;
	}

	public void setWeekly(String weekly) {
		this.weekly = weekly;
	}

	public String getMonthly() {
		return monthly;
	}

	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}

	

}
