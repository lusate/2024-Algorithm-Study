package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE {
    static int N, M;
    static boolean[] visit;
    static ArrayList<Integer>[] graph;

    public static void dfs(int L, int v) {
        if (L == 4) { // 관계가 4개. 즉 깊이가 4
            System.out.println(1);
            System.exit(0); // 친구 관계 4개가 되는지 찾아도 for문으로 dfs를 돌리기 때문에 끊어준다.
        }

        visit[v] = true; // 처음 시작 지점 방문 처리
        for (int x : graph[v]) {
            if (!visit[x]) {
                visit[x] = true;
                dfs(L + 1, x);
                visit[x] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
//        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N]; // 시작하는 정점들도 모두 방문 처리가 되어야 함.
            dfs(0, i);
        }
        System.out.println(0);
    }
}
