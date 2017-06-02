/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author aniej
 */
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class Client
{
    Sender sender;
    Receiver receiver;
    BusinessLogicUnit BLU;
    GameObject game;
    public static int PORT = 9876;
    
    private void interrupt(DatagramSocket socket, int milliseconds) throws InterruptedException
    {
        Thread.sleep(milliseconds);
        socket.close();
    }
    
    public Client() throws IOException, InterruptedException
    {
        DatagramSocket clientSocket = null;
        byte[] receiveData = new byte[4];
        for (int i = 0; i < 4; i++)
            receiveData[i] = 0;
        byte[] sendData = new byte[1];
        sendData[0] = 0;
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getLocalHost(), PORT);
        clientSocket = new DatagramSocket();
        clientSocket.send(sendPacket);
        System.out.println("poszlo");  
        clientSocket.receive(receivePacket);
        int port = ByteBuffer.wrap(receiveData).getInt();
        clientSocket = new DatagramSocket(port);
        this.BLU = new BusinessLogicUnit(this);
        this.sender = new Sender(clientSocket, this, this.BLU);
        this.BLU.setSender(this.sender);
        this.receiver = new Receiver(clientSocket, this, this.BLU);
        new Thread(this.sender).start();
        new Thread(this.BLU).start();
        new Thread(this.receiver).start();
    }
    
    public static void main(String[] args) throws IOException, InterruptedException
    {
        new Client();
    }
}
