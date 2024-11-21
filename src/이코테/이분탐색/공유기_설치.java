package 이코테.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기_설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken()); // 집 개수
        int C = Integer.parseInt(st.nextToken()); // 굥유기 개수

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 1 2 4 8 9

        int lt = 1, rt = arr[N - 1] - arr[0]; // 8
        while (lt <= rt) {
            int cnt = 1; // 공유기 개수 -> 처음 자리는 무조건 공유기 1개를 놓아야 하기 때문에
            int mid = (lt + rt) / 2;

            // 첫번째 공유기 설치부터 시작, 현재 집을 옮김
            int start = arr[0];
            for (int i = 1; i < N; i++) {
                // 1, 2, 4로 설치하면 현재 최개 인접한 공유기와의 거리가 mid = 4로
                // "현재 집에서 마지막으로 설치한 공유기 위치에서 mid 이상 떨어져 있는 가?"를 확인합니다
                if (arr[i] - start >= mid) {
                    start = arr[i];
                    cnt++;
                }
            }

            // C개 이상의 공유기를 설치할 수 있다면, 거리 증가
            if (cnt >= C) {
                lt = mid + 1;
                answer = mid;
            }
            // C개 이상의 공유기를 설치할 수 있는 경우, 거리 감소
            else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
