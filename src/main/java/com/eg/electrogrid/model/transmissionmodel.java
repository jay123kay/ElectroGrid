package com.eg.electrogrid.model;

public class transmissionmodel {
	private String no;
	private String area;
	private String name;
	private String voltage;
	private String date;
	private String time;
	
	public transmissionmodel() {
		
	}
	
	public transmissionmodel(String no, String area, String name, String voltage, String date, String time) {
		super();
		this.no = no;
		this.area = area;
		this.name = name;
		this.voltage = voltage;
		this.date = date;
		this.time = time;
		
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
