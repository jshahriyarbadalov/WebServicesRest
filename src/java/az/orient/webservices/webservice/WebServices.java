package az.orient.webservices.webservice;

import az.orient.webservices.response.RespStudent;
import az.orient.webservices.request.ReqStudent;
import az.orient.webservices.response.RespStatus;
import az.orient.webservices.service.GeneralService;
import az.orient.webservices.service.GeneralServiceImpl;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mkuchtiak
 */
@Path("/webservices")
public class WebServices {

    GeneralService generalService = new GeneralServiceImpl();

    @GET
    @Path("/test")
    @Produces("text/html")
    public String test() {
        return "<html><body><h1>Hello Shahriyar!</h1></body></html>";
    }

    @GET
    @Path("/getStudentList")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<RespStudent> getStudentList() {
        return generalService.getStudentList();
    }

    @GET
    @Path("/getStudentById")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStudent getStudentById(@QueryParam("studentId") Long studentId) {
        return generalService.getStudentById(studentId);
    }

    @POST
    @Path("/addStudent")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes(MediaType.APPLICATION_XML)
    public RespStatus addStudent(ReqStudent reqStudent) {
        return generalService.addStudent(reqStudent);
    }

    @PUT
    @Path("/updateStudent")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes(MediaType.APPLICATION_XML)
    public RespStatus updateStudent(ReqStudent reqStudent) {
        return generalService.updateStudent(reqStudent);
    }

    @PUT
    @Path("/deleteStudent/{studentId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatus deleteStudent(@PathParam("studentId") Long studentId) {
        return generalService.deleteStudent(studentId);
    }
}
