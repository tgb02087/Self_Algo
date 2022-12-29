# 📘 16928 (뱀과 사다리 게임)

## 소요시간, 메모리

76ms, 11628KB

## 풀이 방법

- 100칸의 배열을 만들어 각 칸으로 이동했을시 이동할수 있는 칸의 index값을 저장해둠.
- 방문처리 배열을 활용하여 주사위 1~6칸의 경우를 모두 따지면서 방문했던 index를 가지치기
- bfs를 활용

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static int[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        map = new int[101];
        for(int i=0; i<101; i++) map[i] = -1;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1] = n2;
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1] = n2;
        }
        System.out.println(bfs());
        br.close();
    }
    static int bfs() {
        boolean[] visit = new boolean[101];
        Queue<int[]> que = new ArrayDeque<>();
        visit[1]=true;
        que.offer(new int[]{1,0});
        while(!que.isEmpty()) {
            int[] na = que.poll();
            for(int d=1; d<=6; d++) {
                int n = na[0] + d;
                if(101<=n || visit[n]) continue;
                if(n == 100) return na[1]+1;
                visit[n] = true;
                if(map[n]==-1) que.offer(new int[]{n,na[1]+1});
                else {
                    visit[map[n]] = true;
                    que.offer(new int[]{map[n],na[1]+1});
                }
            }
        }
        return 0;
    }
}
```
