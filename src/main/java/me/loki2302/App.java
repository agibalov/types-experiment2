package me.loki2302;

import java.io.FileOutputStream;
import java.io.IOException;

import me.loki2302.generator.JavaAppClassGenerator;
import me.loki2302.semantics.statements.Statement;

public class App {
    public static void main(String[] args) throws IOException {
        CompilerFacade compilerFacade = CompilerFacade.makeDefault();
        Statement s = compilerFacade.compileStatement(" {1 + 3.14;1+1;} ");
        System.out.println(s);
        
        JavaAppClassGenerator javaAppClassGenerator = JavaAppClassGenerator.makeDefault();
        byte[] appClassBytes = javaAppClassGenerator.generateBytecode(s);
                
        FileOutputStream classFileOutputStream = new FileOutputStream("NewApp.class");
        try {
            classFileOutputStream.write(appClassBytes);
        } finally {
            classFileOutputStream.close();
        }
    } 
}
