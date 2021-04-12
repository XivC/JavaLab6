package com.xivs;

import com.xivs.builders.lineBuilders.LineWorkerBuilder;
import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.interpreter.Interpreter;
import com.xivs.io.CommandLineInputManager;
import com.xivs.io.CommandLineOutManager;
import com.xivs.io.FileInputManager;
import com.xivs.io.VoidOutputManager;
import com.xivs.lab.Worker;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here


        CommandLineInputManager manager = new CommandLineInputManager();
        Request rq;
        Client client = new Client();
        client.connect(new byte[]{127,0,0,1}, 13337);
        if(!client.isConnected()){
            client.waitConnection();
        }
        Interpreter interpreter = new Interpreter(new CommandLineInputManager(), new CommandLineOutManager(), client);
        interpreter.run();



    }
}
