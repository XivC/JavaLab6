package com.xivs.builders.lineBuilders;

import com.xivs.builders.Builder;
import com.xivs.io.InputManager;
import com.xivs.io.OutputManager;

import java.io.IOException;

public abstract class LineBuilder<T extends Object> extends Builder<T> {
    InputManager inputManager;
    OutputManager outputManager;
    public LineBuilder(InputManager inputManager, OutputManager outputManager){
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }


}
