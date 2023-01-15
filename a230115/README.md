# 📘 15652 (N과 M(4))

## 소요시간, 메모리

96ms, 13596KB

## 풀이 방법

- 조합을 활용하여 품
  - 재귀호출하여 M까지 cnt가 증가하면 종료하여줌
  - 비내림차순이어야 하기 때문에 재귀를 현재 arr값에 넣은 i를 인자값으로 전달함.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        combi(1,0);
        System.out.println(sb);
        br.close();
    }
    static void combi(int st, int cnt) {
        if(cnt == M) {
            for(int i=0; i<M; i++) sb.append(arr[i]).append(" ");
            sb.append('\n');
            return;
        }
        for(int i=st; i<=N; i++) {
            arr[cnt] = i;
            combi(i, cnt+1);
        }
    }
}
```
