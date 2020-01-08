package javanet;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conv extends Thread{
    private int nbr;
    private Socket s;
    
    public Conv(Socket s,int nbr){
        this.s=s;
        this.nbr=nbr;
    }
    @Override
    public void run() {
        
        try {
            InputStreamReader in =new InputStreamReader(this.s.getInputStream());
            BufferedReader bf = new BufferedReader (in);
            
            OutputStream os=s.getOutputStream();
            PrintWriter pr =new PrintWriter(os,true);
            
             
            pr.println("bienvenue le client "+this.nbr);
            String str="";
            while(true){
                str= bf.readLine();
                System.out.println("ok");
                System.out.println("Client "+this.nbr+" : "+str);
            }
            //synchronized(){}
            /*
                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                String str = bf.readLine();
                System.out.println(str);
            */
            
            
        } catch (Exception ex) {
           
        }
    }
}

