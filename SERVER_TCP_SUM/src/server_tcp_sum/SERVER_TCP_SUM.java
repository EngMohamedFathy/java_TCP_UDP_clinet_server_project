package server_tcp_sum;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;

public class SERVER_TCP_SUM {

    public static void main(String[] args) {

        try {
            System.out.println("waiting to open port on the server..............");
            ServerSocket server = new ServerSocket(4000);
            System.out.println("port successfully opened.");
            while (true) {
                System.out.println("waiting to client to connect to server..........");
                Socket client = server.accept();
                System.out.println("client connected to server");
                
                System.out.println("waiting to fetch data from client device........ ");
                Scanner inputApp = new Scanner(client.getInputStream());
                int num1 = inputApp.nextInt();
                int num2 = inputApp.nextInt();
                System.out.println("done fetch data makeing the calculation(sum) on the data....");

                int result = num1 + num2;

                PrintWriter outApp = new PrintWriter(client.getOutputStream(), true);
                outApp.println(result);
                System.out.println("----------done calculating thank you and data returned to clinet done------------");
                
            }

        } catch (IOException ex) {
            System.out.println("erro in : " + ex);
        }
    }

}
