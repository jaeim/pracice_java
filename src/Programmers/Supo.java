package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * level 1
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class Supo {
    /* 1. 정답은 맞췄지만..
        - 최댓값 구하는 부분
        - 3개 배열에서 최댓값을 구하고 동점자를 반환하는 과정에서 무한 if
        - 굳이 np1,np2,np3 이렇게 배열을 추가한 부분에 대해 고치고 싶다.
      * */

    public int[] solution(int[] answers) {


        // int[] answer = new int[3];
        int ansSize = answers.length;

        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[] nP1 = new int[ansSize];
        int[] nP2 = new int[ansSize];
        int[] nP3 = new int[ansSize];

        for (int i =0; i < ansSize; i++) {
            nP1[i] = p1[i % p1.length];
            nP2[i] = p2[i % p2.length];
            nP3[i] = p3[i % p3.length];
        }

        int[] tmp = new int[3];
        for (int i = 0; i < ansSize; i++) {
            if (answers[i] == nP1[i]) {
                tmp[0]++;
            }
            if (answers[i] == nP2[i]) {
                tmp[1]++;
            }
            if (answers[i] == nP3[i]) {
                tmp[2]++;
            }
        }
        int maximum = Arrays.stream(tmp).max().getAsInt();
        int arrSize = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (maximum == tmp[i]) arrSize++;
        }
        int[] answer = new int[arrSize];
        if (tmp[0] == tmp[1] && tmp[1] == tmp[2]) {
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        } else if (tmp[0] == tmp[1] && tmp[2] < tmp[1]) {
            answer[0] = 1;
            answer[1] = 2;
        } else if (tmp[1] == tmp[2] && tmp[0] < tmp[1]) {
            answer[0] = 2;
            answer[1] = 3;
        } else if (tmp[0] == tmp[2] && tmp[1] < tmp[0]) {
            answer[0] = 1;
            answer[1] = 3;
        } else if (tmp[0] > tmp[1] && tmp[0] > tmp[2]) {
            answer[0] = 1;
        } else if (tmp[1] > tmp[0] && tmp[1] > tmp[2]) {
            answer[0] = 2;
        } else if (tmp[2] > tmp[0] && tmp[2] > tmp[1]) {
            answer[0] = 3;
        }
        return answer;
    }

    public int[] solution2(int[] answers) {
        // int[] answer = new int[3];
        int ansSize = answers.length;

        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[] hit = new int[3];

        for (int i=0; i<answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) hit[0]++;
            if (answers[i] == p2[i % p2.length]) hit[1]++;
            if (answers[i] == p3[i % p3.length]) hit[2]++;
        }

        // int maxScr = Arrays.stream(hit).max().getAsInt();
        int maxScr = Math.max(hit[0], Math.max(hit[1], hit[2]));
        // 왜 리스트로 구현했지? 음..나는 지금 hit배열에 max점수가 몇개나 있는지 모르겠으니까..
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < hit.length; i++) {
            if (hit[i] == maxScr) list.add(i + 1);
        }
        // int형 배열에 담기 (for문도 써도 된당..)
        int[] answer = new int[list.size()];
        Iterator<Integer> iter = list.listIterator();
        int cnt = 0;
        while (iter.hasNext()) {
            answer[cnt++] = iter.next();
        }

        return answer;
    }
}
