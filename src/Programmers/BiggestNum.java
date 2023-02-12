package Programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * level 2
 * 가장 큰 수
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */

public class BiggestNum {
    public String solution(int[] numbers) {
        String answer = "";

        String[] strArr = new String[numbers.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        /*
        for (int i = 0; i < strArr.length; i++) {
            answer += strArr[i];
        }
        */

        // 문자열을 합칠 때는 StringBuilder를 쓰는게 성능이 훨씬 좋다고 한다.
        StringBuilder sb = new StringBuilder();
        for (String s: strArr) {
            sb.append(s);
        }

        answer = String.valueOf(sb);

        // 모든 원소가 0일 경우 대비
        if (strArr[0].equals("0")) answer = "0";

        return answer;
    }
}
