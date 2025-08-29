package org.example;

import cn.hutool.core.util.StrUtil;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StrUtilDemo {
    public static void main(String[] args) {
        String blank = "  \t\n  ";
        System.out.println("isBlank: " + StrUtil.isBlank(blank));
        System.out.println("trim: '" + StrUtil.trim(blank) + "'");

        // 模板格式化
        String tpl = "你好，{}，今天是 {}";
        System.out.println(StrUtil.format(tpl, "小明", "星期五"));

        // 驼峰与下划线互转
        String camel = "userName";
        String underline = StrUtil.toUnderlineCase(camel);
        System.out.println("underline: " + underline);
        System.out.println("camel: " + StrUtil.toCamelCase(underline));

        // 前后缀处理
        System.out.println(StrUtil.removePrefix("/api/user", "/"));
        System.out.println(StrUtil.removeSuffix("hello.txt", ".txt"));

        // 拆分与拼接
        String[] parts = StrUtil.splitToArray("a,b,c", ',');
        System.out.println("split: " + Arrays.toString(parts));
        System.out.println("join: " + StrUtil.join("-", parts));

        // 字节与编码
        byte[] bytes = StrUtil.bytes("Hutool", StandardCharsets.UTF_8);
        System.out.println("bytes length: " + bytes.length);
        System.out.println("str: " + StrUtil.str(bytes, StandardCharsets.UTF_8));
    }
}


