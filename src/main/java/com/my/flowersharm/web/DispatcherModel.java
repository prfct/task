package com.my.flowersharm.web;

import com.my.flowersharm.controller.parsers.Parser;
import com.my.flowersharm.controller.parsers.ParserMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherModel implements Model {
    private Map<String, Object> attributes = new HashMap<>();
    private Map<String, String[]> parameters;

    @Override
    public void setAttribute(String key, Object o) {
        attributes.put(key, o);
    }

    @Override
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes.putAll(attributes);
    }

    @Override
    public String findParameter(String key) {
        String result = null;
        String[] params = parameters.get(key);
        if (params != null && params.length > 0) {
            result = params[0];
        }
        return result;
    }

    @Override
    public <T> T findParameter(String key, Parser<T> parser) {
        return parser.parse(key, parameters.get(key));
    }

    @Override
    public <K, V> Map<K, V> findParameterMap(ParserMap<K, V> parser) {
        return parser.parse(parameters);
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public Map<String, String[]> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String[]> parameters) {
        this.parameters = parameters;
    }
}
