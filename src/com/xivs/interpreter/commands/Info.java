package com.xivs.interpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.dataTransfer.Utils;
import com.xivs.interpreter.Interpreter;
import com.xivs.io.OutputManager;

import java.util.HashMap;

public class Info extends InterpreterCommand{
    public Info(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        Request rq = new Request("info", new HashMap<>());
        if(client.sendRequest(rq)){
            Response resp = client.receive();
            Utils.printResponseMessages(resp);
        }


    }
    @Override
    public String info(){
        return "Вывести информацию о коллекции";
    }
}
