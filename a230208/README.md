# 📘 12852 (1로 만들기 2)

## 소요시간, 메모리

120ms, 20004KB

## 풀이 방법

- 2에서부터 시작해서 N까지 만들수 있는 최소한의 경우를 고려한다.
  - 메모제이션 dp배열 활용
  - 먼저 인덱스 -1 값을 세팅한 후, 3으로 나눠지는경우와 2로 나눠지는 경우 중 더 작은 경우의 수를 dp에 저장한다.
  - 각 경우의 수에서 dp에 저장하게 된 idx값을 따로 저장한다.

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] idx = new int[N+1];
        dp[1] = 0;
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] +1;
            idx[i] = i-1;
            for(int j=3; 1<j; j--) {
                if(i%j==0) {
                    if(dp[i] > dp[i/j]+1) {
                        dp[i] = dp[i/j] +1;
                        idx[i] = i/j;
                    }
                }
            }
        }
        int n = idx[N];
        sb.append(N).append(" ");
        while(n>0) {
            sb.append(n).append(" ");
            n = idx[n];
        }
        System.out.println(dp[N]);
        System.out.println(sb);
        br.close();
    }
}
```
