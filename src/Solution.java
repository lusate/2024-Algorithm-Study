import com.sun.tools.javac.Main;

import java.util.*;
public class Solution {
    int[] dis={-1, 1, 5};
    int[] ch;
    public int solution(int s, int e){
        Queue<Integer> Q = new LinkedList<>();
        ch = new int[10001];
        Q.offer(s);
        ch[s] = 1;
        int L=0;
        while(!Q.isEmpty()){
            int len = Q.size(); //처음에 L(레벨) 은 1이다. -> 원소 1개.
            for(int i=0; i<len; i++){
                int x = Q.poll(); //각 레벨의 원소
                for(int j=0; j<3; j++){ // 가는 게 1, -1, 5로 3개이기 때문
                    int nx = x + dis[j]; //nx : x의 자식노드
                    if(nx == e) return L+1; // 송아지를 찾을 때
                    //+1 을 해주는 이유는 nx로 이동하고 난 상태이므로 레벨이 1부터 시작이기 때문이다.

                    //처음에 x는 5, dis[j]는 -1, 1, 5
                    if(nx>=1 && nx <= 10000 && ch[nx] == 0){ //ch[nx] == 0 은 방문하지 않았다는 의미
                        //nx가 음수로 갈 수도 있으므로 범위 정해줌. 1~10000으로 범위를 벗어나면 안된다.
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(5, 14));
    }
}





//3