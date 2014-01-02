package me.loki2302;

import java.io.FileOutputStream;
import java.io.IOException;

import me.loki2302.generator.JavaAppClassGenerator;
import me.loki2302.semantics.expressions.Expression;

public class App {
    public static void main(String[] args) throws IOException {
        CompilerFacade compilerFacade = CompilerFacade.makeDefault();
        Expression e = compilerFacade.compile(" 1 + 3.14 ");
        System.out.println(e);
        
        JavaAppClassGenerator javaAppClassGenerator = JavaAppClassGenerator.makeDefault();
        byte[] appClassBytes = javaAppClassGenerator.generateBytecode(e);
                
        FileOutputStream classFileOutputStream = new FileOutputStream("NewApp.class");
        try {
            classFileOutputStream.write(appClassBytes);
        } finally {
            classFileOutputStream.close();
        }
    } 
}
