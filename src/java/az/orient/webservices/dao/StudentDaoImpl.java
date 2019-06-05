package az.orient.webservices.dao;

import az.orient.webservices.dao.DBHelper;
import az.orient.webservices.dao.StudentDao;
import az.orient.webservices.model.Student;
import az.orient.webservices.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getstudentList() throws Exception {
        List<Student> studentList = new ArrayList<Student>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM course where active=1";   //ROWNUM r, id, name, surname, address, dob, phone

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    // student.setR(rs.getLong("r")); // ROWNUM Istifade elemek
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setAddress(rs.getString("address"));
                    student.setDob(rs.getDate("dob"));
                    student.setPhone(rs.getString("phone"));
                    studentList.add(student);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return studentList;
    }

    @Override
    public boolean addStudent(Student student) throws Exception {
        boolean result = false;
        String sql = "INSERT INTO course (name, surname, address, dob, phone) VALUES (?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBHelper.getConnection();

            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setString(3, student.getAddress());
                ps.setDate(4, new java.sql.Date(student.getDob().getTime()));
                ps.setString(5, student.getPhone());
                ps.execute();

                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        } finally {
            // con.commit();   //Oracle DB used.
            JdbcUtility.close(con, ps, null);
        }
        return result;
    }

    @Override
    public Student getStudentById(Long studentId) throws Exception {
        Student student = new Student();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM course where id=? AND active=1";

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                ps = con.prepareStatement(query);
                ps.setLong(1, studentId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setAddress(rs.getString("address"));
                    student.setDob(rs.getDate("dob"));
                    student.setPhone(rs.getString("phone"));

                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return student;
    }

    @Override
    public boolean updateStudent(Student student, Long studentId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String query = "UPDATE course SET name=?, surname=?, address=?, dob=?, phone=? WHERE id=?";

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                ps = con.prepareStatement(query);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setString(3, student.getAddress());
                ps.setDate(4, new java.sql.Date(student.getDob().getTime()));
                ps.setString(5, student.getPhone());
                ps.setLong(6, studentId);
                ps.execute();

                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        } finally {
            //con.commit();   //Oracle DB used.
            JdbcUtility.close(con, ps, null);
        }
        return result;
    }

    @Override
    public boolean deleteStudent(Long studentId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        String query = "UPDATE course SET active=0 WHERE id=?";

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                ps = con.prepareStatement(query);
                ps.setLong(1, studentId);
                ps.execute();

                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        } finally {
            //con.commit();   //Oracle DB used.
            JdbcUtility.close(con, ps, null);
        }
        return result;
    }

    @Override
    public List<Student> searchStudentData(String keyword) throws Exception {
        List<Student> studentList = new ArrayList<Student>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM course where active=1 AND (LOWER(name) LIKE LOWER(?) OR LOWER(surname) LIKE LOWER(?)"
                + "OR LOWER(address) LIKE LOWER(?)) ";   //ROWNUM r, id, name, surname, address, dob, phone

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                ps = con.prepareStatement(query);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    // student.setR(rs.getLong("r")); // ROWNUM Istifade elemek
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setAddress(rs.getString("address"));
                    student.setDob(rs.getDate("dob"));
                    student.setPhone(rs.getString("phone"));
                    studentList.add(student);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(con, ps, rs);
        }

        return studentList;
    }
}
