package 문자열_조작;

import com.sun.tools.javac.Main;

public class 회문문자열2 {
    public boolean isPalindrome(String s) {
        int lt = 0;
        int rt = s.length() - 1;
        while (lt < rt) {
            if (s.charAt(lt) != s.charAt(rt)) {
                return false;
            }
            else{
                lt++;
                rt--;
            }
        }
        return true;
    }
    public String solution(String s) {
        String answer = "YES";
        int lt = 0;
        int rt = s.length() - 1;

        while(lt < rt) {
            if (s.charAt(lt) != s.charAt(rt)) {
                String str1 = s.substring(lt, rt);
                String str2 = s.substring(lt + 1, rt + 1);

                if(!isPalindrome(str1) && !isPalindrome(str2)) return "NO";
                else break;
            }
            else{
                lt++;
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        회문문자열2 T = new 회문문자열2();
        System.out.println(T.solution("abcbdcba"));
        System.out.println(T.solution("abcabbakcba"));
        System.out.println(T.solution("abcacbakcba"));
    }
}
