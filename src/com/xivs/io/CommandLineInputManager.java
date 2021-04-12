package com.xivs.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandLineInputManager extends InputManager{
    InputStreamReader stream;
    public CommandLineInputManager(){
        super();
        this.stream = new InputStreamReader(new BufferedInputStream(System.in));
    }
    public boolean hasNext(){
        return true;
    }

    /**
     * Получить следующую строчку. Строка пишется в буфферы.
     * @return
     */
    public String nextLine() {
        StringBuilder sb = new StringBuilder();
        try {

            boolean end = false;
            while(!end){
                char c = (char)this.stream.read();
                switch((char)c){
                    case '\n': end = true;
                    case '\r': continue;
                    default: sb.append(c); this.charBuffer.add(c);

                }
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        this.stringBuffer = sb.toString();
        this.wordBuffer = new ArrayList(Arrays.asList(sb.toString().split(" ")));
        return sb.toString();
    }

}

