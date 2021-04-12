package com.xivs.interpreter.commands;

import com.xivs.interpreter.Interpreter;
import com.xivs.io.OutputManager;

import java.util.HashMap;

public class Help extends InterpreterCommand{
    public Help(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        for(String key: this.interpreter.getExecutors().keySet()){
            outputManager.println(key + ": " + this.interpreter.getExecutors().get(key).info());
        }

    }
    public String info(){
        return "вывести справку по доступным командам";
    }
}
