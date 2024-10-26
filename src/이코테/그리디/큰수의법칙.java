package 이코테.그리디;

import java.util.Arrays;

public class 큰수의법칙 {
    public int solution(int n, int m, int k, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int max = arr[n - 1];
        int secondMax = arr[n - 2];

        /**
         * 가장 큰 수가 더해지는 횟수를 계산
         * m / (k+1)로 최대 몇 번의 그룹을 만들 수 있는지를 계산
         * 가장 큰 수를 k번, 2번째 큰 수를 1번 더하는 구조
         */
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1); // 남은 횟수 -> 전체 그룹을 다 사용한 후 남은 횟수 즉 배열에 있는 것을 전부 다 하고 남은 횟수

        answer += max * cnt;
        answer += (m - cnt) * secondMax;

        return answer;
    }
    public static void main(String[] args) {
        큰수의법칙 T = new 큰수의법칙();
        System.out.println(T.solution(5, 8, 3, new int[]{2, 4, 5, 4, 6}));
        System.out.println(T.solution(5, 7, 2, new int[]{3, 4, 3, 4, 3}));
    }
}
