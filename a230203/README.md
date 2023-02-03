# 📘 1799 (비숍)

## 소요시간, 메모리

200ms, 13568KB

## 풀이 방법

- 시간초과가 자꾸 발생하여 구글링을 참고하여 방법을 찾음.
  - 전체 맵을 체크판처럼 생각하면 검은색과 흰색칸의 서로 다른 비숍들은 영향을 끼치지 않음.
  - 전체 맵을 검은 칸과 흰색칸으로 나눠 따로 백트래킹을 진행.
- 비숍을 놓을 수 있는 1칸에는 비숍을 놓거나, 놓지않거나 2가지 경우를 각각 재귀로 판별해봄.
- check메소드를 사용하여 비숍을 놓을 수 있는지 판별.
  - 좌상, 우상으로만 탐색하여 비숍이 있는지 확인.

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    static int[] di = {-1,-1};   //좌상, 우상
    static int[] dj = {-1,1};
    static int N, max = 0;
    static boolean[][] v;
    static int[][] map;
    static int sum = 0;
    static boolean chk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N%2==0) chk = true;
        else chk = false;
        map = new int[N][N];
        v = new boolean[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) sum++;
            }
        }
        int y = 0;
        e:for(int i=0; i<N; i++) {
            for(int j=y; ; j+=2) {
                if(N<=j) {
                    if(chk) {
                        if(j==N) y=1;
                        else y=0;
                    }
                    else {
                        if(j==N) y=0;
                        else y=1;
                    }
                    break;
                }
                if(map[i][j]==1) {
                    v[i][j] = true;
                    start(i,j,0);
                    v[i][j] = false;
                    start(i,j,0);
                    break e;
                }
            }
        }
        int max2 = max;
        max = 0;
        y = 1;
        e:for(int i=0; i<N; i++) {
            for(int j=y; ; j+=2) {
                if(N<=j) {
                    if(chk) {
                        if(j==N) y=1;
                        else y=0;
                    }
                    else {
                        if(j==N) y=0;
                        else y=1;
                    }
                    break;
                }
                if(map[i][j]==1) {
                    v[i][j] = true;
                    start(i,j,0);
                    v[i][j] = false;
                    start(i,j,0);
                    break e;
                }
            }
        }
        System.out.println(max+max2);
        br.close();
    }
    static void start(int x, int y, int cnt) {
        for(int i=x; i<N; i++) {
            for(int j=y; ; j+=2) {
                if(N<=j) {
                    if(chk) {
                        if(j==N) y=1;
                        else y=0;
                    }
                    else {
                        if(j==N) y=0;
                        else y=1;
                    }
                    break;
                }
                if(map[i][j]==1 && !v[i][j]) {
                    if(check(i,j)) {
                        v[i][j] = true;
                        start(i,j,cnt+1);
                        v[i][j] = false;
                    }
                }
            }
        }
        max = Math.max(max,cnt);
    }
    static boolean check(int x, int y) {
        for(int d=0; d<2; d++) {
            int nx = x;
            int ny = y;
            while(true) {
                nx += di[d];
                ny += dj[d];
                if(nx<0 || N<=nx || ny<0 || N<=ny) break;
                if(v[nx][ny]) return false;
            }
        }
        return true;
    }
}
```
