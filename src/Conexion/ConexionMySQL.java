/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author A
 */
public class ConexionMySQL {
     public String url = "jdbc:mysql://localhost/expedientes";
     public String user="root";
     public String pass="";
     
       public ConexionMySQL() {
    }

      
    public Connection conectar() {
        Connection link = null;
        try {
            //Cargamos el Driver MySQL
            Class.forName("org.gjt.mm.mysql.Driver");
            //Creamos un enlace hacia la base de datos
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }
}
