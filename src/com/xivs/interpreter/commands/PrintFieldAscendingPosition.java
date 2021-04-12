package com.xivs.interpreter.commands;


import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.dataTransfer.Utils;
import com.xivs.interpreter.Interpreter;

import java.util.HashMap;

public class PrintFieldAscendingPosition extends InterpreterCommand{
    public PrintFieldAscendingPosition(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        Request rq = new Request("print_field_ascending_position", new HashMap<>());
        if(client.sendRequest(rq)){
            Response resp = client.receive();
            Utils.printResponseMessages(resp);
        }

    }
    @Override
    public String info(){
        return "вывести список рабочих, отсортированный по должности в формате key - position";
    }
}
