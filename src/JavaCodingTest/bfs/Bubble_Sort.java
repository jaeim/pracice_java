package JavaCodingTest.bfs;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 41, 2, 4, 1, 5, 743};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++ ) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
