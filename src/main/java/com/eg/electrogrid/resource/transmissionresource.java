package com.eg.electrogrid.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import com.eg.electrogrid.model.transmissionmodel;
import com.eg.electrogrid.service.transmissionservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class transmissionresource {
	
	transmissionservice service = new transmissionservice();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public transmissionmodel addTransmission(transmissionmodel transmission) {
		 return service.insertTransmission(transmission);
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<transmissionmodel>  getTransmission() throws SQLException {
		 return service.getTransmission();
		
	}
	
	@Path("/retrieveByNo/{no}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<transmissionmodel>  getTransmission(@PathParam("no") String no) throws SQLException {
		return service.getTransmissionByNo(no);
		
	}
	
	@Path("/updateTransmission")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public transmissionmodel updateTransmission(transmissionmodel transmission) {
		 return service.updateTransmission(transmission);
		
	}
	
	@Path("/deleteTransmissionByNo/{no}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteTransmission(@PathParam("no") String no) {
		return service.deletetTransmission(no);
		
	}
	
}
