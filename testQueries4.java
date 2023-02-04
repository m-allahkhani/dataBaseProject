package src;

import java.sql.*;

public class testQueries4 {
    public static void main(String[] args){
        String start="1400-06-18";
        String end="1400-08-11";
        System.out.println(getSum(start,end));
    }
    public static int getSum(String start,String end) {
        int totalsell=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection mysqlConnection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/DBproject",
                            "root", "M.A.Toopkanlu");
            CallableStatement callableStat1;
            callableStat1 = mysqlConnection.prepareCall("{?=call selltotal(?,?)}");
            callableStat1.registerOutParameter(1, Types.INTEGER);
            callableStat1.setString(2,start);
            callableStat1.setString(3,end);
            callableStat1.execute();
            totalsell=callableStat1.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return totalsell;
    }
}
