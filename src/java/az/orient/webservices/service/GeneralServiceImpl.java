package az.orient.webservices.service;

import az.orient.webservices.business.StudentService;
import az.orient.webservices.business.StudentServiceImpl;
import az.orient.webservices.dao.StudentDao;
import az.orient.webservices.dao.StudentDaoImpl;
import az.orient.webservices.model.Student;
import az.orient.webservices.request.ReqStudent;
import az.orient.webservices.response.RespStatus;
import az.orient.webservices.response.RespStudent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class GeneralServiceImpl implements GeneralService {

    StudentDao studentDao = new StudentDaoImpl();
    StudentService studentService = new StudentServiceImpl(studentDao);
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<RespStudent> getStudentList() {
        List<RespStudent> response = new ArrayList<RespStudent>();
        try {
            List<Student> studentList = studentService.getstudentList();
            for (Student student : studentList) {
                RespStudent respStudent = new RespStudent();
                respStudent.setId(student.getId());
                respStudent.setName(student.getName());
                respStudent.setSurname(student.getSurname());
                respStudent.setAddress(student.getAddress());
                respStudent.setDob(df.format(student.getDob()));
                respStudent.setPhone(student.getPhone());
                response.add(respStudent);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }

    @Override
    public RespStudent getStudentById(Long studentId) {
        RespStudent response = new RespStudent();
        try {
            Student student = studentService.getStudentById(studentId);
            response.setName(student.getName());
            response.setSurname(student.getSurname());
            response.setAddress(student.getAddress());
            response.setPhone(student.getPhone());
            response.setDob(df.format(student.getDob()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }

    @Override
    public RespStatus addStudent(ReqStudent reqStudent) {
        RespStatus response = null;
        try {

            Student student = new Student();
            student.setName(reqStudent.getName());
            student.setSurname(reqStudent.getSurname());
            student.setAddress(reqStudent.getAddress());
            student.setDob(reqStudent.getDob());
            student.setPhone(reqStudent.getPhone());
            boolean isAdded = studentService.addStudent(student);
            if (isAdded) {
                response = RespStatus.getSuccessMessage();

            } else {
                response = RespStatus.getErrorMessage();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response=new RespStatus(100, "Internal Exception");
        }
        return response;
    }

    @Override
    public RespStatus updateStudent(ReqStudent reqStudent) {
        RespStatus response = null;
        try {

            Student student = new Student();
            student.setName(reqStudent.getName());
            student.setSurname(reqStudent.getSurname());
            student.setAddress(reqStudent.getAddress());
            student.setDob(reqStudent.getDob());
            student.setPhone(reqStudent.getPhone());
            boolean isUpdated = studentService.updateStudent(student,reqStudent.getStudentId());
            if (isUpdated) {
                response = RespStatus.getSuccessMessage();

            } else {
                response = RespStatus.getErrorMessage();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response=new RespStatus(100, "Internal Exception");
        }
        return response;
    }

    @Override
    public RespStatus deleteStudent(Long studentId) {
        RespStatus response = null;
        try {

            boolean isDeleted = studentService.deleteStudent(studentId);
            if (isDeleted) {
                response = RespStatus.getSuccessMessage();

            } else {
                response = RespStatus.getErrorMessage();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response=new RespStatus(100, "Internal Exception");
        }
        return response;  
    }

}
