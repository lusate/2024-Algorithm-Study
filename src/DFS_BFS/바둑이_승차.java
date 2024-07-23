package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바둑이_승차 {
    static int n, c = 0, answer = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] visit;
    public static void dfs(int st, int sum) {
        if (sum > c) return;
        answer = Math.max(answer, sum);

        if (st == n) return;

        // Include the current item in the sum
        if (!visit[st]) {
            visit[st] = true;
            dfs(st + 1, sum + arr[st]);
            visit[st] = false;
        }

        // 부분집합에서 제외.
        dfs(st + 1, sum);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

        System.out.println(answer);
    }
}


/*
259 5
81
58
42
33
61
 */