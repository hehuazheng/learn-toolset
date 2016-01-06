package com.hhz.guava;

import java.util.Map;

import com.google.common.base.Splitter;

public class SplitterDemo {

    public static void main(String[] args) {
        String kvStringList = "a=b,c=d";
        Map<String, String> kvs = Splitter.on(',').withKeyValueSeparator("=")
                .split(kvStringList);
        for (Map.Entry<String, String> entry : kvs.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
