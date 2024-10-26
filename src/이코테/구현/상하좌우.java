package 이코테.구현;

import java.util.Arrays;

public class 상하좌우 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int[] solution(int n, String[] arr) {
        int[] answer = new int[2];

        char[] moveTypes = {'U', 'R', 'D', 'L' };
        int x = 1, y = 1;
        for (String s : arr) {
            char ch = s.charAt(0);

            int nx = 0, ny = 0;
            for (int k = 0; k < 4; k++) {
                if (ch == moveTypes[k]) {
                    nx = x + dx[k];
                    ny = y + dy[k];
                }
            }

            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            x = nx;
            y = ny;
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args) {
        상하좌우 T = new 상하좌우();
        System.out.println(Arrays.toString(T.solution(5, new String[]{"R", "R", "R", "U", "D", "D" })));
    }
}
