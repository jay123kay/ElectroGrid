 package com.eg.electrogrid.model;

public class crudmodel {
	
	private String name;
	private int id ;
	private String address;
	private String area;
	
	public  crudmodel() {
		
	}

	public crudmodel(String name, int id, String address, String area) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	
	
	
	
}
