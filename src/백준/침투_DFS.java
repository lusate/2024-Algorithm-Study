package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 침투_DFS {
    static int M, N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        if (x == M - 1) {
            System.out.println("YES");
            System.exit(0);
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if(visit[nx][ny] || map[nx][ny] == 1) continue;

            dfs(nx, ny);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int j = 0; j < N; j++) {
            if (map[0][j] == 0 && !visit[0][j]) {
                dfs(0, j);
            }
        }
        System.out.println("NO");

    }
}
