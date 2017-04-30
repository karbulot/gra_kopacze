/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

/**
 *
 * @author aniej
 */
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class UDPServer implements Runnable
{
    private byte clientsNumber;
    private List<ClientRecord> clients;
    public UDPServer()
    {
        clientsNumber = 0;
        clients = new ArrayList<ClientRecord>();
    }
    private void newClient(int port, InetAddress iP)
    {
        clients.add(new ClientRecord(port, iP));
        clientsNumber++;
    }
    @Override
    public void run()
    {
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        System.out.println("Server start.");
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9876);
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true)
        {
            System.out.println("Odbieram paczke");
            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length);
            try {
                serverSocket.receive(receivePacket);
                System.out.println("odebralem paczke");
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                newClient(port, IPAddress);
                System.out.println("dodalem klienta");
                sendData[0] = clientsNumber;
                int x = 1;
                for (ClientRecord client : clients)
                {
                    System.out.println(
                        "Przygotowuje sie do wyslania wiadomosci klientowi " + x);
                    TimeUnit.SECONDS.sleep(5);
                    DatagramPacket sendPacket = new DatagramPacket(
                        sendData, sendData.length, client.getIP(), client.getPort());
                    serverSocket.send(sendPacket); 
                    System.out.println("wyslalem wiadomosc klientowi nr " + x);
                    x++;
                }
            } catch (IOException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args)
    {
        Thread server = new Thread(new UDPServer());
        server.start();
    }
}