package com.tu.topsort;

import java.util.*;

public class TestTopSort {
    public static void main(String[] args) {
        int n = 4;
        int[][] map = new int[n][n];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map[a][b] = 1;
        }
        Map[] graph = createGraph(map, n);
        for (Map<Object, Object> g : graph) {
            for (Map.Entry<Object, Object> entry : g.entrySet()) {
                System.out.println(entry.getKey() + "。。。。。" + entry.getValue());
            }
        }

    }

    private static Map[] createGraph(int[][] map, int n) {
        Map[] graph = new Map[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap();
            graph[i].put("data", i);
            graph[i].put("in", 0);//入度初始化为0
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    graph[j].put("in", (Integer) graph[j].get("in") + 1);
                    list.add(j);
                }
            }
            graph[i].put("list", list);
        }
        return graph;
    }
}


