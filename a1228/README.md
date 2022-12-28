# 📘 11047 (동전 0)

## 소요시간, 메모리

76ms, 11512KB

## 풀이 방법

- 가장 큰 동전부터 목표치 금액을 얼마나 채울수 있을지 접근하여 품

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] won = new int[N];
        for(int i=0; i<N; i++) won[i] = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=N-1; 0<=i; i--) {
            if(won[i]<=K) {
                int n = K/won[i];
                K -= (n*won[i]);
                cnt += n;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
```
