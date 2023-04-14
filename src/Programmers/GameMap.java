package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * level 2
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * test
 */

public class GameMap {
    int[] dx = {0,-1,0,1};
    int[] dy = {-1,0,1,0};
    public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;

        int visited[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                visited[i][j] = 0;
        }
        bfs(maps, visited);
        answer = visited[maps.length - 1][maps[0].length - 1];
        if (answer == 0) answer = -1;

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length)
                    continue;

                if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[current[0]][current[1]] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

    }
}
