/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utt.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author gabyn
 */
public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();
        System.out.println("Escribe tu nombre: ");
        String nombre = sc.nextLine();
        
        Mensajes registro  = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajeDB();
    }
    
    public static void borrarMensaje(){
         Scanner sc = new Scanner(System.in);
        System.out.println("Indica el id del mensaje a borrar: ");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }
    
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje: ");
        String mensaje = sc.nextLine();
        
        System.out.println("Indica el id del mensaje a editar: ");
        int id_mensaje = sc.nextInt();
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajesDAO.actualizarMensajeDB(actualizacion);
        
    }
}
