package me.loki2302.syntax.expectations.element.program;

import me.loki2302.syntax.dom.programs.DOMProgram;

public interface ProgramExpectation {
    void check(DOMProgram domProgram);
}