# 📘 2798 (블랙잭)

## 소요시간, 메모리

84ms, 11488KB

## 풀이 방법

- 처음 풀때 3개씩 조합할때 재귀호출을 하고 가지치기 해주는 부분이 없어서 시간초과 발생.
- 3개를 조합할떄 목표 값보다 높아진다면 바로 재귀호출 종료.

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
