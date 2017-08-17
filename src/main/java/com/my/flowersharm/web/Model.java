package com.my.flowersharm.web;

import com.my.flowersharm.controller.parsers.Parser;
import com.my.flowersharm.controller.parsers.ParserMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Model {
    void setAttribute(String key, Object o);

    void setAttributes(Map<String, Object> attributes);

    String findParameter(String key);

    <T> T findParameter(String key, Parser<T> parser);

    <K, V> Map<K, V> findParameterMap(ParserMap<K, V> parser);
}
