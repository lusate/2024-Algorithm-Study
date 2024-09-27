package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 탑보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new int[]{0, 0});
        }

        stack.add(new int[]{1, arr[1]});
        for (int i = 2; i <= N; i++) { // 현재 건물 위치
            int[] cur = list.get(i);

            while(!stack.isEmpty()) {
                int[] tmp = stack.peek(); // 현재 추가한 데이터

                if (tmp[1] <= arr[i]) {
                    stack.pop();
                }
                else break;
            }

            if (!stack.isEmpty()) {
                int[] tmp = stack.peek();
                cur[1] = tmp[0];
            }

            cur[0] += stack.size();
            stack.push(new int[]{i, arr[i]}); // 현재 인덱스와 높이를 추가
        }
        stack.clear();

        stack.push(new int[]{N, arr[N]});
        for (int i = N - 1; i >= 1; i--) {
            int[] cur = list.get(i);

            while(!stack.isEmpty()) {
                int[] tmp = stack.peek();
                if (tmp[1] <= arr[i]) {
                    stack.pop();
                }
                else break;
            }

            if (!stack.isEmpty()) {
                int[] tmp = stack.peek();
                if (cur[0] == 0) { // 현재 건물보다 높은 건물이 없었던 경우
                    cur[1] = tmp[0]; // 가장 가까운 높은 건물의 인덱스를 tmp[0]으로 설정
                }
                else{ // 현재 건물보다 높은 건물이 이미 있었던 경우 가장 가까운 높은 건물의 인덱스가 cur[1]로 저장되어 있음

                    // 두 건물 간의 거리를 비교
                    int prevdis = Math.abs(i - cur[1]); // 현재 건물 i와 이전에 저장된 가장 가까운 높은 건물 간의 거리
                    int nowdis = Math.abs(i - tmp[0]); // 현재 건물 i와 스택의 최상단 건물(높은 건물) 간의 거리입니다.

                    if(nowdis < prevdis){
                        cur[1] = tmp[0]; // 현재 건물과 새로운 높은 건물 간의 거리가 더 짧으면 cur[1]에 새로운 높은 건물의 인덱스 tmp[0]를 저장
                    }
                }
            }

            cur[0] += stack.size();
            stack.add(new int[]{i, arr[i]});
        }

        for (int i = 1; i <= N; i++) {
            int[] answer = list.get(i);
//            System.out.println(Arrays.toString(list.get(i)));
            if (answer[0] == 0) {
                System.out.println(0);
            }
            else System.out.println(answer[0] + " " + answer[1]);
        }
    }
}

/*
8
3 7 1 6 3 5 1 7
 */