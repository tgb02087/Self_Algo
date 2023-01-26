# 📘 2240 (자두나무)

## 소요시간, 메모리

80ms, 12208KB

## 풀이 방법

- W, T, 자두나무 밑 자리에 해당하는 공간까지 3차원 배열을 사용하여 DP로 활용
- 처음 W가 0 일때는 무조건 자두나무 밑 1에서만 있으므로 초기화.
- T가 0일때는 0 0 과 1 0 또는 0 1 중 하나 이므로 초기화 시켜준다.
- 나머지는 w-1 일때와 w일때를 비교하여 초기화 시켜준다.

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken())+1;
        int[] arr = new int[T];
        int[][][] dp = new int[T][W][3];
        for(int i=0; i<T; i++) arr[i] = Integer.parseInt(br.readLine());
        if(arr[0]==1) dp[0][0][1]++;
        else if(0<W) dp[0][1][2]++;
        for(int i=1; i<T; i++) {
            if(arr[i]==1) dp[i][0][1] = dp[i-1][0][1]+1;
            else dp[i][0][1] = dp[i-1][0][1];
        }
        for(int t=1; t<T; t++) {
            for(int w=1; w<W; w++) {
                if(arr[t]==1) {
                    dp[t][w][1] = Math.max(dp[t-1][w-1][2],dp[t-1][w][1])+1;
                    dp[t][w][2] = Math.max(dp[t-1][w-1][1],dp[t-1][w][2]);
                }
                else {
                    dp[t][w][1] = Math.max(dp[t-1][w-1][2],dp[t-1][w][1]);
                    dp[t][w][2] = Math.max(dp[t-1][w-1][1],dp[t-1][w][2])+1;
                }
            }
        }
        int max = 0;
        for(int z = 0; z<W; z++) {
            int m = Math.max(dp[T-1][z][1],dp[T-1][z][2]);
            max = Math.max(max,m);
        }
        System.out.println(max);
        br.close();
    }
}
```
