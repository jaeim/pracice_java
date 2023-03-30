package Programmers;

public class QuickSort {
    public static void sort(int[] a) {
        // 정렬할 배열, 시작점, 끝점(length - 1)
        m_pivot_sort(a, 0, a.length - 1);
    }

    /**
     * 퀵 소트 : https://st-lab.tistory.com/250
     * 중간 피벗 선택 방식
     * @param a		정렬할 배열
     * @param lo	현재 부분배열의 왼쪽
     * @param hi	현재 부분배열의 오른쪽
     */

    private static void m_pivot_sort(int[] a, int lo, int hi) {
        /*
         *  lo가 hi보다 크거나 같다면 정렬 할 원소가
         *  1개 이하이므로 정렬하지 않고 return한다.
         */
        if (lo >= hi) return;
        /*
         * 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로
         * 만들어 준 뒤, 최종적으로 pivot의 위치를 얻는다.
         *
         * 그리고나서 해당 피벗을 기준으로 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어
         * 분할 정복을 해준다.
         *
         * [과정]
         *
         * Partitioning:
         *
         *      left part      a[(right + left)/2]      right part
         * +---------------------------------------------------------+
         * |    element < pivot    |  pivot  |    element >= pivot   |
         * +---------------------------------------------------------+
         *
         *
         *  result After Partitioning:
         *
         *         left part         a[hi]          right part
         * +---------------------------------------------------------+
         * |   element < pivot    |  pivot  |    element >= pivot    |
         * +---------------------------------------------------------+
         *
         *
         *  result : pivot = hi
         *
         *
         *  Recursion:
         *
         * m_pivot_sort(a, lo, pivot)         m_pivot_sort(a, pivot + 1, hi)
         *
         *         left part                           right part
         * +-----------------------+             +-----------------------+
         * |   element <= pivot    |             |    element > pivot    |
         * +-----------------------+             +-----------------------+
         * lo                pivot          pivot + 1                   hi
         *
         */
        int pivot = partition(a, lo, hi);
        m_pivot_sort(a, 0, pivot);
        m_pivot_sort(a, pivot + 1, hi);

    }

    /**
     * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
     *
     * @param a		정렬 할 배열
     * @param left	현재 배열의 가장 왼쪽 부분
     * @param right	현재 배열의 가장 오른쪽 부분
     * @return		최종적으로 위치한 피벗의 위치(hi)를 반환
     */

    private static int partition(int[] a, int left, int right) {
        // lo와 hi는 각각 배열의 끝에서 1 벗어난 위치부터 시작한다.
        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];

        while(true) {
            /*
             * 1 증가시키고 난 뒤의 lo 위치의 요소가 pivot보다 큰 요소를
             * 찾을 떄 까지 반복한다.
             */
            do {
                lo++;
            } while (a[lo] < pivot);
            /*
             * 1 감소시키고 난 뒤의 hi 위치가 lo보다 크거나 같은 위치이면서
             * hi위치의 요소가 pivot보다 작은 요소를 찾을 떄 까지 반복한다.
             */
            do {
                hi--;
            } while (a[hi] > pivot && hi >= lo);

            /*
             * 만약 hi가 lo보다 크지 않다면(엇갈린다면) swap하지 않고 hi를 리턴한다.
             */
            if (hi <= lo) return hi;

            // 교환 될 두 요소를 찾았으면 두 요소를 바꾼다. (swap)
            int tmp = a[lo];
            a[lo] = a[hi];
            a[hi] = tmp;

            /**
             * 중간 선택 방식은 조금은 복잡하다.
             * 일단 중간 위치를 피벗으로 설정하게 되면 필자가 이미지로 첨부한 것에서도 볼 수 있듯이
             * hi가 가리키는 위치가 pivot의 위치보다 높으면서 hi가 가리키는 원소가 pivot보다 작은 경우가 생긴다.
             *
             * 그렇기 때문에 분할정복으로 재귀를 호출하더라도 파티셔닝을 통해 얻은 피벗까지 포함하여 부분리스트로 나누어야 한다.
             *
             * 실제로 이 방식은 큰 장점이 있어 위와 같은 방식의 피벗 선택을 많이 추천하곤 한다. 이 부분은 바로 다음 파트에서 설명하도록 하겠다.
             */
        }
    }

}
