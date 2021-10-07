package com;
import java.sql.*;

public class test_1 {
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String DB = "student_db";
        String table = "dbo.grade_1";


        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName = "+DB;
        String user = "sa";
        String password = "tzh15029564815";

        String sql = "select * from "+table;
        try{

            con = DriverManager.getConnection(dbURL,user,password);
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                String id = rs.getString("id");
                String username = rs.getString("name");
                String grade = rs.getString("grade");

                System.out.println("id: "+id+"  姓名: "+username+"   成绩: "+grade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败！");
        }
        finally {
            JDBCUtil.release(con, st, rs);
        }
    }
}
