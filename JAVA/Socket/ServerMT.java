package javanet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread{
    private int nbr=0;
    @Override
    public void run(){
        try {
            
            ServerSocket ss = new ServerSocket(4999);
            while(true){
                Socket s= ss.accept();
                nbr++;
                new Conv(s,nbr).start();   
            }
        } catch (Exception ex) {
            
        }  
    }
    
    public static void main(String[] args) throws Exception {
        new ServerMT().start();
    }
}
