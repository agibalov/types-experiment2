package me.loki2302.syntax.expectations.element.typereference;

import me.loki2302.syntax.dom.types.DOMNamedTypeReference;

public interface NamedTypeReferenceExpectation {
    void check(DOMNamedTypeReference domNamedTypeReference);
}