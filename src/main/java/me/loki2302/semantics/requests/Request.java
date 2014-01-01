package me.loki2302.semantics.requests;

import me.loki2302.semantics.Intention;

public interface Request<TResult> {
    Intention getIntention();
    int getArgumentCount();
    Object getArgument(int index);
}