package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 입국심사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = Long.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        long s = 0, e = 0;
        // 심사하는 데 걸리는 시간 T
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, arr[i]);
        }
        Arrays.sort(arr);

        e = e * M;
        while (s <= e) { // 학생 수가 10억, 계산대가 가질 수 있는 값 범위가 10억이므로 Long 사용
            long mid = (s + e) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                long count = mid / arr[i];

                if (sum >= M) {
                    break;
                }
                sum += count;
            }

            if(sum >= M){
                e = mid - 1;
                answer = Math.min(mid, answer);
            }
            else{
                s = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
