# 📘 15654 (N과 M(5))

## 소요시간, 메모리

256ms, 30668KB

## 풀이 방법

- 정렬한 뒤 조합을 활용하여 품
    - 재귀호출하여 M까지 cnt가 증가하면 종료하여줌

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[] arr, arr2;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[N];
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        combi(0,0);
        System.out.println(sb);
        br.close();
    }
    static void combi(int st, int cnt) {
        if(cnt == M) {
            for(int i=0; i<M; i++) sb.append(arr2[i]).append(" ");
            sb.append('\n');
            return;
        }
        for(int i=st; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr2[cnt] = arr[i];
                combi(st,cnt+1);
                visited[i] = false;
            }
        }
    }
}
```
