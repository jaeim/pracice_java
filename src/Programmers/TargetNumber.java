package Programmers;
/**
 * level 2
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargetNumber {
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(numbers, target, 0, 0);

        return cnt;
    }

    public void dfs(int[] numbers, int target, int i, int sum) {
        if (i == numbers.length) {
            if (sum == target) {
                cnt++;
            }
            return;
        }

        dfs(numbers, target, i + 1, sum + numbers[i]);
        dfs(numbers, target, i + 1, sum - numbers[i]);
    }
}
