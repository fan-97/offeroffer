package com.str;

public class KMPTest {
    public static void main(String[] args) {
        String s = "abababab";
        String t = "ab";
        int pos = kmp(s,t);
        System.out.println(pos);
    }

    public static void get_next(String t, int next[]) {
        char arr_t[] = t.toCharArray();
        int len = arr_t.length;
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < len - 1) {
            if (j == -1 || arr_t[j] == arr_t[i]) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static int kmp(String s, String t) {
        int[] next = new int[t.length()];
        get_next(t, next);
        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();
        int pos = -1;
        int i = 0;
        int j = 0;
        while (i < s.length() - 1 && j < t.length() - 1) {
            if (j == -1 || arr_s[i] == arr_t[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        return i - j;
    }
}


