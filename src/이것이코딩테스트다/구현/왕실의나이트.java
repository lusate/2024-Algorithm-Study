package 이것이코딩테스트다.구현;

public class 왕실의나이트 {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    public int solution(String s) {
        int answer = 0;
        int row = s.charAt(1) - '0';
        int column = s.charAt(0) - 96;
        System.out.println("column = " + column);

        for (int i = 0; i < 8; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            if (nx >= 1 && nx < 8 && ny >= 1 && ny < 8) {
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        왕실의나이트 T = new 왕실의나이트();
        System.out.println(T.solution("a1"));
    }
}
