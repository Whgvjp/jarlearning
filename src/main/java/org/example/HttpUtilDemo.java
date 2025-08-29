package org.example;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class HttpUtilDemo {
    public static void main(String[] args) {
        // 简单 GET（需要联网）
        String get = HttpUtil.get("https://httpbin.org/get");
        System.out.println("GET: \n" + get);

        // 带参数的 POST
        Map<String, Object> form = new HashMap<>();
        form.put("name", "hutool");
        form.put("lang", "java");
        String post = HttpUtil.post("https://httpbin.org/post", form);
        System.out.println("POST form: \n" + post);

        // 自定义请求（超时与请求头）
        try (HttpResponse resp = HttpRequest.get("https://httpbin.org/headers")
                .header(Header.USER_AGENT, "JarLearning/1.0")
                .timeout(5000)
                .execute()) {
            System.out.println("custom headers: \n" + resp.body());
        }
    }
}


