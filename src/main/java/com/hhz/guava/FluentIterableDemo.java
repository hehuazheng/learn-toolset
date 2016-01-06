package com.hhz.guava;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

public class FluentIterableDemo {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        for (int i : FluentIterable.from(list).filter(new Predicate<Integer>() {
            public boolean apply(Integer input) {
                return input == 3 || input == 4;
            }
        })) {
            System.out.println(i);
        }
    }

}
