package javanet;

import java.io.BufferedReader;
import java.io.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class Client {
    public static void main(String[] args) throws Exception {
          
        Socket s=new Socket("localhost",4999);
        InputStreamReader in =new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader (in);
            
        OutputStream os=s.getOutputStream();
        PrintWriter pr =new PrintWriter(os,true);    
        
        pr.flush();
        
        Scanner sc = new Scanner(System.in);
        String Str = bf.readLine();
                System.out.println(Str);
        while(true){  
            
            String msg = sc.next();
            pr.println(msg);
            
            
            
        }  
           
    }
}
