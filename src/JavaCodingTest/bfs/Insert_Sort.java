package JavaCodingTest.bfs;

import java.util.*;

public class Insert_Sort {
    public static void main(String[] args) {
        // 삽입정렬을 배열로 구현하는 경우 삽입 후 요소의 위치이동에 따른 연산이 복잡하기 때문에 리스트로 구현하는게 훨씬 간단하고 효율도 좋다.
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3, 6, 41, 2, 4, 1, 5, 743));
        int[] arr = new int[]{3, 6, 41, 2, 4, 1, 5, 743};
        list = (LinkedList<Integer>) insertSort(list);
        Iterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }


    }
    public static List<Integer> insertSort(List<Integer> input) {
        LinkedList<Integer> list = new LinkedList<>(input);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) {
                    Integer tmp = list.remove(j);
                    list.add(i, tmp);
                }
            }
        }
        return list;
    }

    // 배열과 while문을 이용하는 경우
    public static void insertSortWhile(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int location = i;
            while (location > 0 && arr[location] < arr[location-1]) {
                int tmp = arr[location - 1];
                arr[location - 1] = arr[location];
                arr[location] = tmp;
                location--;
            }
            arr[location] = arr[i];
        }
    }

}
