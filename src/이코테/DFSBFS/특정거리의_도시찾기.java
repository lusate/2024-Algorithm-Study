package 이코테.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의_도시찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 멎춤 거리
        int x = Integer.parseInt(st.nextToken()); // 출발 도시

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        int[] d = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            d[i] = -1; // 방문하지 않은 도시에 대한 처리 이렇게 하고 싶지 않다면 visit 배열을 추가
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        d[x] = 0; // 출발 도시
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 0; i < graph[now].size(); i++) {
                int nx = graph[now].get(i);
                if(d[nx] == -1){ // 방문 X
                    d[nx] = d[now] + 1;
                    q.add(nx);
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }
        if(!flag) System.out.println(-1);
    }
}
