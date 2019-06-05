package az.orient.webservices.service;

import az.orient.webservices.request.ReqStudent;
import az.orient.webservices.response.RespStatus;
import az.orient.webservices.response.RespStudent;
import java.util.List;

/**
 *
 * @author User
 */
public interface GeneralService {
    
    List<RespStudent>getStudentList(); 
    
    RespStudent getStudentById(Long studentId);
    
    RespStatus addStudent(ReqStudent reqStudent);
    
    RespStatus updateStudent(ReqStudent reqStudent);
    
    RespStatus deleteStudent(Long studentId);
}
