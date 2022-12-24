# 📘 9375 (김강호)

## 소요시간, 메모리

80ms, 11812KB

## 풀이 방법

- 처음에 모든 조합을 다 확인하면서 계산했더니 시간초과 발생
- 선택받거나 선택받지않는 경우를 생각하여 계산
  - 예를 들어 모자에 {캡, 헬멧, null} 기존의 입력값에 선택받지않는경우 하나를 추가하여 조합을 계산
  - 모두 입지않은 경우를 마지막에 하나 빼준다.
- HashMap을 활용

## Code

```Java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String,Integer> map = new HashMap<>();
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine()," ");
                st.nextToken();
                String cloth = st.nextToken();
                if(map.containsKey(cloth)) map.put(cloth,map.get(cloth)+1);
                else map.put(cloth,1);
            }
            int sum = 1;
            for(int value : map.values()) sum *= (value + 1);
            sb.append(--sum).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
```
