package me.loki2302.operations;

import java.util.List;

import me.loki2302.Compiler;
import me.loki2302.Intention;

public interface Operation {
    Intention getIntention();
    OperationResult process(Compiler compiler, List<Object> arguments);
}