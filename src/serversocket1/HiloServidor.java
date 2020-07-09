
package serversocket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloServidor extends Thread{
    
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket=null;
    
    public HiloServidor(Socket socket){
        this.socket=socket;
        
    try{
        fsalida = new PrintWriter(socket.getOutputStream(),true);
        fentrada = BufferedReader(new InputStreamReader(socket.getInputStream()));
    } catch(IOException ex){
        Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
}   
    
    }  
    
    @Override
    public void run(){
        
        try {
            
            String msg=fentrada.readLine();
            System.out.println("Msg: " + msg);
            
            fsalida.println("Quetal...");
            fsalida.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        try{
            fsalida.close();
            fentrada.close();
            socket.close();
           
        }catch(IOException ex){
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    private BufferedReader BufferedReader(InputStreamReader inputStreamReader) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
    
