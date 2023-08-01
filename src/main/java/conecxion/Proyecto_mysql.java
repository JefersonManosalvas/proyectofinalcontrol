/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package conecxion;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jefferson
 */
public class Proyecto_mysql {

    public static void main(String[] args) throws ClassNotFoundException {
        conMysql con = new conMysql();
        ResultSet resultado = con.EjecutaSql("SELECT * FROM cliente");
        try {
            while (resultado.next()) {
                System.out.println(resultado.getString(1)+" "+resultado.getString(2)+" "+resultado.getString(3)+" "+resultado.getString(4));
                
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LA CONSULTA");
        }

    }
}
