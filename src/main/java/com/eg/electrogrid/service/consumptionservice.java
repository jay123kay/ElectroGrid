package com.eg.electrogrid.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eg.electrogrid.model.consumptionmodel;

public class consumptionservice {
Connection con;
	
	public consumptionservice() {
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/consumption");
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}
	
	public consumptionmodel insertConsumption(consumptionmodel consumption) {
		String insert = "insert into connection(no,district,location,weekly,monthly) values(?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, consumption.getNo());
			ps.setString(2, consumption.getDistrict());
			ps.setString(3, consumption.getLocation());
			ps.setString(4, consumption.getWeekly());
			ps.setString(5, consumption.getMonthly());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return consumption;
		
	}
	
public ArrayList<consumptionmodel> getConsumption() throws SQLException{
		
		ArrayList<consumptionmodel> data = new ArrayList<consumptionmodel>();
		
		String select = "select * from connection";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			consumptionmodel model = new consumptionmodel();
			
			model.setNo(rs.getString("no"));// column name
			model.setDistrict(rs.getString("district"));
			model.setLocation(rs.getString("location")); 
			model.setWeekly(rs.getString("weekly"));
			model.setMonthly(rs.getString("Monthly"));
			
			data.add(model);
			
		}
		
		return data;
		
	}

public ArrayList<consumptionmodel> getConsumptionByNo(String no) throws SQLException{
	
	ArrayList<consumptionmodel> data = new ArrayList<consumptionmodel>();
	String select = "select * from connection where no =?";
	PreparedStatement ps = con.prepareStatement(select);
	ps.setString(1,no);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		consumptionmodel model = new consumptionmodel();
		
		model.setNo(rs.getString("no"));// column name
		model.setDistrict(rs.getString("district"));
		model.setLocation(rs.getString("Location")); 
		model.setWeekly(rs.getString("weekly"));
		model.setMonthly(rs.getString("monthly"));
		data.add(model);		
	}		
	return data;
		
}

public consumptionmodel updatetConsumption(consumptionmodel consumption) {
	String insert = "update connection set district=? , location=? , weekly=? , monthly=?  where no =?";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		
		ps.setString(1, consumption.getDistrict());
		ps.setString(2, consumption.getLocation());
		ps.setString(3, consumption.getWeekly());
		ps.setString(4, consumption.getMonthly());
		
		ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return consumption;
	
}


public String deletetConsumption(String no) {
	String insert = "delete from connection where no =?";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setString(1,no);
		
		ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return no;

}

}
