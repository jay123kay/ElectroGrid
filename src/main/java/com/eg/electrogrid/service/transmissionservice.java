package com.eg.electrogrid.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.eg.electrogrid.model.transmissionmodel;

public class transmissionservice {
	
	Connection con;
	
	public transmissionservice() {
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/transmissions");
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}
	
	public transmissionmodel insertTransmission(transmissionmodel transmission) {
		String insert = "insert into distribution(no,area,name,voltage,date,time) values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, transmission.getNo());
			ps.setString(2, transmission.getArea());
			ps.setString(3, transmission.getName());
			ps.setString(4, transmission.getVoltage());
			ps.setString(5, transmission.getDate());
			ps.setString(6, transmission.getTime());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return transmission;
		
	}
	
public ArrayList<transmissionmodel> getTransmission() throws SQLException{
		
		ArrayList<transmissionmodel> data = new ArrayList<transmissionmodel>();
		
		String select = "select * from distribution";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			transmissionmodel model = new transmissionmodel();
			
			model.setNo(rs.getString("no"));// column name
			model.setArea(rs.getString("area"));
			model.setName(rs.getString("name")); 
			model.setVoltage(rs.getString("voltage"));
			model.setDate(rs.getString("date"));
			model.setTime(rs.getString("time"));
			
			data.add(model);
			
		}
		
		return data;
		
	}

public ArrayList<transmissionmodel> getTransmissionByNo(String no) throws SQLException{
	
	ArrayList<transmissionmodel> data = new ArrayList<transmissionmodel>();
	String select = "select * from distribution where no =?";
	PreparedStatement ps = con.prepareStatement(select);
	ps.setString(1,no);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		transmissionmodel model = new transmissionmodel();
		
		model.setNo(rs.getString("no"));// column name
		model.setArea(rs.getString("area"));
		model.setName(rs.getString("name")); 
		model.setVoltage(rs.getString("voltage"));
		model.setDate(rs.getString("date"));
		model.setTime(rs.getString("time"));
		data.add(model);		
	}		
	return data;
		
}

public transmissionmodel updateTransmission(transmissionmodel transmission) {
	String insert = "update distribution set area=? , name=? , voltage=? , date=? , time=? where no =?";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		
		ps.setString(1, transmission.getArea());
		ps.setString(2, transmission.getName());
		ps.setString(3, transmission.getVoltage());
		ps.setString(4, transmission.getDate());
		ps.setString(5, transmission.getTime());
		ps.setString(6, transmission.getNo());
		
		ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return transmission;
	
}


public String deletetTransmission(String no) {
	String insert = "delete from distribution where no =?";
	
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
	
	


