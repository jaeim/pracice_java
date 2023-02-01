package JavaCodingTest.bfs;

import java.util.Scanner;
import java.util.Stack;

public class DFS_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        boolean[] visited = new boolean[n+1];

        int[][] adjArray = new int[n+1][n+1];
        for(int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjArray[v1][v2] = 1;
            adjArray[v2][v1] = 1;
        }

//        System.out.println("dfs - 인접행렬/재귀");
//        dfs_array_recursion(v, adjArray, visited);
        System.out.println("dfs - 인접행렬/스택");
        dfs_array_stack(v, adjArray, visited, true);
    }
// dfs - 인접행렬 - 재귀
    public static void dfs_array_recursion(int v, int[][] adjArray, boolean[] visited) {
        int n = adjArray.length - 1;
        visited[v] = true;
        System.out.println(v + " ");

        for (int i = 1; i <= n; i++) {
            if (adjArray[v][i] == 1 && !visited[i])
                dfs_array_recursion(i, adjArray, visited);
        }
    }
//    dfs - 인접행렬 - 스택
    public static void dfs_array_stack(int v, int[][] adjArray, boolean[] visited, boolean flag) {
        int n = adjArray.length - 1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(v);
        visited[v] = true;
        System.out.println(v + " ");

        while (!stack.isEmpty()) {
            int w = stack.peek(); // pop과 달리 정점을 제거하지 않고 값만 반환!
            flag = false;

            for (int i = 1; i <= n; i++) {
                if(adjArray[w][i] == 1 && !visited[i]) {
                    stack.push(i);
                    System.out.println(i + " ");
                    visited[i] = true;
                    flag = true;
                    // 자식 노드가 있는 정점을 찾을 때마다 stack에 쌓는 것을 멈추고 for문 밖으로 나간다.
                    break;
                }
            }
            // 정점 w와 연결된 정점이 없거나 이미 방문했을 경우
            if (!flag) {
                stack.pop();
            }
        }
    }
}
