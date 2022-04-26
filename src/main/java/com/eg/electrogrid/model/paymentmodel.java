package com.eg.electrogrid.model;

public class paymentmodel {
		private int id;
		private String User;
		private String Address;
		private String UsedAmount;
		public paymentmodel() {
			super();
		}
		
		public paymentmodel(int id, String user, String address, String usedamount) {
			super();
			this.id = id;
			this.User = user;
			this.Address = address;
			this.UsedAmount = usedamount;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUser() {
			return User;
		}

		public void setUser(String user) {
			User = user;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public String getUsedAmount() {
			return UsedAmount;
		}

		public void setUsedAmount(String usedAmount) {
			UsedAmount = usedAmount;
		}

}
