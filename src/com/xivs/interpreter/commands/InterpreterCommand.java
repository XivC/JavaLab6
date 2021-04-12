package com.xivs.interpreter.commands;

import com.xivs.Client;
import com.xivs.interpreter.Interpreter;
import com.xivs.io.InputManager;
import com.xivs.io.OutputManager;

public abstract class InterpreterCommand extends Command{
    Interpreter interpreter;
    InputManager inputManager;
    OutputManager outputManager;
    Client client;
    public InterpreterCommand(Interpreter interpreter){

        this.interpreter = interpreter;
        this.inputManager = interpreter.getInputManager();
        this.outputManager = interpreter.getOutputManager();
        this.client = interpreter.getClient();
    }
    public String info(){
        return "";
    };
}
