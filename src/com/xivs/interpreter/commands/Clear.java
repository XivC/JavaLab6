package com.xivs.interpreter.commands;


import com.xivs.Client;
import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.interpreter.Interpreter;
import com.xivs.dataTransfer.Utils;
import java.util.HashMap;

public class Clear extends InterpreterCommand{
    public Clear(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        Request rq = new Request("clear", new HashMap<>());
        if(client.sendRequest(rq)){
            Response resp = client.receive();
            Utils.printResponseMessages(resp);
        }

    }
}
