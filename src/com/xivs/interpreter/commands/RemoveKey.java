package com.xivs.interpreter.commands;

import com.xivs.dataTransfer.DataTransference;
import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.dataTransfer.Utils;
import com.xivs.interpreter.Interpreter;
import com.xivs.lab.Worker;

import java.util.HashMap;


public class RemoveKey extends InterpreterCommand {
    public RemoveKey (Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        if(inputManager.getWords().size() < 2 || inputManager.getWords().get(1).isEmpty() ){ outputManager.println("Неверное количество аргументов"); return;}
        String key = inputManager.getWords().get(1);


            HashMap<String, DataTransference<?>> arguments = new HashMap<>();
            arguments.put("key", new DataTransference<String>(String.class, key));

            Request rq = new Request("remove_key", arguments);
            if(client.sendRequest(rq)){
                Response resp = client.receive();
                Utils.printResponseMessages(resp);
            }


    }
    @Override
    public String info(){
        return "Удаляя объект по ключу. remove <key>";
    }

}
