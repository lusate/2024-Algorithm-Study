package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로탈출하기 {
    static int N, M, answer = 0;
    static char[][] map;
    static boolean[][] visit;

    public static boolean dfs(int x, int y){
        boolean flag = false;
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return true;
        }

        if(map[x][y] == 'T') return true;
        else if (map[x][y] == 'F') return false; // 이미 방문한 경우

        if(visit[x][y]) return false;
        visit[x][y] = true; // 현재 위치 방문 표시

        if (map[x][y]=='U') flag = dfs(x-1,y);
        else if (map[x][y]=='R')  flag = dfs(x,y+1);
        else if (map[x][y]=='L')  flag = dfs(x,y-1);
        else if (map[x][y]=='D')  flag = dfs(x+1,y);

        map[x][y] = flag ? 'T' : 'F'; // flag가 true라면 'T', false라면 'F'

        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if(dfs(i, j)) answer++;
            }
        }

        System.out.println(answer);
    }
}
