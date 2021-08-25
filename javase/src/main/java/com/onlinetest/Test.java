package com.onlinetest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Faster
 * @date 2019/9/16 22:13
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] arr = in.next().toCharArray();
        Map<Character, Node> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            Node node = map.get(arr[i]);
            if (node == null) {
                Node no = new Node();
                no.count = 1;
                no.index = index++;
                map.put(arr[i],no);
            }else{
                node.count +=1;
                map.put(arr[i],node);
            }
        }
        int minIndex = Integer.MAX_VALUE;
        char result = 0;
        for(Map.Entry<Character,Node> entry:map.entrySet()){
            Node node = entry.getValue();
            if(node.count ==1&&minIndex>node.index){
                minIndex = node.index;
                result = entry.getKey();
            }
        }
        System.out.println(minIndex==Integer.MAX_VALUE?"null":result);
    }
    static class Node{
        int count;
        int index;
    }
}
