package me.loki2302.strings;

public class ConstrainedStringResult {
    public boolean ok;
    public int score;
    public String constrainedString;
    
    public static ConstrainedStringResult ok(int score, String constrainedString) {
        ConstrainedStringResult constrainedStringResult = new ConstrainedStringResult();
        constrainedStringResult.ok = true;
        constrainedStringResult.score = score;
        constrainedStringResult.constrainedString = constrainedString;
        return constrainedStringResult;
    }
    
    public static ConstrainedStringResult fail() {
        ConstrainedStringResult constrainedStringResult = new ConstrainedStringResult();
        constrainedStringResult.ok = false;
        return constrainedStringResult;
    }
}