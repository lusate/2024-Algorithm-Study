package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {
    static int n, m, answer = 0;
    static boolean[] visit;
    static int[][] computer;

    public static void dfs(int x){
        visit[x] = true;

        for(int i=1; i<=n; i++){
            if(!visit[i] && computer[x][i] == 1){
                dfs(i);
                answer++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visit = new boolean[n+1];
        computer = new int[n+1][n+1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            computer[x][y] = computer[y][x] = 1;
        }

        dfs(1); // 시작 지점
        System.out.println(answer);
    }
}


/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 */