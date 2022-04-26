package com.eg.electrogrid.service;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	import com.eg.electrogrid.model.paymentmodel;



	public class paymentservice {
		Connection con;

		public paymentservice() {

			try {
				String url =String.format("jdbc:mysql://localhost:3306/electrogridpay");
				String uname ="root";
				String pwd = "";
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,uname,pwd);
				
			} catch(Exception e) {
				System.out.println(e +"data insert unsuccess.");
			}
	}

		public paymentmodel insertPayment(paymentmodel payment) {
	String insert = "insert into powerplant(id,user,address,usedamount) values(?,?,?,?) ";
			
			try {
				PreparedStatement ps = con.prepareStatement(insert);
				ps.setInt(1, payment.getId());
				ps.setString(2, payment.getUser());
				ps.setString(3, payment.getAddress());
				ps.setString(4, payment.getUsedAmount());
				
				ps.execute();
			}catch(Exception e) {
				System.out.println(e +"data insert unsuccess.");
			}
			
			return payment;
			
		}

	public ArrayList<paymentmodel> getPayment() throws SQLException{
		
		ArrayList<paymentmodel> data = new ArrayList<paymentmodel>();
		
		String select = "select * from powerplant";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			paymentmodel model = new paymentmodel();
			
			model.setId(rs.getInt("id"));// column name
			model.setUser(rs.getString("user")); 
			model.setAddress(rs.getString("address"));
			model.setUsedAmount(rs.getString("usedamount"));
			data.add(model);		
		}		
		return data;
			
	}

	public ArrayList<paymentmodel> getPaymentById(String id) throws SQLException{
		
		ArrayList<paymentmodel> data = new ArrayList<paymentmodel>();
		
		String select = "select * from payment where id = ?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			paymentmodel model = new paymentmodel();
			
			model.setId(rs.getInt("id"));// column name
			model.setUser(rs.getString("user")); 
			model.setAddress(rs.getString("address"));
			model.setUsedAmount(rs.getString("usedamount"));
		    data.add(model);		
		}		
		return data;
			
	}

	public paymentmodel updatePayment(paymentmodel payment) {
		String insert = "update payment set user=? , address=? , usedamount=? where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			;
			ps.setString(1, payment.getUser());
			ps.setString(3, payment.getAddress());
			ps.setString(4, payment.getUsedAmount());
			ps.setInt(5, payment.getId());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return payment;
		
	}


	public int deletePayment(int id) {
		String insert = "delete from payment where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,id);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return id;

	}


}
