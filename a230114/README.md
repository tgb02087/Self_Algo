# 📘 15651 (N과 M(3))

## 소요시간, 메모리

392ms, 111852KB

## 풀이 방법

- 조합을 활용하여 품
  - 재귀호출하여 M까지 cnt가 증가하면 종료하여줌
  - 같은 수를 출력해야 하기 때문에 for문의 시작값을 st로 초기화할때 st 값을 +1 하지 않음.

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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[M];
        combi(0);
        System.out.println(sb);
        br.close();
    }
    static void combi(int cnt) {
        if(cnt == M) {
            for(int i=0; i<M; i++) sb.append(arr[i]).append(" ");
            sb.append('\n');
            return;
        }
        for(int i=1; i<=N; i++) {
            arr[cnt] = i;
            combi(cnt+1);
        }
    }
}
```
