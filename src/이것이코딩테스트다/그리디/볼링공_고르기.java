package 이것이코딩테스트다.그리디;

public class 볼링공_고르기 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int[] result = new int[m + 1]; // 각 무게마다 볼링공 개수를 넣은 배열
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            result[x] += 1;
        }

        /**
         * 1) A가 무게가 1인 공을 선택할 때의 경우의 수: 1(무게가 1인 공의 개수) x 4(B가 선택하는 경우의 수) = 4가지 경우
         *
         * 2) A가 무게가 2인 공을 선택할 때의 경우의 수: 2(무게가 2인 공의 개수) x 2(B가 선택하는 경우의 수) = 4가지 경우
         *
         * 3) A가 무게가 3인 공을 선택할 때의 경우의 수: 2(무게가 3인 공의 개수) x 0(B가 선택하는 경우의 수) = 0가지 경우
         */
        for (int i = 1; i <= m; i++) {
            n -= result[i]; // 선택할 수 있는 볼링공 개수 감소
            answer += result[i] * n;
        }

        return answer;
    }
    public static void main(String[] args) {
        볼링공_고르기 T = new 볼링공_고르기();
        System.out.println(T.solution(5, 3, new int[]{1, 3, 2, 3, 2}));
//        System.out.println(T.solution(8, 5, new int[]{1,5,4,3,2,4,5,2}));
    }
}
