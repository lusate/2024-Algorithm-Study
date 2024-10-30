package 이코테.이분탐색;

/**
 * 이분 탐색 문제라는 것을 일 수 있는 이유
 * 최적화 문제로 가능한 높이 H 중에서 최대값을 찾고자 함
 * Parametric Search : 최적화 문제를 결정 문제로 바꾸어 해결하는 기법
 * 예를 들어 범위 내에서 조건을 만족하는 가장 큰 값을 찾으라는 최적화 문제라면 이진탐색
 * "현재 이 높이로 자르면 조건을 만족할 수 있는지" 를 확인한 뒤에 조건의 만족 여에 따라서 탐색 범위를 좁혀나감
 * 절단기의 높이는 1부터 10억까지의 정수 중 하나로 이처럼 큰 수를 보면 당연하다는 듯이 이진 탐색을 떠올려야 한다
 * 만약 절단기의 높이 범위가 한정적이라면 순차 탐색으로
 */
public class 떡볶이_떡_만들기 {
    public int solution(int n, int m, int[] h) {
        int answer = 0; // 외적의 절단기 높이
        int lt = 0, rt = (int) 1e9; // 절단기 높이의 최댓값

        while (lt <= rt) {
            int mid = (lt + rt) / 2; // 현재 절단기 높이
            long total = 0; // 현재 절단기 높이로 자른 떡의 총 길이를 저장
            for (int i = 0; i < n; i++) {
                // 각 떡 길이에서 절단기 높이로 자랐을 때 결과
                // 절단기 높이보다 높아야 자를 수 있기 때문에 mid보다 커야 함.
                if(h[i] > mid) total += h[i] - mid;
            }

            // target인 total이 작을 경우부터 생각
            if(m > total) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid + 1;
            }
//            if (m <= total) {
//                answer = mid;
//                lt = mid + 1;
//            } else rt = mid - 1;
        }


        return answer;
    }
    public static void main(String[] args) {
        떡볶이_떡_만들기 T = new 떡볶이_떡_만들기();
        System.out.println(T.solution(4, 6, new int[]{19, 15, 10, 17}));
    }
}