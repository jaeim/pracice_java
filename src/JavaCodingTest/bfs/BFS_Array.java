package JavaCodingTest.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점 갯수
        int m = sc.nextInt(); // 간선 갯수
        int v = sc.nextInt(); // 시작 정점

        boolean[] visited = new boolean[n + 1];

        int[][] adArray = new int[n+1][n+1];

        // 두 점 사이에 간선
        // 주어지는 간선은 양방향이다.
        for (int i = 0; i < m; i++) {
          int v1 = sc.nextInt();
          int v2 = sc.nextInt();
          adArray[v1][v2] = 1;
          adArray[v2][v1] = 1;
        }

        System.out.println("BFS - 인접행렬");
        bfs_array(v, adArray, visited);

    }

    public static void bfs_array(int v, int[][] adArray, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int n = adArray.length - 1; // 정점은 1부터 시작이라 -1 해줘야 함.
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.println(v + " ");
            for (int i = 1; i <= n; i++) {
                if (adArray[v][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
