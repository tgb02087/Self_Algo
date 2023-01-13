# 📘 15650 (N과 M(2))

## 소요시간, 메모리

76ms, 11512KB

## 풀이 방법

- 조합을 활용하여 품
  - 재귀호출하여 M까지 cnt가 증가하면 종료하여줌

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N+1];
        sequence(1,0);
        System.out.println(sb);
        br.close();
    }
    static void sequence(int st, int cnt) {
        if(cnt==M) {
            for(int i=0; i<M; i++) sb.append(arr[i]).append(" ");
            sb.append('\n');
            return;
        }
        for(int i=st; i<=N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[cnt] = i;
                sequence(i+1,cnt+1);
                visit[i] = false;
            }
        }
    }
}
```
