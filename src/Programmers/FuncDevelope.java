package Programmers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * level 2
 * 기능개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

public class FuncDevelope {
    /*
     * 아쉬운 점: 큐를 사용하는 문제인데 이를 활용하지 못함...
     *
     */
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int idx = 0;
        int len = progresses.length;
        int check = 0;
        int totalCnt = 0;
        while(totalCnt < len) {

            idx %= len;
            // progresses[idx++] = progresses[idx++] + speeds[idx++];
            for(int i = 0; i < len; i++) {
                progresses[i] += speeds[i];
            }

            if (progresses[check] >= 100) {
                int cnt = 1;
                for (int i = check + 1; i < len; i++) {
                    check++;
                    if (progresses[i] >= 100) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                list.add(cnt);
                totalCnt += cnt;
            }
        }
        int[] answer = new int[list.size()];
        int i = 0;
        for(int ans : list)
            answer[i++] = ans;

        return answer;
    }

    /*
    * 1. 큐 써서 고처보기
    * 2. for문안에 while문 써서 맨앞 원소보다 더 큰놈이 나올때까지는 별다른 cnt 없도록하기
     * */

    public int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        for (int i = 0; i < progresses.length; i++) {
            double tmp = (double) (100 - progresses[i]) / speeds[i];
            int date = (int) Math.ceil(tmp);
            while (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }
            q.add(date);
        }
        // 마지막 progresses 하나만 남아있을 경우 ex) p[99] = 1 이고 sp[99] = 1 이어서 가장 오래걸린경우
        answerList.add(q.size());

        int[] answer = new int[answerList.size()];
        Iterator<Integer> iter = answerList.iterator();
        int idx = 0;
        while (iter.hasNext()) {
            answer[idx++] = iter.next();
        }

        return answer;
    }

}
