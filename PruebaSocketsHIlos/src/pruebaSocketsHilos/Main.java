/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaSocketsHilos;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Eduardo Ramírez
 */
public class Main {

    public static void main(String args[]) throws IOException, InterruptedException {
        Socket cliente=null;
        ServerSocket server = new ServerSocket(256);
        
        while (true) {
            System.out.println("Esperando por conexión...");
            cliente = server.accept();
            System.out.println("Cliente conectado!");
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            salida.println("¡Saludos, bienvenido!");
             
            HiloSocket hilo = new HiloSocket(cliente, new DataInputStream(cliente.getInputStream()));
           hilo.start();
           
            
        }
        
    }
}
