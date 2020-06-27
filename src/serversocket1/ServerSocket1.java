
package serversocket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSocket1 {

    public static void main(String[] args) {
         
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Servidor iniciado...");
            
            Socket cliente = server.accept();
            System.out.println("Cliente aceptado...");
            
            InputStreamReader isr = new InputStreamReader(cliente.getInputStream());
            BufferedReader receptor = new BufferedReader(isr);
            
            PrintWriter emisor = new PrintWriter(cliente.getOutputStream());
            
            String msg = receptor.readLine();
            System.out.println("Msg" + msg);
            
            emisor.println("Quetal...");
            emisor.flush();
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServerSocket1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
