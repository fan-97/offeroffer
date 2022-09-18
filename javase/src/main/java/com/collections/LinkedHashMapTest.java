package com.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Faster
 * @date 2019/9/8 22:53
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.put("zhangsan", 1);
        linkedMap.put("zhangsan02", 1);
        linkedMap.put("zhangsan03", 1);
        linkedMap.get("zhangsan");
        for (Map.Entry<String, Integer> entry : linkedMap.entrySet()) {
            System.out.println(entry.getKey() + "..........." + entry.getValue());
        }
    }
}
