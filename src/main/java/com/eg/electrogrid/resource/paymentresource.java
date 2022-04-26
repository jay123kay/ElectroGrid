package com.eg.electrogrid.resource;

	import java.sql.SQLException;
	import java.util.ArrayList;

	import com.eg.electrogrid.model.paymentmodel;
	import com.eg.electrogrid.service.paymentservice;

	import jakarta.ws.rs.Consumes;
	import jakarta.ws.rs.DELETE;
	import jakarta.ws.rs.GET;
	import jakarta.ws.rs.POST;
	import jakarta.ws.rs.Path;
	import jakarta.ws.rs.PathParam;
	import jakarta.ws.rs.Produces;
	import jakarta.ws.rs.core.MediaType;

		@Path("/payments")
		public class paymentresource {
			
			paymentservice service = new paymentservice();
			
			@Path("/insertion")
			@POST
			@Consumes(MediaType.APPLICATION_JSON)
			public paymentmodel addPowerplant(paymentmodel payment) {
				 return service.insertPayment(payment);
				
			}
			
			@Path("/retrieve")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public ArrayList<paymentmodel>  getPowerplan() throws SQLException {
				 return service.getPayment();
				
			}
			
			@Path("/retrieveById/{id}")
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public ArrayList<paymentmodel>  getPowerplant(@PathParam("id")String id) throws SQLException {
				 return service.getPaymentById(id);

			}
			
			@Path("/updatePowerplant")
			@POST
			@Consumes(MediaType.APPLICATION_JSON)
			public paymentmodel uPowerplant(paymentmodel payment) {
				 return service.updatePayment(payment);
				
			}
			
			@Path("/deletePaymentById/{id}")
			@DELETE
			@Consumes(MediaType.APPLICATION_JSON)
			public int  deletePayment(@PathParam("id") int id) {
				 return service.deletePayment(id);

			}


}
