package Programmers;

import java.util.Arrays;

public class NumberOfK {
    // 1. Arrays.copyOfRange() 안쓰고 구현한 경우
    public int[] solution(int[] array, int[][] commands) {
        // int[] answer = {};
        int[] answer = new int[commands.length];

        for (int x = 0; x < commands.length; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            int size = j - i + 1;
            int[] nArr = new int[size];
            int idx = 0;
            for (int y = i - 1; y <= j - 1; y++) {
                nArr[idx++] = array[y];
            }
            Arrays.sort(nArr);
            answer[x] = nArr[k - 1];

        }

        return answer;
    }
    //2. Arrays.copyOfRange() 사용 && 퀵소트 직접구현
    public int[] solution2(int[] array, int[][] commands) {
        // int[] answer = {};
        int[] answer = new int[commands.length];

        for (int x = 0; x < commands.length; x++) {
            int[] nArr = Arrays.copyOfRange(array, commands[x][0] - 1, commands[x][1]);
            quick_sort(nArr, 0, nArr.length - 1);
            answer[x] = nArr[commands[x][2] - 1];

        }

        return answer;
    }

    public void quick_sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = partition(a, lo, hi);

        quick_sort(a, lo, pivot);
        quick_sort(a, pivot + 1, hi);
    }

    public int partition(int[] a, int left, int right) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];

        while(true) {
            do {
                lo++;
            } while (a[lo] < pivot);

            do {
                hi--;
            } while (a[hi] > pivot && hi >= lo);

            if (hi <= lo)
                return hi;

            int tmp = a[lo];
            a[lo] = a[hi];
            a[hi] = tmp;

        }

    }
}
