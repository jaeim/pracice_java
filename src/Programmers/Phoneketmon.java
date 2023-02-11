package Programmers;

public class Phoneketmon {
    // 1. 처음 시도는 정수형 배열로 시도했다.
    public int solution(int[] nums) {
        int answer = 0;
        int[] kindArr = new int[2000000]; // 비효율적일 것 같다..
        int kind = 0;

        for (int i = 0; i < nums.length; i++) {
            if (kindArr[nums[i]] == 0) {
                kindArr[nums[i]] += 1;
                kind++;
            }
        }

        int phoneketmonSize = nums.length / 2;
        if (phoneketmonSize > kind)
            answer = kind;
        else
            answer = phoneketmonSize;

        return answer;
    }
    // 2. 다른사람들처럼 HashSet 써보기로 했다.
}
