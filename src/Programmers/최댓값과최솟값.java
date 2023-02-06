package Programmers;

import java.util.ArrayList;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");

        int min = 0;
        int max = 0;

        for(int i = 1; i < arr.length; i++) {
            if (Integer.valueOf(arr[min]) > Integer.valueOf(arr[i])) {
                min = i;
            }
            if (Integer.valueOf(arr[max]) < Integer.valueOf(arr[i])) {
                max = i;
            }

        }
        if (arr.length > 0) {
            answer = arr[min] + " " + arr[max];
        }
        return answer;
    }
}
