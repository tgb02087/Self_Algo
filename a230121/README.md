# 📘 15657 (N과 M(8))

## 소요시간, 메모리

128ms, 17872KB

## 풀이 방법

- 조합에 백트래킹을 활용

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static StringBuilder sb;
    static int[] arr, ans;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        combi(0,0);
        System.out.println(sb);
        br.close();
    }
    static void combi(int st, int cnt) {
        if(cnt==M) {
            for(int i=0; i<M; i++) sb.append(ans[i]).append(" ");
            sb.append('\n');
            return;
        }
        for(int i=st; i<N; i++) {
            ans[cnt] = arr[i];
            combi(i,cnt+1);
        }
    }
}
```
