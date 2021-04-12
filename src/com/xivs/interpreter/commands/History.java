package com.xivs.interpreter.commands;

import com.xivs.interpreter.Interpreter;
import com.xivs.io.OutputManager;

public class History extends InterpreterCommand{
    public History(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){

        outputManager.println(this.interpreter.getHistory().toString());
    }
    public String info(){
        return "вывести последние 6 команд к интерпретатору";
    }
}
