package 이코테.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] result;
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        result = new int[n][m];
        result[0][0] = 1;
        boolean[][] visit = new boolean[n][m];

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    result[nx][ny] = result[tmp[0]][tmp[1]] + 1;
                    visit[nx][ny] = true;
                }
            }
        }

        answer = result[n - 1][m - 1];
        return answer;
    }
    public static void main(String[] args) {
        미로탈출 T = new 미로탈출();
        System.out.println(T.solution(5,6,new int[][]{
                {1,0,1,0,1,0},
                {1,1,1,1,1,1},
                {0,0,0,0,0,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
        }));
    }
}
