package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산 {
    static int n, answer = 0, q = 0;
    static boolean[] visit;
    static int[][] arr;

    public static void dfs(int st, int ed, int L) {
        visit[st] = true;
        if (st == ed) {
            answer = L;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[st][i] == 1 && !visit[i]) {
//                visit[i] = true; // 방문 처리
//                q++; // dfs 호출 횟수 증가
                dfs(i, ed, L + 1);
//                if (answer != 0) return; // 답을 찾으면 더 이상 탐색할 필요 없음
//                visit[i] = false; // 백트래킹
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken()); // 구해야 하는 두 사람의 촌수

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        dfs(s, e, 0);

        System.out.println(answer == 0 ? -1 : answer);
//        System.out.println("q = " + q);
    }
}


/*
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */