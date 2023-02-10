# 📘 21610 (마법사 상어와 비바라기)

## 소요시간, 메모리

156ms, 13160KB

## 풀이 방법

- 구름에 위치한 칸의 물을 1증가 시키는것을 대각선방향의 바구니 갯수추가와 같이 하여 테케를 틀림.
  - rain 메소드에서 먼저 물을 1증가 시킨후에 대각선 체크를 해줌.
- 2차원 배열을 활용하여 구름의 위치를 체크해주었다.

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    static int[] di = {0,0,-1,-1,-1,0,1,1,1};   //0 좌 좌상 상 우상 우 우하 하 좌하
    static int[] dj = {0,-1,-1,0,1,1,1,0,-1};

    static int[] ddi = {-1,-1,1,1};  //좌상 우상 우하 좌하
    static int[] ddj = {-1,1,1,-1};
    static boolean[][] cloud;
    static int[][] map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        cloud = new boolean[N][N];
        // 초기 구름
        cloud[N-1][0] = true;
        cloud[N-1][1] = true;
        cloud[N-2][0] = true;
        cloud[N-2][1] = true;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int ni = di[d] * s;
            int nj = dj[d] * s;
            cloud = move(cloud,ni,nj);
            rain();
            newCloud();
        }
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += map[i][j];
            }
        }
        System.out.println(cnt);
        br.close();
    }
    static boolean[][] move(boolean[][] cloud, int di, int dj) {
        boolean[][] temp = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(cloud[i][j]) {
                    int ni = (i+di)%N;
                    int nj = (j+dj)%N;
                    if(ni<0) ni+=N;
                    if(nj<0) nj+=N;
                    temp[ni][nj] = cloud[i][j];
                }
            }
        }
        return temp;
    }
    static void rain() {
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if(cloud[i][j]) map[i][j]++;
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(cloud[i][j]) {
                    for(int d=0; d<4; d++) {
                        int ni = i+ddi[d];
                        int nj = j+ddj[d];
                        if(ni <0 || N<=ni || nj<0 || N<= nj) continue;
                        if(map[ni][nj]>0) map[i][j]++;
                    }
                }
            }
        }
    }
    static void newCloud() {
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if(cloud[i][j]) cloud[i][j] = false;
                else {
                    if(map[i][j] > 1) {
                        cloud[i][j] = true;
                        map[i][j] -= 2;
                    }
                }
            }
        }
    }
}
```
