package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스카이라인쉬운거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 현재 높이가 더 높다면 pop 하면서 카운트 - push할 때만 카운트 하려 해서 안 풀렸음
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                answer++;
            }
            // stack에 있는 이전 높이와 현재 높이가 같기 때문에 stack에 넣어줄 필요가 없음
            if(!stack.isEmpty() && stack.peek() == y){
                continue;
            }
            stack.push(y);
        }

        while(!stack.isEmpty()){
            if (stack.peek() > 0) {
                answer++;
            }
            stack.pop();
        }

        System.out.println(answer);
    }
}
