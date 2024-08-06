package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 침투_BFS {
    static int M, N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int j = 0; j < N; j++) {
            if(map[0][j] == 0){
                q.add(new int[]{0, j});
                visit[0][j] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];
                if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                if(map[nx][ny] == 1 || visit[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                visit[nx][ny] = true;

                if (nx == M - 1) {
                    System.out.println("YES");
                    System.exit(0);
                }
            }
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

        // 제일 첫 위치가 bfs
        for(int j=0; j<N; j++){
            if(map[0][j] == 0 && !visit[0][j]){
                bfs();
            }
        }

        System.out.println("NO");
    }
}
