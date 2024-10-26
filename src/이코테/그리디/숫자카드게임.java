package 이코테.그리디;

public class 숫자카드게임 {
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, arr[i][j]);
            }

            answer = Math.max(answer, min);
        }

        return answer;
    }

    public static void main(String[] args) {
        숫자카드게임 T = new 숫자카드게임();
        System.out.println(T.solution(3, 3, new int[][]{{3, 1, 2}, {4, 1, 4}, {2, 2, 2}}));
        System.out.println(T.solution(2, 4, new int[][]{{7, 3, 1, 8}, {3, 3, 3, 4}}));
    }
}
