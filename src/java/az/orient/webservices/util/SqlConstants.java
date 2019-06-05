package az.orient.webservices.util;

public class SqlConstants {
    //SQl sorgularin saxlandiqi klass.

    public static final String GET_STUDENT_LIST="SELECT * FROM course where active=1";

    public static final String GET_SCHEDULE_LIST="SELECT sc.s_id, c.id course_id, c.name course_name, c.surname course_surname, t.id teacher_id, t.name teacher_name, t.surname teacher_surname,l.id lesson_id, l.lessonname lesson_name\n" +
            "FROM test.schedules sc \n" +
            "inner join test.course c on sc.c_id=c.id \n" +
            "inner join test.teacher t on sc.t_id=t.id\n" +
            "inner join test.lesson l on sc.l_id=l.id \n" +
            "where sc.s_id=1";
}
