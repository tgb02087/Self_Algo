# 📘 15661 (링크와 스타트)

## 소요시간, 메모리

620ms, 15324KB

## 풀이 방법

- 조합을 사용하여 풀었으며 min값이 0이라면 더이상 작은 값이 없기떄문에 바로 return해주었다.
  - 인자값을 i말고 st로 주는 실수를 하여 시간초과로 틀림.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean[] visit;
    static int N, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N];
        for(int i=1; i<=N/2; i++) combi(0,0,i);
        System.out.println(min);
        br.close();
    }
    static void combi(int st, int cnt, int n) {
        if(min==0) return;
        if(cnt == n) {
            int sum1 = 0;
            int sum2 = 0;
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    if(visit[i] && visit[j]) {
                        sum1 += map[j][i] + map[i][j];
                    }
                    else if(!visit[i] && !visit[j]) {
                        sum2 += map[j][i] + map[i][j];
                    }
                }
            }
            min = Math.min(min,Math.abs(sum1-sum2));
            return;
        }
        for(int i=st; i<N; i++) {
            visit[i] = true;
            combi(i+1,cnt+1,n);
            visit[i] = false;
        }
    }
}
```
