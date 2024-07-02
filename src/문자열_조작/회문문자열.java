package 문자열_조작;

public class 회문문자열 {
    public String solution(String s) {
        String answer = "NO";
        String str = new StringBuilder(s).reverse().toString();
        System.out.println(str);

        if (s.equalsIgnoreCase(str)) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        회문문자열 T = new 회문문자열();
        System.out.println(T.solution("gooG"));
        System.out.println(T.solution("Moon"));
    }
}
