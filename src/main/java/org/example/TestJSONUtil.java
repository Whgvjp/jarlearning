package org.example;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJSONUtil {
    public static void main(String[] args) {
        // 1) 基础：判断JSON类型、解析为对象
        String objStr = "{\"name\":\"张三\",\"age\":18}";
        String arrStr = "[{\"name\":\"张三\",\"age\":18},{\"name\":\"李四\",\"age\":20}]";
        // 修复：Hutool JSONUtil 没有 isTypeJSONObject/isTypeJSONArray 方法，改用 isJsonObj/isJsonArray
        System.out.println("isObj: " + JSONUtil.isJsonObj(objStr));
        System.out.println("isArr: " + JSONUtil.isJsonArray(arrStr));
        System.out.println("isArr: " + JSONUtil.isJsonArray(objStr));

        JSONObject obj = JSONUtil.parseObj(objStr);
        JSONArray arr = JSONUtil.parseArray(arrStr);
        System.out.println("obj: " + obj);
        System.out.println("arr size: " + arr.size());

        // 2) JSON -> Bean（对象与列表）
        User user = JSONUtil.toBean(obj, User.class);
        System.out.println("bean from obj: " + user);

        List<User> userList = JSONUtil.toList(arr, User.class);
        System.out.println("bean list size: " + userList.size());

        // 3) Bean / Map / List -> JSON 字符串（紧凑/美化）
        String compact = JSONUtil.toJsonStr(user);
        String pretty = JSONUtil.toJsonPrettyStr(user);
        System.out.println("compact: " + compact);
        System.out.println("pretty:\n" + pretty);

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1001);
        map.put("title", "Hutool JSON");
        map.put("tags", new String[]{"util", "json"});
        System.out.println("map -> json: " + JSONUtil.toJsonStr(map));

        // 4) 构造/修改 JSONObject 与路径读取
        JSONArray skills = new JSONArray();
        skills.add("Java");
        skills.add("Hutool");
        JSONObject built = JSONUtil.createObj()
                .set("name", "王五")
                .set("age", 22)
                .set("address", JSONUtil.createObj().set("city", "Shenzhen").set("zip", "518000"))
                .set("skills", skills);
        System.out.println("built: " + built);

        // 路径读取（点路径）
        Object city = JSONUtil.getByPath(built, "address.city");
        System.out.println("city by path: " + city);

        // 修改与删除
        built.set("age", 23);
        built.remove("skills");
        System.out.println("after edit: " + built);

        // 5) JSONArray 常用：遍历、转List
        JSONArray numbers = JSONUtil.parseArray("[1,2,3,4]");
        List<Integer> numList = JSONUtil.toList(numbers, Integer.class);
        System.out.println("nums: " + numList);

        // 6) 混合结构：List<Bean> -> JSON；JSON -> List<Bean>
        List<User> listToJson = new ArrayList<>();
        listToJson.add(new User("甲", 30));
        listToJson.add(new User("乙", 28));
        String listJson = JSONUtil.toJsonPrettyStr(listToJson);
        System.out.println("list -> json:\n" + listJson);

        List<User> backToList = JSONUtil.toList(JSONUtil.parseArray(listJson), User.class);
        System.out.println("json -> list size: " + backToList.size());

        // 7) 宽松解析为 Map（动态结构）
        Map<?, ?> dyn = JSONUtil.toBean(objStr, Map.class);
        System.out.println("to Map: " + dyn);
    }
}
