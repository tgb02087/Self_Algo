# 📘 7568 (덩치)

## 소요시간, 메모리

76ms, 11572KB

## 풀이 방법

- 모든 입력값을 탐색하여 키와 몸무게가 모두 큰 경우를 카운팅

## Code

```Java
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            int cnt = 0;
            for(int j=0; j<N; j++) {
                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) cnt++;
            }
            sb.append(++cnt).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
```
