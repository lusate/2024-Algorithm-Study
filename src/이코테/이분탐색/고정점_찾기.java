package 이코테.이분탐색;

public class 고정점_찾기 {
    public int solution(int n, int[] arr) {
        int answer = -1;

        // 수열의 원소 중에서 그 값이 인덱스와 동일한 장소면 고정점 (최대 1개만 존재)
        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2; // 인덱스
            if(mid < arr[mid]) {
                rt = mid - 1;
            }
            else if(mid > arr[mid]) {
                lt = mid + 1;
            } else {
                answer = mid;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        고정점_찾기 T = new 고정점_찾기();
        System.out.println(T.solution(7, new int[]{-15, -6, 1, 3, 7}));
    }
}

/*
5 3
1
2
8
4
9
 */