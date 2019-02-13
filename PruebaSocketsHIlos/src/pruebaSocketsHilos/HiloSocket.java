/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaSocketsHilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo Ramírez
 */
public class HiloSocket extends Thread
{   Socket cliente;
    DataInputStream dIn;
    public HiloSocket(Socket cliente, DataInputStream dIn){
       this.cliente = cliente;
        this.dIn = dIn;
    }
    @Override
    public void run() {
    try {
        Scanner entrada = new Scanner(dIn);
        
        String msj = entrada.nextLine();
        System.out.println("Cliente dice: " + msj);
        entrada.close();
        cliente.close();
    } catch (IOException ex) {
        Logger.getLogger(HiloSocket.class.getName()).log(Level.SEVERE, null, ex);
    }
               
               
       
    }
}
