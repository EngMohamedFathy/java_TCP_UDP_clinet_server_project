
package client_tcp_sum;


import java.io.*;
import java.net.*;
import java.util.Scanner;


public class CLIENT_TCP_SUM {

    
    public static void main(String[] args) {
        
        
        try {
            System.out.println("waiting to connect to server................");        
            Socket client=new Socket("localhost",4000);
            System.out.println("successfully connected with server.");
            
            Scanner numsin=new Scanner(System.in);
            System.out.println("please enter the first number.");
            int num1=numsin.nextInt();
            System.out.println("please enter the second number.");
            int num2=numsin.nextInt();
            
            System.out.println("waiting to make the calculation(sum) on the server...........");
            OutputStream outstream=client.getOutputStream();
            PrintWriter outapp=new PrintWriter(outstream,true);
            outapp.println(num1);
            outapp.println(num2);
            
            
            InputStream inStream=client.getInputStream();
            Scanner inputApp=new Scanner(inStream);
            int result= inputApp.nextInt();
            System.out.println("the result is : "+result);
        } catch (IOException ex) {
            
        }
    }
    
}
