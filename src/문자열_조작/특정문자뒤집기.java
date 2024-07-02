package 문자열_조작;

public class 특정문자뒤집기 {
    public String solution(String s) {
        String answer = "";
        char[] chars = s.toCharArray();
        int lt = 0;
        int rt = s.length() - 1;

        while (lt < rt) {
            if(!Character.isAlphabetic(chars[lt])){
                lt++;
            }
            else if(!Character.isAlphabetic(chars[rt])){
                rt--;
            }
            else{
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(chars);
        return answer;
    }

    public static void main(String[] args) {
        특정문자뒤집기 T = new 특정문자뒤집기();
        System.out.println(T.solution("a#b!GE*T@S"));
        System.out.println(T.solution("###ab*@@Sty"));
    }
}
