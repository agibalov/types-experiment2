package me.loki2302.requests;

import me.loki2302.Intention;

public interface Request<TResult> {
    Intention getIntention();
    int getArgumentCount();
    Object getArgument(int index);
}