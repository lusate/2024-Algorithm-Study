package 이코테.이분탐색;

import 이코테.그래프.정확한_순위;

public class 정렬된_배열에서_특정_수의_개수구하기 {
    // arr에서 target 값이 처음 나타나는 위치
    public int lowerBound(int[] arr, int target, int lt, int rt) {
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] >= target) rt = mid;
            else lt = mid + 1;
        }
//        System.out.println("lt = " + lt + ", rt = " + rt);
        return rt;
    }
    // arr에서 target 값이 초과되는 위치
    public int upperBound(int[] arr, int target, int lt, int rt) {
        while(lt < rt){
            int mid = (lt + rt) / 2;
            if(arr[mid] > target) rt = mid;
            else lt = mid + 1;
        }
//        System.out.println("lt = " + lt + ", rt = " + rt);
        return rt;
    }

    // target인 인덱스 위치를 찾았으니 두 위치를 빼면 target과 같은 수가 몇개가 있는지 알 수 있음
    public int countByRange(int[] arr, int leftValue, int rightValue) {
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);

        return rightIndex - leftIndex;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int count = countByRange(arr, m, m);
        if(count == 0) answer = -1;
        else answer = count;

        return answer;
    }
    public static void main(String[] args) {
        정렬된_배열에서_특정_수의_개수구하기 T = new 정렬된_배열에서_특정_수의_개수구하기();
        System.out.println(T.solution(7, 2, new int[]{1, 1, 2, 2, 2, 2, 3}));
//        System.out.println(T.solution(7, 4, new int[]{1, 1, 2, 2, 2, 2, 3}));
    }
}

/*
# 입력예시 1
7 2
1 1 2 2 2 2 3
# 출력예시 1
4

# 입력예시 2
7 4
1 1 2 2 2 2 3
# 출력예시 2
-1
 */