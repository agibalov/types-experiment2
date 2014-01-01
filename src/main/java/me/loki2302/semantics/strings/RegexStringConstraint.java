package me.loki2302.semantics.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexStringConstraint implements StringConstraint {
    private final Pattern pattern;
    
    public RegexStringConstraint(String regex) {
        pattern = Pattern.compile(regex);
    }        

    @Override
    public ConstrainedStringResult test(String s) {
        Matcher matcher = pattern.matcher(s);
        if(matcher.matches()) {
            return ConstrainedStringResult.ok(0, s);
        }
        
        return ConstrainedStringResult.fail();
    }        
}