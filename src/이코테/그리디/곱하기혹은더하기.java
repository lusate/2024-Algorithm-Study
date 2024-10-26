package 이코테.그리디;

public class 곱하기혹은더하기 {
    public Long solution(String s) {
        long result = s.charAt(0) - '0'; // 문자 하나를 숫자로

        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (result <= 1 || num <= 1) {
                result += num;
            } else result *= num;
        }


        return result;
    }

    public static void main(String[] args) {
        곱하기혹은더하기 T = new 곱하기혹은더하기();
        System.out.println(T.solution("02984"));
        System.out.println(T.solution("567"));
    }
}
