package com.zetcode;

import java.util.HashMap;
import java.util.Map;

public class HashMapForEach {

    public static void main(String[] args) {

        Map<String, String> capitals = new HashMap<>();

        capitals.put("svk", "Bratislava");
        capitals.put("ger", "Berlin");
        capitals.put("hun", "Budapest");
        capitals.put("czk", "Prague");
        capitals.put("pol", "Warsaw");
        capitals.put("ita", "Rome");

        capitals.forEach((k, v) -> System.out.format("%s: %s%n", k, v));
    }
}
