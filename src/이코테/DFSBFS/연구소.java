package 이코테.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
    static int answer = Integer.MIN_VALUE;
    static int n, m;
    static int[][] map;
    static int[][] copy;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(int cnt) {
        if (cnt == 3) {
            // 뭔가를 함
            bfs(); // 벽이 3개면 바이러스 퍼뜨리기 시작
            return;
        }
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        dfs(cnt + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 2) { // 바이러스 위치
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if (copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }

            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copy[i][j] == 0) cnt++;
            }
        }
        answer = Math.max(answer, cnt);
//        System.out.println("answer = " + answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }
}
