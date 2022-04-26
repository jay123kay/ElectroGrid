package com.eg.electrogrid.model;

public class consumptionmodel {
	
	private String id;
	private String district;
	private String location;
	private String weekly;
	private String monthly;
	
	public consumptionmodel() {
	}
	
	public consumptionmodel(String id,String district,String location,String weekly,String monthly) {
		super();
		this.id = id;
		this.district = district;
		this.location = location;
		this.weekly = weekly;
		this.monthly = monthly;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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