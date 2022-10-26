/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utt.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gabyn
 */
public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps;
            try {
                String query = "INSERT INTO mensaje (mensaje, autor_mensaje ) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void leerMensajeDB(){
          Conexion db_connect = new Conexion();
           PreparedStatement ps = null;
           ResultSet  rs=null;
        try (Connection conexion = db_connect.get_connection()){
           String query = "SELECT * FROM mensaje";
           ps = conexion.prepareStatement(query);
           rs = ps.executeQuery(); // este método no tiene transacción
           while( rs.next() ){
               System.out.println("ID: " + rs.getInt("Id_mensaje"));
               System.out.println("Mensaje: " + rs.getString("mensaje"));
               System.out.println("Autor: " + rs.getString("autor_mensaje"));
               System.out.println("Fecha del mensaje: " + rs.getString("fecha_mensaje"));
               System.out.println();
           }
           }catch(SQLException ex){
               System.out.println("No se pudieron recuperar los mensajes");
                System.out.println(ex); 
           }
        }
    
    
    
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        
         try (Connection conexion = db_connect.get_connection()){
             PreparedStatement ps = null;
             try{
                 String query = "DELETE from mensaje WHERE id_mensaje  = ?";
                 ps = conexion.prepareStatement(query);
                 ps.setInt(1, id_mensaje);
                 ps.executeUpdate();
                 System.out.println("El mensaje ha sido eliminado con éxito");
                 
             } catch (SQLException e){
                 System.out.println(e);
                 System.out.println("No se pudo borrar el mensaje");
             }
             
         } catch(SQLException ex){
               System.out.println("No se pudo conectar");
                System.out.println(ex); 
           }
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
         try (Connection conexion = db_connect.get_connection()){
             PreparedStatement ps = null;
             try{
                 String query = "UPDATE mensaje SET mensaje = ? WHERE id_mensaje = ?";
                 ps = conexion.prepareStatement(query);
                 ps.setString(1, mensaje.getMensaje());
                 ps.setInt(2, mensaje.getId_mensaje());
                 ps.executeUpdate();
                 System.out.println("El mensaje se actualizó con éxito");
             }catch (SQLException ex){
                 System.out.println(ex);
                 System.out.println("No se pudo actualizar");
             } 
         } catch (SQLException e){
                 System.out.println(e);
        }
    }
}
