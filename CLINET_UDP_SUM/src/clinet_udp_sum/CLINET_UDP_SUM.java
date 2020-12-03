
package clinet_udp_sum;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CLINET_UDP_SUM {

   
    public static void main(String[] args) {
       
        try {
            DatagramSocket client=new DatagramSocket();
            
            Scanner numsin=new Scanner(System.in);
            System.out.println("please enter the first number.");
            //String  num1=numsin.nextLine();
            byte num1=numsin.nextByte();
            System.out.println("please enter the second number.");
            //String  num2=numsin.nextLine();
            byte num2=numsin.nextByte();
            
            byte []nums={(byte)num1 ,(byte)num2};
            //byte []firstnum= num1.getBytes();
            //byte []secnum= num1.getBytes();
            
            
            
            DatagramPacket packetnum1=new DatagramPacket(nums,nums.length,InetAddress.getLocalHost(),4000);
            //DatagramPacket packetnum2=new DatagramPacket(secnum,secnum.length,InetAddress.getLocalHost(),4000);
            
            client.send(packetnum1);
            //client.send(packetnum2);
            System.out.println("data sent to server to calculate the summition of it ..........");
            
            System.out.println("waiting to recive data from server............");
            DatagramSocket reciveSocket=new DatagramSocket(4444);
            DatagramPacket packetResult=new DatagramPacket(new byte[256],256);
            reciveSocket.receive(packetResult);
            
            System.out.println("result is : = "+packetResult.getData()[0]);
            
        } catch (SocketException ex) {
            System.out.println("erro is : "+ex);
        } catch (IOException ex) {
            Logger.getLogger(CLINET_UDP_SUM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
