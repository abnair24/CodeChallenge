package com.abn.design.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonFlattener {

    public Map<String, Object> flatten(Map<String, Object> input) {
        Map<String, Object> result = new LinkedHashMap<>();
        walk(input, new StringBuilder(), result);
        return result;
    }

    private void walk(Map<String, Object> current, StringBuilder path, Map<String, Object> result) {
        for (Map.Entry<String, Object> entry : current.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            int savedLength = path.length();
            path.append(key);

            if (value instanceof Map) {
                path.append(".");
                @SuppressWarnings("unchecked")
                Map<String, Object> nested = (Map<String, Object>) value;
                walk(nested, path, result);
            } else {
                result.put(path.toString(), value);
            }

            path.setLength(savedLength);
        }
    }

    public static void main(String[] args) {
        Map<String, Object> address = new LinkedHashMap<>();
        address.put("city", "Bengaluru");
        address.put("ssn", "123-45");

        Map<String, Object> user = new LinkedHashMap<>();
        user.put("name", "Aswathy");
        user.put("email", "a@okta.com");
        user.put("address", address);

        Map<String, Object> input = new LinkedHashMap<>();
        input.put("user", user);
        input.put("role", "admin");

        Map<String, Object> flat = new JsonFlattener().flatten(input);
        flat.forEach((k, v) -> System.out.println(k + " = " + v));
    }

}
