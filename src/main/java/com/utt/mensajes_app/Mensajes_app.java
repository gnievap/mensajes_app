/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.utt.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author gabyn
 */
public class Mensajes_app {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion = 4;
        do{
            System.out.println("----------------------------------");
            System.out.println(" Aplicación de mensajes ");
            System.out.println("1 - Crear mensaje");
            System.out.println("2 - Listar mensajes");
            System.out.println("3 - Eliminar mensaje");
            System.out.println("4 - Editar mensaje");
            System.out.println("5 - Salir de la aplicación");
            opcion = sc.nextInt();
            switch ( opcion ){
                case 1: 
                    MensajesService.crearMensaje();
                    break;
                case 2: 
                    MensajesService.listarMensajes();
                    break;
                case 3: 
                    MensajesService.borrarMensaje();
                    break;
                case 4: 
                    MensajesService.editarMensaje();
                    break;
                default:
                    break;
            }
          }while (opcion != 5);
       }
    }

