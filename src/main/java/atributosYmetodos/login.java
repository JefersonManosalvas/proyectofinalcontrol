/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atributosYmetodos;

import conecxion.conMysql;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jefferson
 */
public class login {
    
    private String usuario;
    private String contrasenia;
        
    
    
      public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
     public void logearse() throws ClassNotFoundException {
       
        if (usuario.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tiene campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            String consulta = ("call telefoonos.login('2','" + getUsuario() + "','" + getContrasenia() + "','',' ');");
            System.out.println("--" + consulta);
            conMysql cn = new conMysql();
            ResultSet rs = cn.EjecutaSql(consulta);

            try {
                if (rs.next()) {
                    
                    JOptionPane.showMessageDialog(null, "Usuario correcto");

//                    Menu p1 = new Menu();
//                    p1.setVisible(true);
//                    this.dispose();

                    LocalDateTime horaIngreso = LocalDateTime.now();
                    System.out.println("Hora de ingreso: " + horaIngreso);

                    String registro = "Usuario ingresoc correcto: " + usuario + ", Hora de ingreso: " + horaIngreso;
                    guardarRegistro(registro);

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario incorrecto");
                    LocalDateTime horaFalla = LocalDateTime.now();
                    System.out.println("Hora de falla: " + horaFalla);

                    String registros = "fallido el ingreso del usuario " + usuario + ", Hora de falla: " + horaFalla;

                    guardarRegistro(registros);
                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void guardarRegistro(String registro) {
        try {
            String rutaArchivo = "C:\\Users\\Jefferson\\Desktop\\JAVA PROGRAMS\\3A programacion visual\\loging\\Usuario.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
                writer.write(registro);
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

  


    
    
}
