package ro.ubbcluj.softeng.server.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ro.ubbcluj.softeng.server.model.DemoModel;
import ro.ubbcluj.softeng.server.service.DemoService;

@Path("demo")
public class TestResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DemoModel> getData() {
		return DemoService.getDataList();
	}
	
	@GET
	@Path("/string")
	@Produces(MediaType.TEXT_PLAIN)
	public String getString() {
		return "Test String new!!";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newData(DemoModel dm) {
		DemoService.save(dm);
		return Response.ok(dm).build();
	}
		
	@DELETE
    @Path("/{id}")
	public Response removeData(@PathParam("id") Integer id) {
		DemoModel md = DemoService.remove(id);
		if (md != null)
			return Response.ok(md).build();
		else 
			return Response.status(Status.NOT_FOUND).build();
	}
	
	@GET
    @Path("/{number}")
	public Response getItem(@PathParam("number") Integer number) {
		DemoModel md = DemoService.getItem(number);
		if (md != null)
			return Response.ok(md).build();
		else 
			return Response.status(Status.NOT_FOUND).build();
	}
	
	@PUT
    @Path("/{id}")
	public Response updateData(@PathParam("id") Integer id, DemoModel dm) {
		DemoModel md = DemoService.update(id, dm);
		if (md != null)
			return Response.accepted(md).build();
		else 
			return Response.status(Status.NOT_FOUND).build();
	}
		
	
	
}
