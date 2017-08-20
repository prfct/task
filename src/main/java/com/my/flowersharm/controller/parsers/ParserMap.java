package com.my.flowersharm.controller.parsers;

import java.util.List;
import java.util.Map;

/**
 * Created by Stein on 28.11.16.
 */
public abstract class ParserMap<T> {
    private static final String ERROR_POSTFIX = "_error";

    public abstract List<T> parse(Map<String, String[]> parameters);


    String createErrorKey(String key) {
        return key + ERROR_POSTFIX;
    }
}
