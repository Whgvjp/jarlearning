package org.example;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;

public class CollUtilDemo {
    public static void main(String[] args) {
        ArrayList<String> a = CollUtil.newArrayList("a", "b", "c");
        ArrayList<String> b = CollUtil.newArrayList("b", "c", "d");

        System.out.println("isEmpty: " + CollUtil.isEmpty(a));
        System.out.println("union: " + CollUtil.union(a, b));
        System.out.println("intersection: " + CollUtil.intersection(a, b));
        System.out.println("disjunction: " + CollUtil.disjunction(a, b));
        System.out.println("subtract: " + CollUtil.subtract(a, b));

        // 拼接
        System.out.println("join: " + CollUtil.join(a, ","));

        // 固定容量列表与不可变集合
        System.out.println("unmodifiable: " + CollUtil.unmodifiable(a));
    }
}


