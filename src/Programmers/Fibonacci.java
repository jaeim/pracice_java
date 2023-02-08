package Programmers;

public class Fibonacci {
    /*
        실수 1. 재귀로 풀려했던 것
               => n이 50 이상일 경우 런타임 에러가 난다.
               => 이럴 경우 Dynamic Programming 방법을 선택해야! (for문으로 하나하나..)
        실수 2. 오버플로우 체크
               => n이 매우 큰 경우 n번째 피보나치 수는 언어가 표현할 수 있는 자료형의 범위를 넘어가, 오버플로우가 난다.
               => 모든 단계에서 % 연산을 사용하여, 모든 연산에서 오버플로우가 일어나지 않게 만들어 주세요.
               => 나머지 연산은 다음과 같은 특징을 갖고 있습니다
               => (a + b) % m = ((a % m) + (b % m)) % m
     */

    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) arr[i] = 0;
            if (i == 1) arr[i] = 1;
            if (i >= 2) {
                arr[i] = (int) (arr[i - 1] % 1234567) + (int) (arr[i - 2] % 1234567);
            }
        }
        answer = arr[n] % 1234567;
        return answer;
    }

}
