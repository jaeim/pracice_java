package Programmers;

import java.util.ArrayList;

/**
 * level 1
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class Supo_2 {
    public int[] solution(int[] answers) {
        ArrayList<Integer> ans = new ArrayList<>();

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int s1_h = 0, s2_h = 0, s3_h = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == s1[i % s1.length]) s1_h++;
            if (answers[i] == s2[i % s2.length]) s2_h++;
            if (answers[i] == s3[i % s3.length]) s3_h++;
        }

        int max_h = Math.max(s1_h, Math.max(s2_h, s3_h));
        if (s1_h == max_h) ans.add(1);
        if (s2_h == max_h) ans.add(2);
        if (s3_h == max_h) ans.add(3);

        int[] answer = new int[ans.size()];
        int i = 0;
        for (int a: ans) {
            answer[i++] = a;
        }
        return answer;
    }
}
