package JavaCodingTest.bfs;

import java.util.LinkedList;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};

        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                // i + 1을 하는 이유는 자기 자신(i)과 비교할 필요는 없기 때문
                if(arr[min_idx] > arr[j]) { // 이 부분을 바꾸면 오름/내림차순 조정가능
                    min_idx = j;
                }
            }
            // i번째 값과 최솟값을 교환
            swap(arr, i, min_idx);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
