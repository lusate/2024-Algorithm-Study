package 백준;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Info implements Comparable<Info> {
    int st, ed;
    Info(int st, int ed){
        this.st = st;
        this.ed = ed;
    }
    @Override
    public int compareTo(Info o) {
        if(this.st == o.st) return this.ed - o.ed;
        return this.st - o.st;
    }
}
class Com implements Comparable<Com>{
    int idx, ed;
    Com(int idx, int ed){
        this.idx = idx;
        this.ed = ed;
    }
    @Override
    public int compareTo(Com o) {
        return this.ed - o.ed;
    }
}
public class 싸지방에간준하 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Info> arr = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr.add(new Info(s, e));
        }
        Collections.sort(arr);

        PriorityQueue<Com> using = new PriorityQueue<>();
        PriorityQueue<Integer> available = new PriorityQueue<>();

        int[] cnt = new int[100001];
        int top = 0;
        for (Info now : arr) {
            System.out.println("now: " + now.st);
            // while은 now.st일 때 using.peek().ed를 다 비교해야 함. 현재 시간이 크기만 하면 전부 비교
            // 예제에서는 60일 때 using에 들어가 있는 ed가 50 하나이므로 한번만 available에 들어감.
            // 즉 이 말은 현재 시작 시간이 이전에 끝난 시간이 있는 컴터가 있어 그 자리에 들어갈 수 있다는 의미
            while (!using.isEmpty() && using.peek().ed < now.st) { // now는 반복
                available.offer(using.poll().idx);
            }

            if(!available.isEmpty()){ // 현재 사용 가능한 자리도 이제 자리를 채워줘야 함.
                int idx = available.poll();
                using.add(new Com(idx, now.ed));
                cnt[idx]++;
                System.out.println(idx);
            }
            else{ // 아직 끝난 자리가 없어서 컴터가 추가되어야 한다는 의미
                top++;
                using.add(new Com(top, now.ed));
                cnt[top]++;
                System.out.println(now.ed);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(top).append("\n");
        for(int i=1; i<=top; i++) sb.append(cnt[i]).append(" ");
        System.out.println(sb);
    }
}
/*
5
20 50
10 100
30 120
60 110
80 90
 */