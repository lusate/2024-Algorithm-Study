package 문자열_조작;

public class 문자열압축 {
    public String solution(String s) {
        String answer = "";
        int cnt = 1;
        s = s + ' ';

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            }
            else{
                answer += s.charAt(i);

                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        문자열압축 T = new 문자열압축();
        System.out.println(T.solution("KKHSSSSSSSE"));
        System.out.println(T.solution("AAABCCCDD"));
    }
}
