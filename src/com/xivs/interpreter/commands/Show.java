package com.xivs.interpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.dataTransfer.Utils;
import com.xivs.interpreter.Interpreter;
import com.xivs.io.InputManager;
import com.xivs.io.OutputManager;

import java.util.HashMap;

public class Show extends InterpreterCommand{
    public Show(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        Request rq = new Request("show", new HashMap<>());
        if(client.sendRequest(rq)){
            Response resp = client.receive();
            Utils.printResponseMessages(resp);
        }


    }
    @Override
    public String info() {
        return "показывает список элементов коллекции";
    }
}
