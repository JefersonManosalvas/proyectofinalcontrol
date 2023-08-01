/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conecxion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jefferson
 */
public class conMysql {

    private String url = "jdbc:mysql://localhost:3306/acceso_lab?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String usuario = "root";
    private String clave = "j2003";

    public ResultSet EjecutaSql(String sql) throws ClassNotFoundException {
        ResultSet resultado = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, usuario, clave);
            PreparedStatement pst = con.prepareStatement(sql);
            resultado = pst.executeQuery();
            return resultado;
        } catch (SQLException e) {
            return resultado;
        }

    }
}
