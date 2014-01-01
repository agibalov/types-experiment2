package me.loki2302.semantics.operations;

import java.util.List;

import me.loki2302.semantics.Compiler;
import me.loki2302.semantics.Intention;

public interface Operation {
    Intention getIntention();
    OperationResult process(Compiler compiler, List<Object> arguments);
}