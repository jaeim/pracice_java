package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Cititations {
    public int solution(int[] citations) {

        // 처음 푼 방법
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i <= citations.length; i++) {
            int cnt = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i)
                    cnt++;
            }
            if (cnt >= i)
                list.add(i);
        }
        if (list.size() > 0)
            answer = Collections.max(list);

        return answer;

        /* 다른 사람 풀이 참고한 방법
            나는 왜 for문을 2개나 써서 o(n^2)이 되게 만들었을까 ..
            사실 아주 간단하게 풀 수 있는 문제다.
            H가 될 수 있는 것은 최소 0에서 최대 citations.length 까지이다.
            그러므로 애초에 citations를 오름차순으로 정렬한 후,
            citations.length와 하나씩 비교해나가면 된다.
            즉, [3, 0, 6, 1, 5] 일때
             cita[i]  cita.len
            +--------+--------+
            |   0    |    5   | => h가 5라면 5번이상 인용된 논문이 5개 이상 있어야 하는데 시작부터 0이니 false!
            +--------+--------+
            |   1    |    4   | => h가 4라면 4번이상 인용된 논문이 4개 이상 있어야 하는데 시작부터 1이니 false!
            +--------+--------+
            |   3    |    3   | => h가 3이라면 3번이상 인용된 논문이 3개 이상 있어야 하는데 마침 3이니 true! (오름차순으로 정렬되어 있으니 cita[2]뒤의 애들도 당연히 3이상이지.)
            +--------+--------+
            |   5    |    2   |
            +--------+--------+
            |   6    |    1   |
            +--------+--------+

        public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                answer = citations.length - i;
                break;
            }
        }
        return answer;
        */

    }
}
