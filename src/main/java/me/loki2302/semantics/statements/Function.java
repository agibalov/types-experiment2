package me.loki2302.semantics.statements;

public class Function {
    private final String name;
    private final Statement body;
    
    public Function(String name, Statement body) {
        this.name = name;
        this.body = body;
    }
    
    public String getName() {
        return name;
    }
    
    public Statement getBody() {
        return body;
    }
}