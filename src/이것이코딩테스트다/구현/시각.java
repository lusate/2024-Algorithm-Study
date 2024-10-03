package 이것이코딩테스트다.구현;

public class 시각 {
    public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) {
            return true;
        }
        return false;
    }
    public int solution(int h) {
        int answer = 0;
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                    if(check(i,j,k)) answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        시각 T = new 시각();
        System.out.println(T.solution(23));
    }
}
