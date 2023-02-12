package Programmers;

import java.util.HashMap;

/**
 * level 1
 * 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class UncompletedRunner {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                map.replace(completion[i], map.get(completion[i]) + 1);
            } else {
                map.put(completion[i], 1);
            }
        }

        for (String name: participant) {
            if (!map.containsKey(name) || map.get(name) <= 0) {
                answer = name;
                break;
            } else {
                map.replace(name, map.get(name) - 1);
            }

        }

        return answer;
    }
}
