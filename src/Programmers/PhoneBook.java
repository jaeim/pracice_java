package Programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * level 2
 * 전화번호 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneBook {
    /*
        흠..허무하다..
        포인트는 이거였다.
        1. 전화번호 문자열 배열을 정렬할 것. ex) {7, 11, 1, 213, 123, 12} => {1, 11, 12, 123, 213, 7}
        2. startsWith를 사용해서 내 바로 다음의 문자열과 일치하지 않으면 바로 for문 탈출!
            왜? {1, 3, 55, 911} 이라는 배열은 이미 정렬되어있고 (1), 내 다음 놈들은 당연히 나와 가장 비슷한 애가 놓여져있기 때문에
            내 옆에가 접두어가 아니라면 다음 놈들은 볼 것도 없다..
     */
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 굳이 Comparator 재정의할 필요도 없음..
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }


        return answer;
    }

}
