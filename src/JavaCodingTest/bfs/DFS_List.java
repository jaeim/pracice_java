package JavaCodingTest.bfs;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.*;

public class DFS_List {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        boolean[] visited = new boolean[n + 1];

        LinkedList<Integer>[] adjList = new LinkedList[n + 1]; // 간선 정보를 저장할 인접리스트 배열 생성
        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
//        System.out.println("TEST");
        // 간선 정보 저장 (양방향)
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        // 방문순서를 위해 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        System.out.println("DFS - 인접리스트");
        dfs_list_recursion(v, adjList, visited);
    }
    // dfs - 인접리스트 - 재귀
    public static void dfs_list_recursion(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + " ");

        Iterator<Integer> iter = adjList[v].listIterator();
        while (iter.hasNext()) {
            int w = iter.next();
            if (!visited[w]) {
                dfs_list_recursion(w, adjList, visited);
            }
        }
    }
}
