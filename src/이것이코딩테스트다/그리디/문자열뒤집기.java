package 이것이코딩테스트다.그리디;

public class 문자열뒤집기 {
    public int solution(String s) {
        int count0 = 0;
        int count1 = 0; // '1'으로 그룹을 만들기 위해 필요한 뒤집기 횟수.

        // 문자열의 첫 번째 문자가 어떤 그룹에 속하는지를 파악하기 위함
        if (s.charAt(0) == '1') { // 1이면 0으로 뒤집기
            count0++;
        } else count1++;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if(s.charAt(i + 1) == '1') count0++;
                else count1++;
            }
        }

        return Math.min(count0, count1);
    }

    public static void main(String[] args) {
        문자열뒤집기 T = new 문자열뒤집기();
        System.out.println(T.solution("0001100"));
//        System.out.println(T.solution("11111"));
//        System.out.println(T.solution("00000001"));
//        System.out.println(T.solution("11001100110011000001"));
//        System.out.println(T.solution("11101101"));
    }
}

/*
1
0
1
4
2
 */