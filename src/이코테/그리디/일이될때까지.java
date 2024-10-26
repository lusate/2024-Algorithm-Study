package 이코테.그리디;

public class 일이될때까지 {
    public int solution(int n, int k) {
        int answer = 0;
        while (true) {
            int cnt = (n / k) * k; // n에서 k로 나눌 수 있는 최댓값
            answer += (n - cnt); // 나머지를 answer에 추가 -> 1을 빼야 하기 때문에

            n = cnt;
            if(n<k) break;

            answer += 1; // 나눌 때 1을 더해줌
            n /= k;
        }
        // while문 돌리고 나면 최족 n은 1이 됨.

        answer += (n - 1); // 마지막 1을 빼줌
        return answer;
    }
    public static void main(String[] args) {
        일이될때까지 T = new 일이될때까지();
        System.out.println(T.solution(17, 4));
        System.out.println(T.solution(25, 5));
    }
}
