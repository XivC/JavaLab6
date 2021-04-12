package com.xivs.interpreter.commands;

import com.xivs.interpreter.Interpreter;

public class Exit extends InterpreterCommand{
    public Exit(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        this.interpreter.exit();

    }
    public String info(){
        return "прерывание работы интерпретатора";
    }
}
