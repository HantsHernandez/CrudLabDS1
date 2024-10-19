/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PersonaDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar() {
        List<Persona> data = new ArrayList<>();
        String sql = "Select * from users";
        try { 
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTelefono (rs.getString(4));
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
        return data;
    }
    
    public int Agregar (Persona p){
        String sql = "insert into users(Name,Email,Phone) values(?,?,?)";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getTelefono());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al agragar: " + e);
        }
        return 1;
    }
    
    public int Actualizar(Persona p){
        String sql = "update users set Name = ?,Email = ?,Phone = ? where ID = ?";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCorreo());
            ps.setString(3, p.getTelefono());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al actualizar: " + e);
        }
        return 1;
    }
    
    public int eliminar(int id){
        String sql = "delete from users where id = ?";
        try{
           this.con = conectar.getConnection();
           this.ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al Eliminar: " + e);
        }
        return 1;
    }
}
