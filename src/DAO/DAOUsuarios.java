/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.ConexionMySQL;
import Objects.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author A
 */
public class DAOUsuarios {
    PreparedStatement pst = null;
    ConexionMySQL c;
    private ResultSet resultSet = null;
    Connection cn;
    
    public DAOUsuarios()
    {
        c = new ConexionMySQL();
        cn = c.conectar();
    }
    public boolean insertarUsuario(Usuario usuario)
    {
        try
        {
            pst=cn.prepareStatement("INSERT INTO usuario(nombre,password,permiso)"
                    + "values(?,?,?)");
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getPassword());
            pst.setInt(3,usuario.getPermiso());
            pst.executeUpdate();
            
        }catch(Exception ex)
        {
            return false;
        }
        
        return true;
    }
    
    public Usuario login(String nombre, String password)
    {
        Usuario usuario=null;
        try
        {
        pst=cn.prepareStatement("SELECT * FROM usuario where nombre=? and password=?");
        pst.setString(1,nombre);
        pst.setString(2,password);
      resultSet=  pst.executeQuery();
      while(resultSet.next())
      {
          usuario=new Usuario();
          usuario.setIdusuario(resultSet.getInt("idusuario"));
          usuario.setNombre(resultSet.getString("nombre"));
          usuario.setPassword(resultSet.getString("password"));
          usuario.setPermiso(resultSet.getInt("permiso"));
         
          
      }
        }
        catch(Exception ex)
        {
            return usuario;
            
        }
        return usuario;
    }
}
