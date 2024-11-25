package 이코테.이분탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 접두사, 접미사에 붙은 와일드카드(?)를 처리하기 위한 이중 ArrayList가 필요
 * 이중 ArrayList를 사용하는 이유는 단어들을 길이에 따라 그룹화하기 위한
 * ?에 따라 단어를 찾는 로직이 달라지므로 구분이 필요합니다.
 *
 */
public class 가사검색 {
    // 모든 단어들ㅇ르 길이마다 나누어서 저장하기 위한 리스트
    public ArrayList<ArrayList<String>> arr = new ArrayList<>();
    // 뒤집어 저장하기 위한 리스트 -> 접두사에 와이드카드(?)가 붙은 쿼리를 처리하기 위함
    public ArrayList<ArrayList<String>> reverseArr = new ArrayList<>();

    // 특정값 이상인 첫 번째 인덱스를 구함
    // 사전식 정렬에서 특정 값 이상인 것
    public int lowerBound(ArrayList<String> arr, String target, int lt, int rt) {
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr.get(mid).compareTo(target) >= 0) {
                rt = mid;
            } else lt = mid + 1;
        }

        return rt;
    }

    public int upperBound(ArrayList<String> arr, String target, int lt, int rt) {
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr.get(mid).compareTo(target) > 0) {
                rt = mid;
            } else lt = mid + 1;
        }
        return rt;
    }

    public int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
        int leftIndex = lowerBound(arr, leftValue, 0, arr.size());
        int rightIndex = upperBound(arr, rightValue, 0, arr.size());
        return rightIndex - leftIndex;
    }

    public int[] solution(String[] words, String[] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            arr.get(word.length()).add(word); // 단어 길이별로 단어 넣기 -> 그룹화

            word = (new StringBuffer(word)).reverse().toString();
            reverseArr.get(word.length()).add(word);
        }

        for (int i = 0; i < 10001; i++) {
            Collections.sort(arr.get(i));
            Collections.sort(reverseArr.get(i));
        }

        // queries를 하나씩 확인하며 처리
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int res = 0;
            if (q.charAt(0) != '?') { // 접두사가 ?인지를 확인
                // 접두사가 ? 가 아니면 ?가 있는 부분의 범위를 구하는데
                // 최소, 최대인 a,z를 사용하여 특정 조건을 충족하는 경우의 수를 세기 위함
                res = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            }
            else{
                q = (new StringBuffer(q)).reverse().toString();
                res = countByRange(reverseArr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            }

            ans.add(res);
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        가사검색 T = new 가사검색();
        System.out.println(Arrays.toString(T.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
    }
}
