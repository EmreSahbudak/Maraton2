package com.bilgeadam.maraton_soru1_jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    //private final String mysqlDriver="com.mysql.cj.jdbc.Driver";
    private final  String url="jdbc:mysql://localhost/maraton_soru1_jdbc?useUnicode" +
            "=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    private final String userName="root";
    private final String userPass="1234bilgeADAM";

    public Connection connection=null;

    public DB(){
        try{
            connection= DriverManager.getConnection(url,userName,userPass);
            if (!connection.isClosed()){
                System.out.println("Connection DB Success");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
