package 백준.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프점프 {
    static int N, S, answer = 0;
    static int[] jump;
    static boolean[] visit;

    public static void dfs(int start) {
        if(start < 1 || start > N || visit[start]) return;

        visit[start] = true;
        answer++;

        // 같은 징검다리를 반복해서 방문할 수 있기 때문에 if(!visit[start])를 하면 안됨.
        dfs(start + jump[start]);
        dfs(start - jump[start]);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        jump = new int[N+1];
        visit = new boolean[N+1];
        for (int i = 1; i <= N; i++) jump[i] = Integer.parseInt(st.nextToken());

        S = Integer.parseInt(br.readLine());

        dfs(S);
        System.out.println(answer);
    }
}
