package 이코테.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int idx;
    int cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    // 비용이 낮은 것이 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node o) {
        if (this.cost < o.cost) {
            return -1;
        }
        return 1;
    }
}
public class 다익스트라 {
    public static final int INF = (int) 1e9;
    public static int n,m, start; // 노드 개수, 간선 개수, 시작 노드 번호
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.idx;
            int nowCost = tmp.cost;

            if(d[now] < nowCost) continue; // 현재 노드가 이미 처리된 적이 있는 노드라면 무시

            // 현재 연결된 노드와 다른 인접한 노드들을 확인
            for (Node ob : graph.get(now)) {
                if (d[ob.idx] > nowCost + ob.cost) {
                    d[ob.idx] = nowCost + ob.cost;
                    pq.offer(new Node(ob.idx, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        // 그래프 초기
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                // 각 노드에 대한 최단 거리를 담음
                System.out.println(d[i]);
            }
        }
    }
}


/*
# 입력 예시
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

# 출력 예시
0
2
3
1
2
4
 */