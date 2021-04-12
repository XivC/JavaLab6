package com.xivs;

import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;

import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private boolean isConnected = false;
    private int port;
    private byte[] ip;


    public Client(){


    }
    public void connect(byte[] ip, int port){
        try {
            InetAddress address = InetAddress.getByAddress(ip);
            this.port = port;
            this.ip = ip;
            this.socket = new Socket(address, this.port);
            this.isConnected = true;

        }
        catch (IOException ex){
            this.isConnected = false;
        }
    }
    public void disconnect(){
        try {
            this.isConnected = false;
            this.socket.close();

        }
        catch (IOException ex){
            this.isConnected = false;
        }

    }
    public void waitConnection(){
        System.out.println("Сервер умер. Пробуем восстановить соединение");
        while(!this.isConnected) {

                byte[] ip = this.ip;
                this.connect(ip, port);


        }
        System.out.println("Соединение восстановлено");

    }
    public Response receive(){

        try{
            Response resp;
            InputStream inputStream = this.socket.getInputStream();
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);
            resp = (Response) objectStream.readObject();

            return resp;

        }
        catch (IOException | ClassNotFoundException | NullPointerException ex){
            this.isConnected = false;
            try {
                this.socket.close();
            }catch(IOException ex1){ex1.printStackTrace();}
            this.waitConnection();
            return null;
        }

    }
    public boolean sendRequest(Request rq){
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
         try{

             ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
             objectStream.writeObject(rq);
             objectStream.flush();


        }
        catch(IOException ex){ex.printStackTrace();}
        byte[] bytes = byteStream.toByteArray();
        try {
            OutputStream outputStream =this.socket.getOutputStream();
            outputStream.write(bytes);
            return true;

        }
        catch (IOException | NullPointerException ex){
            this.isConnected = false;
            try {
                this.socket.close();
            }catch(IOException ex1){ex1.printStackTrace();}
            this.waitConnection();
            return false;
        }

    }
    public boolean isConnected(){return this.isConnected;}
}
