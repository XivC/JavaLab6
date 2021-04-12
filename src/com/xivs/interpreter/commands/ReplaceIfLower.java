package com.xivs.interpreter.commands;


import com.xivs.builders.lineBuilders.LineWorkerBuilder;
import com.xivs.dataTransfer.DataTransference;
import com.xivs.dataTransfer.Request;
import com.xivs.dataTransfer.Response;
import com.xivs.dataTransfer.Utils;
import com.xivs.interpreter.Interpreter;
import com.xivs.lab.Worker;

import java.io.IOException;
import java.util.HashMap;


public class ReplaceIfLower extends InterpreterCommand{
    public ReplaceIfLower(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){

        if(inputManager.getWords().size() < 3 ){ outputManager.println("Неверное количество аргументов"); return;}
        String key = inputManager.getWords().get(1);
        String sal = inputManager.getWords().get(2);

            if (Worker.Params.salary.parse(sal)) {
                Float salary = Worker.Params.salary.get();

                HashMap<String, DataTransference<?>> arguments = new HashMap<>();
                arguments.put("salary", new DataTransference<Float>(Float.class, salary));
                arguments.put("key", new DataTransference<String>(String.class, key));
                Request rq = new Request("replace_if_lower", arguments);
                if (client.sendRequest(rq)) {
                    Response resp = client.receive();
                    Utils.printResponseMessages(resp);
                }
            } else {
                outputManager.println("Синтаксическая ошибка. проверьте корректность аргументов");
                return;
            }




    }
    @Override
    public String info(){
        return "Заменяет рабочего по ключу, если новое значение ЗП меньше старого";
    }
}
