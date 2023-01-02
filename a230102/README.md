# 📘 1697 (숨바꼭질)

## 소요시간, 메모리

124ms, 14740KB

## 풀이 방법

- 시작위치와 도착위치가 같은 경우에 0초로 출력하는 조건을 고려하지 않아 틀림.
- BFS를 활용하여 해당 위치에서 +1, -1, \*2 하는 경우를 탐색
- visit 배열로 방문처리하여 중복을 제거 함

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(game(N,K));
        br.close();
    }
    static int game(int N, int K) {
        if(N==K) return 0;
        Queue<int[]> que = new ArrayDeque<>();
        boolean[] visit = new boolean[100001];
        visit[N] = true;
        que.offer(new int[]{N,0});
        while(!que.isEmpty()) {
            int[] n = que.poll();
            for(int i=0; i<3; i++) {
                int nn = set(i,n[0]);
                if(nn==K) return n[1]+1;
                if(0<=nn && nn<=100000 && !visit[nn]) {
                    visit[nn] = true;
                    que.offer(new int[]{nn,n[1]+1});
                }
            }
        }
        return 0;
    }
    static int set(int i,int n) {
        if(i==0) return n+1;
        else if(i==1) return n-1;
        else return n*2;
    }
}
```
