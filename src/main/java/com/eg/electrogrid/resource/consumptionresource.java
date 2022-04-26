package com.eg.electrogrid.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import com.eg.electrogrid.model.consumptionmodel;
import com.eg.electrogrid.service.consumptionservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class consumptionresource {
	
	consumptionservice service = new consumptionservice();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public consumptionmodel addConsumption(consumptionmodel consumption) {
		return consumption;
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<consumptionmodel>  getConsumption() throws SQLException {
		 return service.getConsumption();
		
	}
	
	@Path("/retrieveByNo/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<consumptionmodel>  getConsumption(@PathParam("id") String id) throws SQLException {
		return service.getConsumptionByNo(id);
		
	}
	
	@Path("/updateConsumption")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public consumptionmodel updateConsumption(consumptionmodel consumption) {
		 return service.updateConsumption(consumption);
		
	}
	
	@Path("/deleteConsumptionByNo/{no}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteConsumption(@PathParam("id") String id) {
		return service.deleteConsumption(id);
		
	}
	
}
