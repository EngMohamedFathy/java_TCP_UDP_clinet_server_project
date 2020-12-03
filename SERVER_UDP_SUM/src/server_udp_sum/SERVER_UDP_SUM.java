package server_udp_sum;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SERVER_UDP_SUM {

    public static void main(String[] args) {

        try {
            DatagramSocket server = new DatagramSocket(4000);

            DatagramPacket pktnum1 = new DatagramPacket(new byte[256], 256);
            //DatagramPacket pktnum2=new DatagramPacket(new byte[256],256);
            while (true) {

                System.out.println("waiting to recive packets from clients ............");
                server.receive(pktnum1);
            //server.receive(pktnum2);

           // String strnum1=new String(pktnum1.getData());
                //String strnum2=new String(pktnum2.getData());
            //int num1=Integer.parseInt(strnum1);
                //int num2=Integer.parseInt(strnum2);
                System.out.println("make calculation ..");
                byte[] nums = pktnum1.getData();

                int result = nums[0] + nums[1];
                System.out.println("result is = " + result);

                byte[] rst = {(byte) result};
                System.out.println("make calculation done ");

            //long result=Integer.getInteger((pktnum1.getData()).toString()) + Integer.getInteger((pktnum2.getData()).toString()) ;
                System.out.println("send data to clients ...................");
                DatagramPacket result_send = new DatagramPacket(rst, rst.length, InetAddress.getLocalHost(), 4444);
                DatagramSocket sendSocket = new DatagramSocket();
                sendSocket.send(result_send);
                System.out.println("--------------opetation done complete--------------------");

            }

        } catch (SocketException ex) {
            System.out.println("error is : " + ex);
        } catch (IOException ex) {
            System.out.println("erro is : " + ex);
        }

    }

}
