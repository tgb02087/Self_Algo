# 📘 2178 (미로 탐색)

## 소요시간, 메모리

88ms, 12076KB

## 풀이 방법

- (0,0) 에서 (N,M) 으로 이동해야하므로 4방 탐색시 우,하를 먼저 탐색함.
- 최소한의 길이를 찾아야 하므로, 최소한이 보장되는 bfs 활용

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static int[] di = {0,1,0,-1};
    static int[] dj = {1,0,-1,0};
    static int N, M;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++) map[i] = br.readLine().toCharArray();
        bfs(0,0);
        br.close();
    }
    static void bfs(int x, int y) {
        boolean[][] visit = new boolean[N][M];
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{x,y,1});
        visit[x][y] = true;
        while(!que.isEmpty()) {
            int[] xy = que.poll();
            for(int d=0; d<4; d++) {
                int nx = xy[0]+di[d];
                int ny = xy[1]+dj[d];
                if(nx<0 || N<=nx || ny<0 || M<=ny || visit[nx][ny] || map[nx][ny]=='0') continue;
                if(nx==N-1 && ny==M-1) {
                    System.out.println(++xy[2]);
                    return;
                }
                visit[nx][ny] = true;
                que.offer(new int[]{nx,ny,xy[2]+1});
            }
        }
    }
}
```
