package Programmers;

import java.util.*;
/**
 * level 2
 * 최솟값 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
class 최솟값만들기
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        ArrayList<Integer> list_a = new ArrayList<>();
        ArrayList<Integer> list_b = new ArrayList<>();

        for (int a: A) {
            list_a.add(a);
        }

        for (int b: B) {
            list_b.add(b);
        }
//         최소 * 최대
        Collections.sort(list_a);
        Collections.sort(list_b, Collections.reverseOrder());

//         후보 리스트
        LinkedList<Integer> compList = new LinkedList<>();
        int sum1 = 0;

        for (int i = 0; i < list_a.size(); i++) {
            sum1 += list_a.get(i) * list_b.get(i);
        }

        answer = sum1;

        return answer;
    }
}
