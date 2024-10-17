    package 이것이코딩테스트다.DFSBFS;

    import java.util.Stack;

    public class 괄호변환 {
        // 올바른 문자열인지 판단하는 메서드
        public boolean correct(String s) {
            Stack<Character> stack = new Stack<>();
            for(char x : s.toCharArray()){
                if (x == '(') {
                    stack.push(x);
                }
                else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    stack.pop();
                }
            }

            return true;
        }

        public String dfs(String s) {
            if (s.isEmpty()) {
                return "";
            }
            String u = "";
            String v = "";
            int lt = 0;
            int rt = 0;

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '('){
                    lt++;
                } else rt++;

                u += s.charAt(i);

                // u와 v를 분리하기 위함
                if (lt == rt) { // lt와 rt가 같다는 것은 현재 u가 올바른 문자열이라는 것ㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂ
                    v = s.substring(i + 1);
                    break;
                }
            }
            if (correct(u)) { // u가 올바른 괄호 문자열로 v에 대해 1단계부터 다시 수행
                return u + dfs(v); // u에 이어 붙임
            }
            else { // u가 올바른 문자열이 아닌 경우
                String tmp = "("; // 빈 문자열에 첫 번째 문자로 '(' 붙임
                tmp += dfs(v);
                tmp += ")";

                // 첫 번째와 마지막 문자를 제거
                u = u.substring(1, u.length()-1);

                // 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙임
                for (int i = 0; i < u.length(); i++) {
                    if(u.charAt(i) == '('){
                        tmp += ')';
                    } else tmp += '(';
                }
                return tmp;

            }
        }

        public String solution(String p) {
            String answer = dfs(p);

            return answer;
        }

        public static void main(String[] args) {
            괄호변환 T = new 괄호변환();
//            System.out.println(T.solution("(()())()"));
            System.out.println(T.solution(")("));
//            System.out.println(T.solution("()))((()"));
        }
    }
