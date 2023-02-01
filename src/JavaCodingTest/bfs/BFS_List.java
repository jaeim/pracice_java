package JavaCodingTest.bfs;

import java.util.*;

public class BFS_List {
    public static void main(String[] args) {
//        1. bfs 인접리스트로 구현하기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 갯수
        int m = sc.nextInt(); // 간선 갯수
        int v = sc.nextInt(); // 시작 정점

        boolean[] visited = new boolean[n + 1]; // 방문여부 검사 배열

        LinkedList<Integer>[] adjList = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        // 두 정점 사이에는 여러개의 간선이 있을 수 있다..
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        System.out.println("BFS - 인접리스트 사용");
        bfs_list(v, adjList, visited);
    }

    public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);

        while(queue.size() > 0) {
            v = queue.poll();
            System.out.println(v + " ");

            Iterator<Integer> iter = adjList[v].listIterator();
            while(iter.hasNext()) {
                int w = iter.next();
                if(!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }



}
