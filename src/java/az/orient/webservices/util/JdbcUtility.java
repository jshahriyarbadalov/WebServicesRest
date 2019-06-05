package az.orient.webservices.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtility {

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) throws Exception{

        if(con!=null)
            con.close();
        if(ps!=null)
            ps.close();
        if(rs!=null)
            rs.close();

    }
}
