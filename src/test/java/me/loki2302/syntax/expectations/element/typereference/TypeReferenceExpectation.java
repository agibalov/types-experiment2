package me.loki2302.syntax.expectations.element.typereference;

import me.loki2302.syntax.dom.types.DOMTypeReference;

public interface TypeReferenceExpectation {
    void check(DOMTypeReference domTypeReference);
}