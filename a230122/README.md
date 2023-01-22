# 📘 9465 (스티커)

## 소요시간, 메모리

840ms, 124096KB

## 풀이 방법

- N=1,2인 경우를 제외하면 자신의 위치와 다른 곳의 idx-1,-2 의 max값들 비교하여 큰값과 더하였다

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            for(int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][N];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if(1<N) {
                dp[0][1] = dp[1][0] + arr[0][1];
                dp[1][1] = dp[0][0] + arr[1][1];
            }
            for(int i=2; i<N; i++) {
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + arr[1][i];
            }
            sb.append(Math.max(dp[0][N-1],dp[1][N-1])).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
```
