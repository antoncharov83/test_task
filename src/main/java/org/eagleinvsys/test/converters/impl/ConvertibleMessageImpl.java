package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.util.Map;

public class ConvertibleMessageImpl implements ConvertibleMessage {

    private Map<String, String> elements;

    public ConvertibleMessageImpl(Map<String, String> elements) {
        this.elements = elements;
    }

    @Override
    public String getElement(String elementId) {
        return elements != null ? elements.getOrDefault(elementId, "") : "";
    }
}
