package me.loki2302.syntax.expectations.element;

import me.loki2302.syntax.dom.DOMElement;

public interface ElementExpectation {
	void check(DOMElement domElement);
}