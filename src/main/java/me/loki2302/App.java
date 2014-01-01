package me.loki2302;

public class App {
    public static void main(String[] args) {
        CompilerFacade compilerFacade = CompilerFacade.makeDefault();
        System.out.println(compilerFacade.compile(" 1 + 3.14 "));
    } 
}
